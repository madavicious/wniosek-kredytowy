package pl.javaskills.creditapp.core.exception;

public class NotNullException extends ValidationException{
    public NotNullException(String field) {
        super(String.format("Field %s should not be null", field));
    }
}
