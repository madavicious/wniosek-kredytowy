package pl.javaskills.creditapp;

import pl.javaskills.creditapp.client.ConsoleReader;
import pl.javaskills.creditapp.core.CreditApplicationDecision;
import pl.javaskills.creditapp.core.CreditApplicationService;
import pl.javaskills.creditapp.core.CreditRatingCalculator;
import pl.javaskills.creditapp.core.PersonScoringCalculator;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.scoring.EducationCalculator;
import pl.javaskills.creditapp.core.scoring.IncomeCalculator;
import pl.javaskills.creditapp.core.scoring.MaritalStatusCalculator;


public class Main {

    public static void main(String[] args) {
        PersonScoringCalculator calculator = new PersonScoringCalculator(new EducationCalculator(), new MaritalStatusCalculator(), new IncomeCalculator());
        CreditApplicationService service = new CreditApplicationService(calculator, new CreditRatingCalculator());
        LoanApplication loanApplication = new ConsoleReader().readInputParameters();

        CreditApplicationDecision decision = service.getDecision(loanApplication);

        System.out.println(decision.getDecisionString());
    }
}
