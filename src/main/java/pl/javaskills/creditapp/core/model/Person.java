package pl.javaskills.creditapp.core.model;

public class Person {
    private final PersonalData personalData;
    private final ContactData contactData;

    public Person(PersonalData personalData, ContactData contactData) {
        this.personalData = personalData;
        this.contactData = contactData;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public ContactData getContactData() {
        return contactData;
    }

    public double getIncomePerFamilyMember() {
        return this.getPersonalData().getTotalMonthlyIncomeInPln() / this.getPersonalData().getNumOfFamilyDependants();
    }



}
