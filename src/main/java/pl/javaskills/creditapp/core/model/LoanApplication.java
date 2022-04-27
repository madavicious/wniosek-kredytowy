package pl.javaskills.creditapp.core.model;

import pl.javaskills.creditapp.core.annotation.NotNull;
import pl.javaskills.creditapp.core.annotation.ValidateCollection;
import pl.javaskills.creditapp.core.annotation.ValidateObject;

import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

public class LoanApplication {

    @NotNull
    private final UUID id;
    @NotNull
    @ValidateObject
    private final Person person;
    @NotNull
    @ValidateObject
    private final PurposeOfLoan purposeOfLoan;
    @NotNull
    @ValidateCollection
    private final Set<Guarantor> guarantors;

    public LoanApplication(Person person, PurposeOfLoan purposeOfLoan) {
        this.person = person;
        this.purposeOfLoan = purposeOfLoan;
        this.id = UUID.randomUUID();
        this.guarantors = new TreeSet<>();
    }

    public LoanApplication(Person person, PurposeOfLoan purposeOfLoan, Set<Guarantor> guarantors) {
        this.person = person;
        this.purposeOfLoan = purposeOfLoan;
        this.id = UUID.randomUUID();
        this.guarantors = new TreeSet<>(guarantors);
    }

    public Set<Guarantor> getGuarantors() {
        return guarantors;
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
