package pl.javaskills.creditapp.core.validation;

import pl.javaskills.creditapp.core.exception.ValidationException;
import pl.javaskills.creditapp.core.model.FinanceData;
import pl.javaskills.creditapp.core.model.LoanApplication;


public class FinanceDataValidator implements Validator{
    
    @Override
    public void validate(LoanApplication creditApplication) throws ValidationException {
        FinanceData financeData = creditApplication.getPerson().getFinanceData();
    }
}
