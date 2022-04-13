package pl.javaskills.creditapp.core.validation;

import pl.javaskills.creditapp.core.exception.*;

public class ValidationUtils {
    public static void validateNotNull(String field, Object obj) throws ValidationException{
        if(obj == null){
            throw new NotNullException(field);
        }
    }

    public static void validateRegex(String field, String value, String regex) throws ValidationException{
        if(!value.matches(regex)){
            throw new RegexException(field);
        }
    }

    public static void validateMinValue(String field, int extMinValue, int actualMinValue) throws ValidationException{
        if(actualMinValue <= extMinValue){
            throw new MinValueException(field, extMinValue);
        }
    }

    public static void validateMinValue(String field, double extMinValue, double actualMinValue) throws ValidationException{
        if(actualMinValue <= extMinValue){
            throw new MinValueException(field, extMinValue);
        }
    }

    public static void validateMaxValue(String field, int extMaxValue, int actualMaxValue) throws ValidationException{
        if(actualMaxValue >= extMaxValue){
            throw new MaxValueException(field, extMaxValue);
        }
    }

    public static void validateMaxValue(String field, double extMaxValue, double actualMaxValue) throws ValidationException{
        if(actualMaxValue >= extMaxValue){
            throw new MaxValueException(field, extMaxValue);
        }
    }
}
