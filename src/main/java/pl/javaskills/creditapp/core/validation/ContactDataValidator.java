package pl.javaskills.creditapp.core.validation;

import pl.javaskills.creditapp.core.exception.ValidationException;
import pl.javaskills.creditapp.core.model.ContactData;
import pl.javaskills.creditapp.core.model.LoanApplication;

import static pl.javaskills.creditapp.core.Constants.EMAIL_REGEX;
import static pl.javaskills.creditapp.core.Constants.PHONE_REGEX;


public class ContactDataValidator implements Validator{
    
    @Override
    public void validate(LoanApplication creditApplication) throws ValidationException {
        ContactData contactData = creditApplication.getPerson().getContactData();

        ValidationUtils.validateNotNull("email", contactData.getEmail());
        ValidationUtils.validateRegex("name", contactData.getEmail(), EMAIL_REGEX);

        ValidationUtils.validateNotNull("phoneNumber", contactData.getPhoneNumber());
        ValidationUtils.validateRegex("lastName", contactData.getPhoneNumber(), PHONE_REGEX);

    }
}
