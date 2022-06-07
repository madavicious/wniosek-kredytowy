package pl.javaskills.creditapp.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.javaskills.creditapp.core.Constants;
import pl.javaskills.creditapp.core.annotation.NotNull;
import pl.javaskills.creditapp.core.annotation.Regex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NaturalPerson extends Person implements Serializable {
    public static final long serialVersionUID = 1l;

    @NotNull
    @Regex(Constants.PESEL_REGEX)
    @JsonProperty
    private  String pesel;

    public String getPesel() {
        return pesel;
    }

    public NaturalPerson(){}

    private NaturalPerson(String pesel, PersonalData personalData, ContactData contactData, FinanceData financeData, List<FamilyMember> familyMemberList) {
        super(personalData, financeData, contactData, familyMemberList);
        this.pesel = pesel;
    }

    public static class Builder {
        private PersonalData personalData;
        private ContactData contactData;
        private FinanceData financeData;
        private String pesel;
        private List<FamilyMember> familyMemberList = new ArrayList<>();

        private Builder(){}

        public static Builder create(){
            return new Builder();
        }

        public Builder withPersonalData(PersonalData personalData){
            this.personalData = personalData;
            return this;
        }

        public Builder withFamilyMembers(List<FamilyMember> familyMemberList){
            this.familyMemberList = familyMemberList;
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
            return new NaturalPerson(pesel, personalData, contactData, financeData, familyMemberList);
        }
    }
}
