package pl.javaskills.creditapp.core.model;

public class CreditApplicationTestFactory {

    public static LoanApplication create(){
        Person person = PersonTestFactory.create(5000.00, 2, Education.MIDDLE,MaritalStatus.SEPARATED);

        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(PurposeOfLoanType.MORTGAGE,100.00,35);
        LoanApplication loanApplication = new LoanApplication(person,purposeOfLoan);
        return loanApplication;
    }

    public static LoanApplication create(double expectedLoanAmount){
        Person person = PersonTestFactory.create(4000.00, 1, Education.MIDDLE,MaritalStatus.SEPARATED);

        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(PurposeOfLoanType.MORTGAGE,expectedLoanAmount,25);
        LoanApplication loanApplication = new LoanApplication(person,purposeOfLoan);
        return loanApplication;
    }
}