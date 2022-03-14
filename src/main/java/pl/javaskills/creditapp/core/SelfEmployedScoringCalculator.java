
package pl.javaskills.creditapp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.SelfEmployed;
import pl.javaskills.creditapp.core.scoring.PersonCalculator;
import pl.javaskills.creditapp.core.scoring.ScoringUtils;

public class SelfEmployedScoringCalculator implements PersonCalculator {
    private static final Logger log = LoggerFactory.getLogger(SelfEmployedScoringCalculator.class);



    @Override
    public int calculate(SelfEmployed selfEmployed) {
            if(selfEmployed.getYearsSinceFounded() < 2) {
                log.info("Years since founded = " + selfEmployed.getYearsSinceFounded() + ScoringUtils.getPointsString(-200));
                return -200;
            }
            return 0;
    }

}
