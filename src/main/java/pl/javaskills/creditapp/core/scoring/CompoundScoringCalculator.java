package pl.javaskills.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.Person;

public class CompoundScoringCalculator implements PersonCalculator{

    private static final Logger log = LoggerFactory.getLogger(CompoundScoringCalculator.class);
    private final PersonCalculator[] calculators;

    public CompoundScoringCalculator(PersonCalculator... calculators) {
        this.calculators = calculators;
    }

    @Override
    public int calculate(Person person){
        int scoring = 0;

        for(PersonCalculator calculator : calculators) {
            scoring += calculator.calculate(person);
        }
        log.info("Calculated scoring = " + scoring + " points");
        return scoring;
    }
}
