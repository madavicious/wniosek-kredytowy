package pl.javaskills.creditapp.core.model;

public class PersonTestFactory {



    public static Person create(Education education) {
        PersonalData personalData = new PersonalData("test", "test", "test", MaritalStatus.SINGLE, education, 2);
        return new Person(personalData, null, null);
    }


    public static  Person create() {
        PersonalData personalData = new PersonalData("test", "test", "test", MaritalStatus.SINGLE, Education.MIDDLE, 1);
        return new Person(personalData, null, null);
    }

    public static Person create(double totalMonthlyIncomeInPln, int numOfDependants, Education education, MaritalStatus maritalStatus) {
        PersonalData personalData = new PersonalData("test", "test", "test", maritalStatus, education, numOfDependants);
        return new Person(personalData, new FinanceData(new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, totalMonthlyIncomeInPln)), null);
    }

    public static Person create(MaritalStatus maritalStatus) {
        PersonalData personalData = new PersonalData("test", "test", "test", maritalStatus, Education.MIDDLE, 2);
        return new Person(personalData, null, null);
    }

    public static  Person create(int numOfDependants, SourceOfIncome... sourcesOfIncome) {
        PersonalData personalData = new PersonalData("test", "test", "test", MaritalStatus.SINGLE, Education.MIDDLE, numOfDependants);
        return new Person(personalData, new FinanceData(sourcesOfIncome), null);
    }
}
