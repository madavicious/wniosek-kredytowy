package pl.javaskills.creditapp.core.exception;

public class MinValueException extends ValidationException{

    public MinValueException(String field, int extMinValue) {
        super(String.format("Field %s is invalid. Min value=%s", field, extMinValue));
    }

    public MinValueException(String field, double extMinValue) {
        super(String.format("Field %s is invalid. Min value=%s", field, extMinValue));
    }
}
