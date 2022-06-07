package pl.javaskills.creditapp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.Person;

import java.math.BigDecimal;

public class CreditRatingCalculator {
    private static final Logger log = LoggerFactory.getLogger(CreditRatingCalculator.class);

    public double calculate(LoanApplication creditApplication) {
        Person person = creditApplication.getPerson();
        double creditRate = person.getIncomePerFamilyMember() * 12 * creditApplication.getPurposeOfLoan().getPeriod();
        switch (creditApplication.getPurposeOfLoan().getPurposeOfLoanType()) {
            case PERSONAL_LOAN -> {
                creditRate *= Constants.PERSONAL_LOAN_LOAN_RATE;
                break;
            }
            case MORTGAGE -> {
                creditRate *= Constants.MORTGAGE_LOAN_RATE;
                break;
            }
        }
        log.info("Calculated rating = " + new BigDecimal(creditRate).setScale(2));
        return creditRate;
    }

}
