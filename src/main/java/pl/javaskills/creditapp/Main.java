package pl.javaskills.creditapp;

import pl.javaskills.creditapp.client.ConsoleReader;
import pl.javaskills.creditapp.core.CreditApplicationDecision;
import pl.javaskills.creditapp.core.CreditApplicationService;
import pl.javaskills.creditapp.core.CreditRatingCalculator;
import pl.javaskills.creditapp.core.PersonScoringCalculator;
import pl.javaskills.creditapp.core.model.LoanApplication;


public class Main {

    public static void main(String[] args) {
        LoanApplication loanApplication = new ConsoleReader().readInputParameters();
        PersonScoringCalculator calculator = new PersonScoringCalculator();
        CreditApplicationService service = new CreditApplicationService(calculator, new CreditRatingCalculator());
        CreditApplicationDecision decision = service.getDecision(loanApplication);

        System.out.println(decision.getDecisionString());

    }
}
