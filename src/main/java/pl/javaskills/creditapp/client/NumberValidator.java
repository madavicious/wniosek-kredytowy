package pl.javaskills.creditapp.client;

import pl.javaskills.creditapp.core.Constants;

public class NumberValidator {

    public static boolean validateDoubles(String input, double min, double max){
        if (input.matches(Constants.DOUBLE_REGEX)){
            double value = Double.valueOf(input);
            if (value >= min && value <= max){
                return true;
            }
        }
        return false;
    }

    public static boolean validateInteger(String input, int min, int max){
        if (input.matches(Constants.INTEGER_REGEX)){
            int value = Integer.valueOf(input);
            if (value >= min && value <= max){
                return true;
            }
        }
        return false;
    }

    public static boolean validateInteger(String input, int ... allowedValues){
        if (input.matches(Constants.INTEGER_REGEX)){
            int value = Integer.valueOf(input);
            for (int allowedValue : allowedValues){
                if (allowedValue == value) {
                    return true;
                }
            }
        }
        return false;
    }
}
