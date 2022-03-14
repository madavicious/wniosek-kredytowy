package pl.javaskills.creditapp.client;

import pl.javaskills.creditapp.core.model.Constants;

public class PhoneValidator {
    public static boolean validate(String input){
        return input.matches(Constants.PHONE_REGEX);
    }
}
