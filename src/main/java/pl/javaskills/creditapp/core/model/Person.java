package pl.javaskills.creditapp.core.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Person{
    private final PersonalData personalData;
    private final FinanceData financeData;
    private final ContactData contactData;
    private final List<FamilyMember> familyMemberList;

    protected Person(PersonalData personalData, FinanceData financeData, ContactData contactData, List<FamilyMember> familyMemberList) {
        this.personalData = personalData;
        this.financeData = financeData;
        this.contactData = contactData;
        this.familyMemberList = familyMemberList;
        Collections.sort(this.familyMemberList);
    }

    public List<FamilyMember> getFamilyMembersSortedByName(){
        List<FamilyMember> copy = new ArrayList<>(this.familyMemberList);
        Collections.sort(copy, new FamilyMemberNameComparator());
        return copy;
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

    public int getNumOfDependants(){
        return 1 + this.familyMemberList.size();
    }


    public double getIncomePerFamilyMember(){
        double totalMonthlyIncome = 0;
        for (SourceOfIncome sourceOfIncome : financeData.getSourcesOfIncome()) {
            totalMonthlyIncome += sourceOfIncome.getNetMonthlyIncome();
        }
        return totalMonthlyIncome / this.getNumOfDependants();
    }

    public List<FamilyMember> getFamilyMemberList() {
        return familyMemberList;
    }
}
