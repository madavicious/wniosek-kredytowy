package pl.javaskills.creditapp.core.validation;

import pl.javaskills.creditapp.core.exception.ValidationException;
import pl.javaskills.creditapp.core.model.LoanApplication;

public class CreditApplicationValidator implements Validator{
    private final PersonValidator personValidator;
    private final PurposeOfLoanValidator purposeOfLoanValidator;

    public CreditApplicationValidator(PersonValidator personValidator, PurposeOfLoanValidator purposeOfLoanValidator) {
        this.personValidator = personValidator;
        this.purposeOfLoanValidator = purposeOfLoanValidator;
    }

    @Override
    public void validate(LoanApplication loanApplication) throws ValidationException {

        ValidationUtils.validateNotNull("person", loanApplication.getPerson());
        personValidator.validate(loanApplication);

        ValidationUtils.validateNotNull("purposeOfLoan", loanApplication.getPurposeOfLoan());
        purposeOfLoanValidator.validate(loanApplication);
    }
}
