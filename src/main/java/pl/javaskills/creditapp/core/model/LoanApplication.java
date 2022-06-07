package pl.javaskills.creditapp.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.javaskills.creditapp.core.annotation.ExacltyOneNotNull;
import pl.javaskills.creditapp.core.annotation.NotNull;
import pl.javaskills.creditapp.core.annotation.ValidateCollection;
import pl.javaskills.creditapp.core.annotation.ValidateObject;

import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

@ExacltyOneNotNull({"naturalPerson", "selfEmployed"})
public class LoanApplication implements Serializable {
    public static final long serialVersionUID = 1l;

    @NotNull
    @JsonIgnore
    private UUID id;
    @JsonProperty
    private ZoneId clientTimeZone;
    @JsonProperty
    private Locale clientLocale;
    @JsonIgnore
    private ZonedDateTime creationDateClientZone;
    @ValidateObject
    @JsonProperty
    private NaturalPerson naturalPerson;
    @ValidateObject
    @JsonProperty
    private SelfEmployed selfEmployed;
    @NotNull
    @ValidateObject
    @JsonProperty
    private PurposeOfLoan purposeOfLoan;
    @NotNull
    @ValidateCollection
    @JsonProperty
    private Set<Guarantor> guarantors;

    public LoanApplication(){}

    public LoanApplication(Locale clientLocale, ZoneId clientTimeZone, NaturalPerson person, PurposeOfLoan purposeOfLoan) {
        this.naturalPerson = person;
        this.purposeOfLoan = purposeOfLoan;
        this.id = UUID.randomUUID();
        this.clientTimeZone = clientTimeZone;
        this.creationDateClientZone = ZonedDateTime.now(clientTimeZone);
        this.guarantors = new TreeSet<>();
        this.clientLocale = clientLocale;
    }

    public LoanApplication(Locale clientLocale, ZoneId clientTimeZone, SelfEmployed person, PurposeOfLoan purposeOfLoan) {
        this.selfEmployed = person;
        this.purposeOfLoan = purposeOfLoan;
        this.id = UUID.randomUUID();
        this.clientTimeZone = clientTimeZone;
        this.creationDateClientZone = ZonedDateTime.now(clientTimeZone);
        this.guarantors = new TreeSet<>();
        this.clientLocale = clientLocale;
    }

    @JsonIgnore
    public boolean isNaturalPerson() {
        return naturalPerson != null;
    }

    public LoanApplication(Locale clientLocale, ZoneId clientTimeZone, NaturalPerson person, PurposeOfLoan purposeOfLoan, Set<Guarantor> guarantors) {
        this.naturalPerson = person;
        this.purposeOfLoan = purposeOfLoan;
        this.id = UUID.randomUUID();
        this.clientTimeZone = clientTimeZone;
        this.creationDateClientZone = ZonedDateTime.now(clientTimeZone);
        this.guarantors = new TreeSet<>(guarantors);
        this.clientLocale = clientLocale;
    }

    public LoanApplication(Locale clientLocale, ZoneId clientTimeZone, SelfEmployed person, PurposeOfLoan purposeOfLoan, Set<Guarantor> guarantors) {
        this.selfEmployed = person;
        this.purposeOfLoan = purposeOfLoan;
        this.id = UUID.randomUUID();
        this.clientTimeZone = clientTimeZone;
        this.creationDateClientZone = ZonedDateTime.now(clientTimeZone);
        this.guarantors = new TreeSet<>(guarantors);
        this.clientLocale = clientLocale;
    }

    public Locale getClientLocale() {
        return clientLocale;
    }

    public Set<Guarantor> getGuarantors() {
        return guarantors;
    }

    public UUID getId() {
        return id;
    }

    @JsonIgnore
    public Person getPerson() {
        return naturalPerson != null ? naturalPerson : selfEmployed;
    }

    public PurposeOfLoan getPurposeOfLoan() {
        return purposeOfLoan;
    }

    public void init() {
        this.id = UUID.randomUUID();
        this.creationDateClientZone = ZonedDateTime.now(clientTimeZone);
    }
}
