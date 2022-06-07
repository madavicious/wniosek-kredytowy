package pl.javaskills.creditapp.core.scoring;

import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.Guarantor;
import pl.javaskills.creditapp.core.model.LoanApplication;

import org.slf4j.Logger;

public class GuarantorsCalculator implements ScoringCalculator{

    private final Logger log = LoggerFactory.getLogger(GuarantorsCalculator.class);

    @Override
    public int calculate(LoanApplication creditApplication){
        int scoringAgeUnder40 = 0;
        int scoringOthers = 0;
        for (Guarantor g : creditApplication.getGuarantors()){
            if (g.getAge() < 40){
                scoringAgeUnder40 += 50;
            } else{
                scoringOthers += 25;
            }
        }

        if (scoringAgeUnder40 >= 0){
            log.info("Points for guarantors under age of 40 = " + scoringAgeUnder40 + ". " + ScoringUtils.getPointsString(scoringAgeUnder40));
        }

        if (scoringOthers >= 0){
            log.info("Points for other guarantors = " + scoringOthers + ". " + ScoringUtils.getPointsString(scoringOthers));
        }

        return scoringAgeUnder40 + scoringOthers;
    }

}
