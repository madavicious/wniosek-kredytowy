package pl.javaskills.creditapp;

import pl.javaskills.creditapp.client.ConsoleReader;
import pl.javaskills.creditapp.core.*;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.scoring.EducationCalculator;
import pl.javaskills.creditapp.core.scoring.IncomeCalculator;
import pl.javaskills.creditapp.core.scoring.MaritalStatusCalculator;


public class Main {

    public static void main(String[] args) {

        EducationCalculator educationCalculator = new EducationCalculator();
        MaritalStatusCalculator maritalStatusCalculator = new MaritalStatusCalculator();
        IncomeCalculator incomeCalculator = new IncomeCalculator();
        SelfEmployedScoringCalculator selfEmployedScoringCalculator = new SelfEmployedScoringCalculator();
        PersonScoringCalculatorFactory personScoringCalculatorFactory = new PersonScoringCalculatorFactory(selfEmployedScoringCalculator, educationCalculator, maritalStatusCalculator, incomeCalculator);
        CreditApplicationService service = new CreditApplicationService(personScoringCalculatorFactory, new CreditRatingCalculator());
        LoanApplication loanApplication = new ConsoleReader().readInputParameters();

        CreditApplicationDecision decision = service.getDecision(loanApplication);

        System.out.println(decision.getDecisionString());
    }
}
