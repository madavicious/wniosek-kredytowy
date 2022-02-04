package pl.javaskills.creditapp.core;

import pl.javaskills.creditapp.core.model.*;

public class CreditApplicationTestFactory {

    public static LoanApplication create() {
        Person person = PersonTestFactory.create(5000, 2, Education.MIDDLE, MaritalStatus.SEPARATED);

        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(PurposeOfLoanType.MORTGAGE, 100, (byte) 35);
        LoanApplication loanApplication = new LoanApplication(person, purposeOfLoan);
        return loanApplication;
    }
    public static LoanApplication create(double expectedLoanAmount) {
        Person person = PersonTestFactory.create(4000.00, 1, Education.MIDDLE, MaritalStatus.SEPARATED);

        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(PurposeOfLoanType.MORTGAGE, expectedLoanAmount, (byte) 25);
        LoanApplication loanApplication = new LoanApplication(person, purposeOfLoan);
        return loanApplication;
    }
}
