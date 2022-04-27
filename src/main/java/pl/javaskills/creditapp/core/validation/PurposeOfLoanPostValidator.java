package pl.javaskills.creditapp.core.validation;

import pl.javaskills.creditapp.core.exception.RequirementNotMetCause;
import pl.javaskills.creditapp.core.exception.RequirementNotMetException;
import pl.javaskills.creditapp.core.model.LoanApplication;

import static pl.javaskills.creditapp.core.model.Constants.MIN_LOAN_AMOUNT_MORTGAGE;

public class PurposeOfLoanPostValidator implements PostValidator{
    @Override
    public void validate(LoanApplication loanApplication, int scoring, double rating) throws RequirementNotMetException {
        if (loanApplication.getPurposeOfLoan().getAmount() < MIN_LOAN_AMOUNT_MORTGAGE) {
            throw new RequirementNotMetException(RequirementNotMetCause.TOO_LOW_LOAN_AMOUNT);
        }
    }
}
