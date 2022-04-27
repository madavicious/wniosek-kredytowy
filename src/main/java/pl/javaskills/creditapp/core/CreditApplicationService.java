package pl.javaskills.creditapp.core;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import pl.javaskills.creditapp.core.exception.RequirementNotMetException;
import pl.javaskills.creditapp.core.exception.ValidationException;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.validation.CompoundPostValidator;
import pl.javaskills.creditapp.core.validation.CreditApplicationValidator;
import pl.javaskills.creditapp.di.Inject;

import static pl.javaskills.creditapp.core.DecisionType.*;

public class CreditApplicationService {
    private final Logger log = LoggerFactory.getLogger(CreditApplicationService.class);

    @Inject
    private PersonScoringCalculatorFactory personScoringCalculatorFactory;
    @Inject
    private CreditRatingCalculator creditRatingCalculator;
    @Inject
    private CreditApplicationValidator creditApplicationValidator;
    @Inject
    private CompoundPostValidator compoundPostValidator;

    public CreditApplicationService(PersonScoringCalculatorFactory personScoringCalculatorFactory, CreditRatingCalculator creditRatingCalculator, CreditApplicationValidator creditApplicationValidator, CompoundPostValidator compoundPostValidator) {
        this.personScoringCalculatorFactory = personScoringCalculatorFactory;
        this.creditRatingCalculator = creditRatingCalculator;
        this.creditApplicationValidator = creditApplicationValidator;
        this.compoundPostValidator = compoundPostValidator;
    }

    public CreditApplicationService(){}


    public CreditApplicationDecision getDecision (LoanApplication loanApplication) {
        String id = loanApplication.getId().toString();
        MDC.put("id", id);

        try {
            Person person = loanApplication.getPerson();
            //step1
            creditApplicationValidator.validate(loanApplication);

            //step2
            int scoring = personScoringCalculatorFactory.getCalculator(person).calculate(loanApplication);

            //step3
            double creditRate = creditRatingCalculator.calculate(loanApplication);

            //step4
            try {
                compoundPostValidator.validate(loanApplication, scoring, creditRate);
            } catch (RequirementNotMetException reqEx) {
                 return new CreditApplicationDecision(NEGATIVE_REQUIREMENTS_NOT_MET, person.getPersonalData(), creditRate, scoring, reqEx.getRequirementNotMetCause());
            }
            CreditApplicationDecision decision = getCreditApplicationDecision(loanApplication, person, scoring, creditRate);
            log.info("Decision = " + decision.getType());
            return decision;
        }catch (ValidationException validationException){
            log.error(validationException.getMessage());
            throw new IllegalStateException();
        }catch (Exception exception){
            exception.printStackTrace();
            throw new IllegalStateException();
        } finally {
            log.info("Application processing is finished");
        }
    }

    @NotNull
    private CreditApplicationDecision getCreditApplicationDecision(LoanApplication loanApplication, Person person, int scoring, double creditRate) {
        CreditApplicationDecision decision;
        if (scoring < 300) {
            decision = new CreditApplicationDecision(NEGATIVE_SCORING, person.getPersonalData(), creditRate, scoring);
        } else if (scoring >= 300 && scoring <= 400) {
            decision = new CreditApplicationDecision(CONTACT_REQUIRED, person.getPersonalData(), creditRate, scoring);
        } else {
            if (creditRate >= loanApplication.getPurposeOfLoan().getAmount()) {
                decision = new CreditApplicationDecision(POSITIVE, person.getPersonalData(), creditRate, scoring);
            } else {
                decision = new CreditApplicationDecision(NEGATIVE_RATING, person.getPersonalData(), creditRate, scoring);
            }
        }
        return decision;
    }
}
