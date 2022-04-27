package pl.javaskills.creditapp.core.exception;

import java.util.Set;

public class ExactlyOneNotNullException extends ValidationException{
    public ExactlyOneNotNullException(Set<String> fieldNames) {
        super(String.format("Exactly one of fields must be not null: %s", fieldNames));
    }
}
