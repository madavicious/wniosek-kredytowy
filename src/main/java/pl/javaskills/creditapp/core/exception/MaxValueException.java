package pl.javaskills.creditapp.core.exception;

public class MaxValueException extends ValidationException{

    public MaxValueException(String field, int extMaxValue) {
        super(String.format("Field %s is invalid. Max value=%s", field, extMaxValue));
    }

    public MaxValueException(String field, double extMaxValue) {
        super(String.format("Field %s is invalid. Max value=%s", field, extMaxValue));
    }
}
