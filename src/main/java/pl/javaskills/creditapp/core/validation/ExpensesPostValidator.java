package pl.javaskills.creditapp.core.validation;

import pl.javaskills.creditapp.core.exception.RequirementNotMetCause;
import pl.javaskills.creditapp.core.exception.RequirementNotMetException;
import pl.javaskills.creditapp.core.model.ExpenseType;
import pl.javaskills.creditapp.core.model.LoanApplication;

public class ExpensesPostValidator implements PostValidator{
    @Override
    public void validate(LoanApplication loanApplication, int scoring, double rating) throws RequirementNotMetException {
        double balance = loanApplication.getPerson().getBalance();
        double personalExpenses = loanApplication.getPerson().getFinanceData().getSumOfExpenses(ExpenseType.PERSONAL);

        double percentage = personalExpenses * 100 / balance;

        if (percentage > 40) {
            throw new RequirementNotMetException(RequirementNotMetCause.TOO_HIGH_PERSONAL_EXPENSES);
        }
    }
}
