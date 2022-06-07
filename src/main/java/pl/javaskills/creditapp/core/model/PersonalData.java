package pl.javaskills.creditapp.core.model;

import pl.javaskills.creditapp.core.Constants;
import pl.javaskills.creditapp.core.annotation.NotNull;
import pl.javaskills.creditapp.core.annotation.Regex;

import java.io.Serializable;

public class PersonalData implements Serializable {
    public static final long serialVersionUID = 1l;

    @NotNull
    @Regex(Constants.NAME_REGEX)
    private String name;
    @NotNull
    @Regex(Constants.LAST_NAME_REGEX)
    private String lastName;
    @NotNull
    @Regex(Constants.LAST_NAME_REGEX)
    private String mothersMaidenName;
    @NotNull
    private MaritalStatus maritalStatus;
    @NotNull
    private Education education;

    public PersonalData(){}

    private PersonalData(String name, String lastName, String mothersMaidenName, MaritalStatus maritalStatus, Education education) {
        this.name = name;
        this.lastName = lastName;
        this.mothersMaidenName = mothersMaidenName;
        this.maritalStatus = maritalStatus;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMothersMaidenName() { return mothersMaidenName; }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public Education getEducation() {
        return education;
    }

    public static class Builder {
        private String name;
        private String lastName;
        private String mothersMaidenName;
        private MaritalStatus maritalStatus;
        private Education education;
        private Builder(){}

        public static Builder create() {
            return new Builder();
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withMothersMaidenName(String mothersMaidenName) {
            this.mothersMaidenName = mothersMaidenName;
            return this;
        }

        public Builder withMaritalStatus(MaritalStatus maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

        public Builder withEducation(Education education) {
            this.education = education;
            return this;
        }

        public PersonalData build(){
            return new PersonalData(name, lastName,mothersMaidenName, maritalStatus, education);
        }
    }
}
