package pl.javaskills.creditapp.core.model;

import java.time.ZoneId;
import java.util.Locale;
import java.util.Set;

public class CreditApplicationTestFactory {

    public static final ZoneId CLIENT_TIME_ZONE = ZoneId.of("Europe/Warsaw");

    public static LoanApplication create(NaturalPerson person, PurposeOfLoan purposeOfLoan, Set<Guarantor> guarantors){
        return new LoanApplication(Locale.US, CLIENT_TIME_ZONE, person, purposeOfLoan, guarantors);
    }

    public static LoanApplication create(NaturalPerson person, PurposeOfLoan purposeOfLoan){
        return new LoanApplication(Locale.US, CLIENT_TIME_ZONE, person, purposeOfLoan);
    }

    public static LoanApplication create(SelfEmployed person, PurposeOfLoan purposeOfLoan){
        return new LoanApplication(Locale.US, CLIENT_TIME_ZONE, person, purposeOfLoan);
    }

    public static LoanApplication create(){
        NaturalPerson person = PersonTestFactory.create(5000.00, 2, Education.MIDDLE,MaritalStatus.SEPARATED);

        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(PurposeOfLoanType.MORTGAGE,100.00,35);
        LoanApplication creditApplication = new LoanApplication(Locale.US, CLIENT_TIME_ZONE, person, purposeOfLoan);
        return creditApplication;
    }

    public static LoanApplication create(double expectedLoanAmount){
        NaturalPerson person = PersonTestFactory.create(4000.00, 1, Education.MIDDLE,MaritalStatus.SEPARATED);

        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(PurposeOfLoanType.MORTGAGE,expectedLoanAmount,25);
        LoanApplication creditApplication = new LoanApplication(Locale.US, CLIENT_TIME_ZONE, person, purposeOfLoan);
        return creditApplication;
    }
}