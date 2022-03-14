package pl.javaskills.creditapp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.Person;

import java.util.UUID;

import static pl.javaskills.creditapp.core.DecisionType.*;
import static pl.javaskills.creditapp.core.model.Constants.MIN_LOAN_AMOUNT_MORTGAGE;

public class CreditApplicationService {
    private final Logger log = LoggerFactory.getLogger(CreditApplicationService.class);

    private final PersonScoringCalculatorFactory personScoringCalculatorFactory;
    private  final CreditRatingCalculator creditRatingCalculator;

    public CreditApplicationService(PersonScoringCalculatorFactory personScoringCalculatorFactory, CreditRatingCalculator creditRatingCalculator) {
        this.personScoringCalculatorFactory = personScoringCalculatorFactory;
        this.creditRatingCalculator = creditRatingCalculator;
    }


    public CreditApplicationDecision getDecision (LoanApplication loanApplication) {
        String id = UUID.randomUUID().toString();
        log.info("Application id is " + id);
        MDC.put("id", id);

        Person person = loanApplication.getPerson();
        int scoring = personScoringCalculatorFactory.getCalculator(person).calculate(person);
        CreditApplicationDecision decision;
        if (scoring < 300) {
            decision = new CreditApplicationDecision(NEGATIVE_SCORING, loanApplication.getPerson().getPersonalData(), null, scoring);
        } else if (scoring >= 300 && scoring <= 400) {
            decision = new CreditApplicationDecision(CONTACT_REQUIRED, loanApplication.getPerson().getPersonalData(), null, scoring);
        }
        else {
            double creditRate = creditRatingCalculator.calculaate(loanApplication);
            if (creditRate >= loanApplication.getPurposeOfLoan().getAmount()) {
                if (loanApplication.getPurposeOfLoan().getAmount() < MIN_LOAN_AMOUNT_MORTGAGE) {
                    decision = new CreditApplicationDecision(NEGATIVE_REQUIREMENTS_NOT_MET, loanApplication.getPerson().getPersonalData(), creditRate, scoring);
                } else {
                    decision = new CreditApplicationDecision(POSITIVE, loanApplication.getPerson().getPersonalData(), creditRate, scoring);
                }
            }else{
                decision = new CreditApplicationDecision(NEGATIVE_RATING, loanApplication.getPerson().getPersonalData(), creditRate, scoring);
            }

        }
        log.info("Decision = " + decision.getType());
        return decision;
    }
}
