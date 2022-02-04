package pl.javaskills.creditapp.core;

import pl.javaskills.creditapp.core.model.Constants;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.Person;

public class CreditRatingCalculator {

    public double calculaate(LoanApplication loanApplication) {
        Person person = loanApplication.getPerson();
        double creditRate = person.getIncomePerFamilyMember() * 12 * loanApplication.getPurposeOfLoan().getPeriod();
        switch (loanApplication.getPurposeOfLoan().getPurposeOfLoanType()) {
            case PERSONAL_LOAN -> {
                creditRate *= Constants.PERSONAL_LOAN_LOAN_RATE;
                break;
            }
            case MORTGAGE -> {
                creditRate *= Constants.MORTGAGE_LOAN_RATE;
                break;
            }
        }
        return creditRate;
    }

}
