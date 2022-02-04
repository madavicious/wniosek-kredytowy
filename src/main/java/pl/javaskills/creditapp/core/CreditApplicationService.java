package pl.javaskills.creditapp.core;

import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.Person;

public class CreditApplicationService {

    private final PersonScoringCalculator personScoringCalculator;
    private  final CreditRatingCalculator creditRatingCalculator;

    public CreditApplicationService(PersonScoringCalculator personScoringCalculator, CreditRatingCalculator creditRatingCalculator) {
        this.personScoringCalculator = personScoringCalculator;
        this.creditRatingCalculator = creditRatingCalculator;
    }


    public CreditApplicationDecision getDecision (LoanApplication loanApplication) {
        Person person = loanApplication.getPerson();
        
        if (personScoringCalculator.calculate(person) < 300) {
            return new CreditApplicationDecision(DecisionType.NEGATIVE_SCORING, loanApplication.getPerson().getPersonalData(), null);
        } else if (personScoringCalculator.calculate(person) >= 300 && personScoringCalculator.calculate(loanApplication.getPerson()) <= 400) {
            return new CreditApplicationDecision(DecisionType.CONTACT_REQUIRED, loanApplication.getPerson().getPersonalData(), null);
        }
        else {
            double creditRate = creditRatingCalculator.calculaate(loanApplication);
            if (creditRate >= loanApplication.getPurposeOfLoan().getAmount()) {
             //   System.out.println(creditRate + " " + loanApplication.getPurposeOfLoan().getAmount());
                return new CreditApplicationDecision(DecisionType.POSITIVE, loanApplication.getPerson().getPersonalData(), creditRate);
            }else{
                return new CreditApplicationDecision(DecisionType.NEGATIVE_RATING, loanApplication.getPerson().getPersonalData(), creditRate);
            }

        }
    }
}
