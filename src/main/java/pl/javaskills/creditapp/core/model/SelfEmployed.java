package pl.javaskills.creditapp.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.javaskills.creditapp.core.annotation.ExacltyOneNotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ExacltyOneNotNull({"nip", "regon"})
public class SelfEmployed extends Person implements Serializable {
    public static final long serialVersionUID = 1l;
    @JsonProperty
    private String nip;
    @JsonProperty
    private String regon;
    @JsonProperty
    private int yearsSinceFounded;
    @JsonProperty
    private List<FamilyMember> familyMemberList;

    public String getNip() {
        return nip;
    }

    public String getRegon() {
        return regon;
    }

    public SelfEmployed(){}

    private SelfEmployed(String nip, String regon, PersonalData personalData, FinanceData financeData,
                         ContactData contactData, int yearsSinceFounded, List<FamilyMember> familyMemberList) {
        super(personalData, financeData, contactData, familyMemberList);
        this.nip = nip;
        this.regon = regon;
        this.yearsSinceFounded = yearsSinceFounded;
        this.familyMemberList = familyMemberList;
    }

    public int getYearsSinceFounded() {
        return yearsSinceFounded;
    }

    @Override
    public List<FamilyMember> getFamilyMemberList() {
        return familyMemberList;
    }

    public static class Builder {
        private PersonalData personalData;
        private FinanceData financeData;
        private ContactData contactData;
        private String nip;
        private String regon;
        private int yearsSinceFounded;
        private List<FamilyMember> familyMemberList = new ArrayList<>();

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

        public Builder withYearsSinceFounded(int yearsSinceFounded){
            this.yearsSinceFounded = yearsSinceFounded;
            return this;
        }

        public Builder withContactData(ContactData contactData) {
            this.contactData = contactData;
            return this;
        }

        public Builder withNip(String nip) {
            this.nip = nip;
            return this;
        }
        public Builder withRegon(String regon) {
            this.regon = regon;
            return this;
        }

        public Builder withFamilyMembers(List<FamilyMember> familyMemberList){
            this.familyMemberList = familyMemberList;
            return this;
        }

        public SelfEmployed build(){
            return new SelfEmployed(nip, regon, personalData, financeData,
                    contactData, yearsSinceFounded, familyMemberList);
        }
    }
}
