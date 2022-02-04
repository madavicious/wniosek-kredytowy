package pl.javaskills.creditapp.core.model;

public class LoanApplication {
    private final Person person;
    private final PurposeOfLoan purposeOfLoan;

    public LoanApplication(Person person, PurposeOfLoan purposeOfLoan) {
        this.person = person;
        this.purposeOfLoan = purposeOfLoan;
    }

    public Person getPerson() {
        return person;
    }

    public PurposeOfLoan getPurposeOfLoan() {
        return purposeOfLoan;
    }
}
