package pl.javaskills.creditapp.core.model;

import java.util.UUID;

public class LoanApplication {
    private final UUID id;
    private final Person person;
    private final PurposeOfLoan purposeOfLoan;

    public LoanApplication(Person person, PurposeOfLoan purposeOfLoan) {
        this.person = person;
        this.purposeOfLoan = purposeOfLoan;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public PurposeOfLoan getPurposeOfLoan() {
        return purposeOfLoan;
    }
}
