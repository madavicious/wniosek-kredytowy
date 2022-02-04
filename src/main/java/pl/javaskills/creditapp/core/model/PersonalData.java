package pl.javaskills.creditapp.core.model;

public class PersonalData {
    private final String name;
    private final String lastName;
    private final String mothersMaidenName;
    private final double totalMonthlyIncomeInPln;
    private final MaritalStatus maritalStatus;
    private final Education education;
    private final int numOfFamilyDependants;

    public PersonalData(String name, String lastName, String mothersMaidenName, double totalMonthlyIncomeInPln, MaritalStatus maritalStatus, Education education, int numOfFamilyDependants) {
        this.name = name;
        this.lastName = lastName;
        this.mothersMaidenName = mothersMaidenName;
        this.totalMonthlyIncomeInPln = totalMonthlyIncomeInPln;
        this.maritalStatus = maritalStatus;
        this.education = education;
        this.numOfFamilyDependants = numOfFamilyDependants;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMothersMaidenName() {
        return mothersMaidenName;
    }

    public double getTotalMonthlyIncomeInPln() {
        return totalMonthlyIncomeInPln;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public Education getEducation() {
        return education;
    }

    public int getNumOfFamilyDependants() {
        return numOfFamilyDependants;
    }
}
