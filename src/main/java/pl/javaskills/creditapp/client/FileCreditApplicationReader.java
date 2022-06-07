package pl.javaskills.creditapp.client;

import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.util.ObjectMapperService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCreditApplicationReader implements CreditAplicationReader{

    private final Path path;

    public FileCreditApplicationReader(Path path) {
        this.path = path;
    }

    @Override
    public LoanApplication read() {
        try {
            String content = Files.readString(path);
            return ObjectMapperService.OBJECT_MAPPER.readValue(content, LoanApplication.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }
}
