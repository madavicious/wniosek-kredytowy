package pl.javaskills.creditapp.core.validation;

import pl.javaskills.creditapp.core.exception.ValidationException;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.di.Inject;

public class CreditApplicationValidator implements Validator {

    @Inject
    private ObjectValidator objectValidator;

    public CreditApplicationValidator(ObjectValidator objectValidator) {
        this.objectValidator = objectValidator;
    }

    public CreditApplicationValidator(){}

    @Override
    public void validate(LoanApplication loanApplication) throws ValidationException {

        try {
            objectValidator.validate(loanApplication);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}