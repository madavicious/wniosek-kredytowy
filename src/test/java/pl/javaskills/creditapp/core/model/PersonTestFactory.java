package pl.javaskills.creditapp.core.model;

public class PersonTestFactory {



    public static Person create(Education education) {
        PersonalData personalData = PersonalData.Builder.create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withEducation(education)
                .withMaritalStatus(MaritalStatus.SINGLE)
                .withNumOfDependants(2)
                .build();
        return NaturalPerson.Builder.create().withPersonalData(personalData).build();
    }


    public static  Person create() {
        PersonalData personalData = PersonalData.Builder.create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withEducation(Education.MIDDLE)
                .withMaritalStatus(MaritalStatus.SINGLE)
                .withNumOfDependants(1)
                .build();
        return NaturalPerson.Builder.create().withPersonalData(personalData).build();
    }

    public static NaturalPerson create(double totalMonthlyIncomeInPln, int numOfDependants, Education education, MaritalStatus maritalStatus) {
        PersonalData personalData = PersonalData.Builder.create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withEducation(education)
                .withMaritalStatus(maritalStatus)
                .withNumOfDependants(numOfDependants)
                .build();
        return NaturalPerson.Builder.create().withPersonalData(personalData).withFinanceData(new FinanceData(new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, totalMonthlyIncomeInPln))).build();
    }

    public static Person create(MaritalStatus maritalStatus) {
        PersonalData personalData = PersonalData.Builder.create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withEducation(Education.MIDDLE)
                .withMaritalStatus(maritalStatus)
                .withNumOfDependants(2)
                .build();
        return NaturalPerson.Builder.create().withPersonalData(personalData).build();
    }

    public static  NaturalPerson create(int numOfDependants, SourceOfIncome... sourcesOfIncome) {
        PersonalData personalData = PersonalData.Builder.create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withEducation(Education.MIDDLE)
                .withMaritalStatus(MaritalStatus.SINGLE)
                .withNumOfDependants(numOfDependants)
                .build();
        return NaturalPerson.Builder.create().withPersonalData(personalData).withFinanceData(new FinanceData(sourcesOfIncome)).build();
    }
}
