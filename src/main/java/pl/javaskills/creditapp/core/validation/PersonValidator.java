package pl.javaskills.creditapp.core.validation;

import pl.javaskills.creditapp.core.exception.ValidationException;
import pl.javaskills.creditapp.core.model.LoanApplication;

public class PersonValidator implements Validator{
    private final PersonalDataValidator personalDataValidator;
    public PersonValidator(PersonalDataValidator personalDataValidator) {
        this.personalDataValidator = personalDataValidator;
    }


    @Override
    public void validate(LoanApplication loanApplication) throws ValidationException {
        ValidationUtils.validateNotNull("personalData", loanApplication.getPerson().getPersonalData());
        personalDataValidator.validate(loanApplication);

        ValidationUtils.validateNotNull("financeData", loanApplication.getPerson().getFinanceData());
        personalDataValidator.validate(loanApplication);
    }
}
