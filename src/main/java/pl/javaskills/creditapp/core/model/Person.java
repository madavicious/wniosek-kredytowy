package pl.javaskills.creditapp.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.javaskills.creditapp.core.annotation.NotNull;
import pl.javaskills.creditapp.core.annotation.ValidateCollection;
import pl.javaskills.creditapp.core.annotation.ValidateObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Person implements Serializable {
    public static final long serialVersionUID = 1l;

    @NotNull
    @ValidateObject
    @JsonProperty
    private PersonalData personalData;
    @NotNull
    @ValidateObject
    @JsonProperty
    private FinanceData financeData;
    @NotNull
    @ValidateObject
    @JsonProperty
    private ContactData contactData;
    @NotNull
    @ValidateCollection
    @JsonProperty
    private List<FamilyMember> familyMemberList;

    protected Person(){}

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

    public double getBalance(){
        double totalMonthlyIncome = 0;
        for (SourceOfIncome sourceOfIncome : financeData.getSourcesOfIncome()) {
            totalMonthlyIncome += sourceOfIncome.getNetMonthlyIncome();
        }

        double totalExpenses = 0;
        for (Expense expense : financeData.getExpenses()) {
            totalExpenses += expense.getAmount();
        }

        return totalMonthlyIncome - totalExpenses;
    }

    public double getIncomePerFamilyMember(){
        return getBalance() / this.getNumOfDependants();
    }

    public List<FamilyMember> getFamilyMemberList() {
        return familyMemberList;
    }
}
