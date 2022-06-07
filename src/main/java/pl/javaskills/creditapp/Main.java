package pl.javaskills.creditapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.client.CreditAplicationReader;
import pl.javaskills.creditapp.client.DummyCreditApplicationReader;
import pl.javaskills.creditapp.client.FileCreditApplicationReader;
import pl.javaskills.creditapp.core.Constants;
import pl.javaskills.creditapp.core.CreditApplicationManager;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.validation.CompoundPostValidator;
import pl.javaskills.creditapp.core.validation.ExpensesPostValidator;
import pl.javaskills.creditapp.core.validation.ObjectValidator;
import pl.javaskills.creditapp.core.validation.PurposeOfLoanPostValidator;
import pl.javaskills.creditapp.core.validation.reflection.*;
import pl.javaskills.creditapp.di.ClassInitializer;

import java.nio.file.*;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;


public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    static {
        TimeZone.setDefault(TimeZone.getTimeZone(Constants.DEFAULT_SYSTEM_ZONE_ID));
        Locale.setDefault(Constants.DEFAULT_LOCALE);
    }

    public static void main(String[] args) throws Exception {
        CreditAplicationReader reader = new DummyCreditApplicationReader();
        List<FieldAnnotationProcessor> fieldProcessors = List.of(new NotNullAnnotationProcessor(), new RegexAnnotationProcessor());
        List<ClassAnnotationProcessor> classProcessors = List.of(new ExactlyOneNotNullAnnotationProcessor());
        final ObjectValidator objectValidator = new ObjectValidator(fieldProcessors, classProcessors);
        CompoundPostValidator compoundPostValidator = new CompoundPostValidator(new PurposeOfLoanPostValidator(), new ExpensesPostValidator());
        ClassInitializer classInitializer = new ClassInitializer();
        classInitializer.registerInstance(compoundPostValidator);
        classInitializer.registerInstance(objectValidator);
        CreditApplicationManager manager = (CreditApplicationManager) classInitializer.createInstance(CreditApplicationManager.class);

        manager.init();

        if(args!=null && args.length == 2 && args[1].matches("[SN]-\\d*")){
            String appId = args[0];
            String personId = args[1];
            manager.loadApplication(appId,personId);
        } else {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path homeDir = Paths.get(Constants.OUTPUT_PATH);
            homeDir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
            WatchKey watchKey;
            while((watchKey = watchService.take()) != null){
                log.info("New event fired");
                for(WatchEvent event : watchKey.pollEvents()){
                    log.info("New file detected {}", event.context());
                    if(event.context().toString().endsWith(".json")){
                        Path pathToFile = homeDir.resolve(event.context().toString());
                        final LoanApplication loanApplication = new FileCreditApplicationReader(pathToFile).read();
                        manager.add(loanApplication);
                        loanApplication.init();
                        Files.deleteIfExists(pathToFile);
                    } else{
                        log.info("File processing {} skipped", event.context());
                    }
                }
                manager.startProcessing();
                watchKey.reset();
            }
        }
    }
}
