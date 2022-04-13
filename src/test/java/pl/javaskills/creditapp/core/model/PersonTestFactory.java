package pl.javaskills.creditapp.core.model;

import java.util.ArrayList;
import java.util.List;

public class PersonTestFactory {

    public static NaturalPerson create(int numOfDependants, SourceOfIncome... sourcesOfIncome) {
        List<FamilyMember> familyMemberList = getFamilyMembers(numOfDependants);
        PersonalData personalData = PersonalData
                .Builder
                .create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withEducation(Education.MIDDLE)
                .withMaritalStatus(MaritalStatus.SINGLE)
                .build();
        return NaturalPerson.Builder
                .create()
                .withFamilyMembers(familyMemberList)
                .withFinanceData(new FinanceData(sourcesOfIncome))
                .withPersonalData(personalData)
                .build();
    }

    private static List<FamilyMember> getFamilyMembers(int numOfDependants) {
        List<FamilyMember> familyMemberList = new ArrayList<>();
        for (int i = 0; i < numOfDependants - 1; i++) {
            familyMemberList.add(new FamilyMember("John", 18));
        }
        return familyMemberList;
    }

    public static NaturalPerson create(MaritalStatus maritalStatus) {
        List<FamilyMember> familyMemberList = getFamilyMembers(1);
        PersonalData personalData = PersonalData
                .Builder
                .create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withEducation(Education.MIDDLE)
                .withMaritalStatus(maritalStatus)
                .build();
        return NaturalPerson.Builder
                .create()
                .withFamilyMembers(familyMemberList)
                .withPersonalData(personalData)
                .build();
    }

    public static Person create(Education education) {
        List<FamilyMember> familyMemberList = getFamilyMembers(1);
        PersonalData personalData = PersonalData
                .Builder
                .create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withEducation(education)
                .withMaritalStatus(MaritalStatus.SINGLE)
                .build();

        return NaturalPerson.Builder
                .create()
                .withFamilyMembers(familyMemberList)
                .withPersonalData(personalData)
                .build();
    }

    public static NaturalPerson create() {
        List<FamilyMember> familyMemberList = getFamilyMembers(1);
        PersonalData personalData = PersonalData
                .Builder
                .create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withEducation(Education.MIDDLE)
                .withMaritalStatus(MaritalStatus.SINGLE)
                .build();
        return NaturalPerson.Builder
                .create()
                .withFamilyMembers(familyMemberList)
                .withPersonalData(personalData)
                .build();
    }

    public static NaturalPerson create(double totalMonthlyIncomeInPln, int numOfDependants, Education education, MaritalStatus maritalStatus) {
        List<FamilyMember> familyMemberList = getFamilyMembers(1);
        PersonalData personalData = PersonalData
                .Builder
                .create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withEducation(education)
                .withMaritalStatus(maritalStatus)
                .build();
        return NaturalPerson.Builder
                .create()
                .withFamilyMembers(familyMemberList)
                .withFinanceData(new FinanceData(new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, totalMonthlyIncomeInPln)))
                .withPersonalData(personalData)
                .build();
    }
}
