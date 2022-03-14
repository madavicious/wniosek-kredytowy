package pl.javaskills.creditapp.core.model;

public class NaturalPerson extends Person{
    private final String pesel;

    private NaturalPerson(String pesel, PersonalData personalData, ContactData contactData, FinanceData financeData) {
        super(personalData, financeData, contactData);
        this.pesel = pesel;
    }

    public static class Builder {
        private PersonalData personalData;
        private ContactData contactData;
        private FinanceData financeData;
        private String pesel;

        private Builder(){}

        public static Builder create(){
            return new Builder();
        }

        public Builder withPersonalData(PersonalData personalData){
            this.personalData = personalData;
            return this;
        }

        public Builder withFinanceData(FinanceData financeData) {
            this.financeData = financeData;
            return this;
        }

        public Builder withContactData(ContactData contactData) {
            this.contactData = contactData;
            return this;
        }

        public Builder withPesel(String pesel) {
            this.pesel = pesel;
            return this;
        }

        public NaturalPerson build(){
            return new NaturalPerson(pesel, personalData, contactData, financeData);
        }
    }
}
