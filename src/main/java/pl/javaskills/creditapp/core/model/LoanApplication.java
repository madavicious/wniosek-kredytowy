package pl.javaskills.creditapp.core.model;

import java.util.Optional;

public class LoanApplication {
    private final Optional<NaturalPerson> naturalPerson;
    private final Optional<SelfEmployed> selfEmployed;
    private final PurposeOfLoan purposeOfLoan;

    public LoanApplication(NaturalPerson person, PurposeOfLoan purposeOfLoan) {
        this.naturalPerson = Optional.of(person);
        this.selfEmployed = Optional.empty();
        this.purposeOfLoan = purposeOfLoan;
    }

    public LoanApplication(SelfEmployed person, PurposeOfLoan purposeOfLoan) {
        this.selfEmployed = Optional.of(person);
        this.naturalPerson = Optional.empty();
        this.purposeOfLoan = purposeOfLoan;
    }

    public Optional<NaturalPerson> getNaturalPerson() {
        return naturalPerson;
    }

    public Optional<SelfEmployed> getSelfEmployed() {
        return selfEmployed;
    }

    public Person getPerson() {
        if(naturalPerson.isPresent()) {
            return naturalPerson.get();
        }
        return selfEmployed.get();
    }

    public PurposeOfLoan getPurposeOfLoan() {
        return purposeOfLoan;
    }
}
