package pl.javaskills.creditapp.core.validation;

import pl.javaskills.creditapp.core.exception.ValidationException;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.PersonalData;

import static pl.javaskills.creditapp.core.model.Constants.*;


public class PersonalDataValidator implements Validator{
    
    @Override
    public void validate(LoanApplication loanApplication) throws ValidationException {
        PersonalData personalData = loanApplication.getPerson().getPersonalData();

        ValidationUtils.validateNotNull("name", personalData.getName());
        ValidationUtils.validateRegex("name", personalData.getName(), NAME_REGEX);

        ValidationUtils.validateNotNull("lastName", personalData.getLastName());
        ValidationUtils.validateRegex("lastName", personalData.getLastName(), LAST_NAME_REGEX);

        ValidationUtils.validateNotNull("mothersMaidenName", personalData.getMothersMaidenName());
        ValidationUtils.validateRegex("mothersMaidenName", personalData.getMothersMaidenName(), LAST_NAME_REGEX);

        ValidationUtils.validateNotNull("education", personalData.getEducation());
        ValidationUtils.validateNotNull("maritalStatus", personalData.getMaritalStatus());
    }
}
