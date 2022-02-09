package pl.javaskills.creditapp.core.model;

public class Person {
    private final PersonalData personalData;
    private final FinanceData financeData;
    private final ContactData contactData;

    public Person(PersonalData personalData, FinanceData financeData, ContactData contactData) {
        this.personalData = personalData;
        this.financeData = financeData;
        this.contactData = contactData;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public ContactData getContactData() {
        return contactData;
    }

    public FinanceData getFinanceData() {
        return financeData;
    }

    public double getIncomePerFamilyMember(){
        double totalMonthlyIncome = 0;
        for (SourceOfIncome sourceOfIncome : financeData.getSourcesOfIncome()) {
            totalMonthlyIncome += sourceOfIncome.getNetMonthlyIncome();
        }
        return totalMonthlyIncome / this.getPersonalData().getNumOfDependants();
    }
}
