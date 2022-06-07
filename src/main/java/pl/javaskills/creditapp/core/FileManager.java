package pl.javaskills.creditapp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.NaturalPerson;
import pl.javaskills.creditapp.core.model.ProcessedCreditApplication;
import pl.javaskills.creditapp.core.model.SelfEmployed;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
    private static final Logger log = LoggerFactory.getLogger(FileManager.class);
    private static final Path HOME_DIR = Paths.get(Constants.OUTPUT_PATH);
    private static final Path SELF_EMPLOYED_DIR = HOME_DIR.resolve(("self-employed"));
    private static final Path NATURAL_PERSON_DIR = HOME_DIR.resolve("natural-person");

    public void write(ProcessedCreditApplication creditApplication) throws IOException {
        Path personIdDir = getPersonDir(creditApplication);
        if(!Files.exists(personIdDir)){
            Files.createDirectory(personIdDir);
        }
        Path appIdFile = personIdDir.resolve(creditApplication.getApplication().getId() + ".dat");
        if(!Files.exists(appIdFile)){
            Files.createFile(appIdFile);
        }

        try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(baos)) {
            out.writeObject(creditApplication);
            Files.write(appIdFile, baos.toByteArray());
            log.info("Application with id {} successfully saved", creditApplication.getApplication().getId());
        }
    }

    private Path getPersonDir(ProcessedCreditApplication creditApplication) {
        return creditApplication.getApplication().isNaturalPerson() ?
                NATURAL_PERSON_DIR.resolve(((NaturalPerson)creditApplication.getApplication().getPerson()).getPesel()) :
                SELF_EMPLOYED_DIR.resolve(((SelfEmployed)creditApplication.getApplication().getPerson()).getNip());
    }

    private Path getPersonDir(String personId){
        String id = personId.replace("N-", "").replace("S-", "");
        return personId.startsWith("N-") ?
                NATURAL_PERSON_DIR.resolve(id) :
                SELF_EMPLOYED_DIR.resolve(id);
    }

    public ProcessedCreditApplication read(String appId, String personId) throws IOException, ClassNotFoundException {
        Path personIdDir = getPersonDir(personId);
        Path appIdFile = personIdDir.resolve(appId + ".dat");
        if (Files.exists(appIdFile)) {
            try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(Files.readAllBytes(appIdFile)))) {
                return (ProcessedCreditApplication) in.readObject();
            }
        } else {
            log.error("Application with appId {} not found", appId);
            throw new IllegalStateException(String.format("Application with appId %s not found", appId));
        }
    }

    public void init() throws IOException {
        if(!Files.exists(HOME_DIR)){
            Files.createDirectory(HOME_DIR);
        }

        if(!Files.exists(SELF_EMPLOYED_DIR)){
            Files.createDirectory(SELF_EMPLOYED_DIR);
        }

        if(!Files.exists(NATURAL_PERSON_DIR)){
            Files.createDirectory(NATURAL_PERSON_DIR);
        }
    }
}
