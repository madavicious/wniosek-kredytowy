package pl.javaskills.creditapp;

import pl.javaskills.creditapp.client.CreditAplicationReader;
import pl.javaskills.creditapp.client.DummyCreditApplicationReader;
import pl.javaskills.creditapp.core.*;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.scoring.EducationCalculator;
import pl.javaskills.creditapp.core.scoring.IncomeCalculator;
import pl.javaskills.creditapp.core.scoring.MaritalStatusCalculator;
import pl.javaskills.creditapp.core.validation.*;


public class Main {

    public static void main(String[] args) {
        CreditAplicationReader reader = new DummyCreditApplicationReader();
        EducationCalculator educationCalculator = new EducationCalculator();
        MaritalStatusCalculator maritalStatusCalculator = new MaritalStatusCalculator();
        IncomeCalculator incomeCalculator = new IncomeCalculator();
        SelfEmployedScoringCalculator selfEmployedScoringCalculator = new SelfEmployedScoringCalculator();
        PersonScoringCalculatorFactory personScoringCalculatorFactory = new PersonScoringCalculatorFactory(selfEmployedScoringCalculator, educationCalculator, maritalStatusCalculator, incomeCalculator);
        CreditApplicationValidator creditApplicationValidator = new CreditApplicationValidator(new PersonValidator(new PersonalDataValidator()), new PurposeOfLoanValidator());
        CreditApplicationService service = new CreditApplicationService(personScoringCalculatorFactory, new CreditRatingCalculator(), creditApplicationValidator);
        LoanApplication loanApplication = reader.read();
        CreditApplicationManager manager = new CreditApplicationManager(service);

        manager.add(reader.read());
        manager.add(reader.read());
        manager.add(reader.read());
        manager.add(reader.read());

        manager.startProcessing();
    }
}
