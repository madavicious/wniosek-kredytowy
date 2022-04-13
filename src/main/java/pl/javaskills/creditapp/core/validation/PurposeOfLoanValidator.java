package pl.javaskills.creditapp.core.validation;

import pl.javaskills.creditapp.core.exception.ValidationException;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.PurposeOfLoan;

public class PurposeOfLoanValidator implements Validator{
    
    @Override
    public void validate(LoanApplication loanApplication) throws ValidationException {
        final PurposeOfLoan purposeOfLoan = loanApplication.getPurposeOfLoan();

        ValidationUtils.validateNotNull("purposeOfLoanType", purposeOfLoan.getPurposeOfLoanType());
        ValidationUtils.validateMinValue("purposeOfLoanAmount", 0.0, purposeOfLoan.getAmount());
    }
}
