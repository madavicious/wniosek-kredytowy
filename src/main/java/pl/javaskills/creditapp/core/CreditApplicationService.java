package pl.javaskills.creditapp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.Person;

import java.util.UUID;

public class CreditApplicationService {
    private final Logger log = LoggerFactory.getLogger(CreditApplicationService.class);

    private final PersonScoringCalculator personScoringCalculator;
    private  final CreditRatingCalculator creditRatingCalculator;

    public CreditApplicationService(PersonScoringCalculator personScoringCalculator, CreditRatingCalculator creditRatingCalculator) {
        this.personScoringCalculator = personScoringCalculator;
        this.creditRatingCalculator = creditRatingCalculator;
    }


    public CreditApplicationDecision getDecision (LoanApplication loanApplication) {
        String id = UUID.randomUUID().toString();
        log.info("Application id is " + id);
        MDC.put("id", id);
        Person person = loanApplication.getPerson();
        CreditApplicationDecision decision;
        if (personScoringCalculator.calculate(person) < 300) {
            decision = new CreditApplicationDecision(DecisionType.NEGATIVE_SCORING, loanApplication.getPerson().getPersonalData(), null);
        } else if (personScoringCalculator.calculate(person) >= 300 && personScoringCalculator.calculate(loanApplication.getPerson()) <= 400) {
            decision = new CreditApplicationDecision(DecisionType.CONTACT_REQUIRED, loanApplication.getPerson().getPersonalData(), null);
        }
        else {
            double creditRate = creditRatingCalculator.calculaate(loanApplication);
            if (creditRate >= loanApplication.getPurposeOfLoan().getAmount()) {
                decision = new CreditApplicationDecision(DecisionType.POSITIVE, loanApplication.getPerson().getPersonalData(), creditRate);
            }else{
                decision = new CreditApplicationDecision(DecisionType.NEGATIVE_RATING, loanApplication.getPerson().getPersonalData(), creditRate);
            }

        }
        log.info("Decision = " + decision.getType());
        return decision;
    }
}
