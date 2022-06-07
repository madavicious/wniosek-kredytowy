package pl.javaskills.creditapp.core;


import pl.javaskills.creditapp.core.model.NaturalPerson;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.model.SelfEmployed;
import pl.javaskills.creditapp.core.scoring.*;
import pl.javaskills.creditapp.di.Inject;

public class PersonScoringCalculatorFactory {

    @Inject
    private SelfEmployedScoringCalculator selfEmployedScoringCalculator;
    @Inject
    private EducationCalculator educationCalculator;
    @Inject
    private MaritalStatusCalculator maritalStatusCalculator;
    @Inject
    private IncomeCalculator incomeCalculator;
    @Inject
    private GuarantorsCalculator guarantorsCalculator;
    //@Inject
    //private BikScoringCalculator bikScoringCalculator;

    public PersonScoringCalculatorFactory(SelfEmployedScoringCalculator selfEmployedScoringCalculator,
                                          EducationCalculator educationCalculator, MaritalStatusCalculator maritalStatusCalculator,
                                          IncomeCalculator incomeCalculator, GuarantorsCalculator guarantorsCalculator
                                          //BikScoringCalculator bikScoringCalculator
                                            ) {
        this.selfEmployedScoringCalculator = selfEmployedScoringCalculator;
        this.educationCalculator = educationCalculator;
        this.maritalStatusCalculator = maritalStatusCalculator;
        this.incomeCalculator = incomeCalculator;
        this.guarantorsCalculator = guarantorsCalculator;
        //this.bikScoringCalculator = bikScoringCalculator;
    }

    public PersonScoringCalculatorFactory(){}

    public ScoringCalculator getCalculator(Person person) {
        if(person instanceof NaturalPerson) {
            return new CompoundScoringCalculator(guarantorsCalculator, educationCalculator, maritalStatusCalculator, incomeCalculator
                    //bikScoringCalculator
            );
        } else if(person instanceof SelfEmployed){
            return new CompoundScoringCalculator(guarantorsCalculator, educationCalculator, maritalStatusCalculator, incomeCalculator, selfEmployedScoringCalculator
                    //bikScoringCalculator
                    );
        }
        return null;
    }
}
