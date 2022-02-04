package pl.javaskills.creditapp.core;

import pl.javaskills.creditapp.core.model.Education;
import pl.javaskills.creditapp.core.model.MaritalStatus;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.model.PersonalData;

public class PersonTestFactory {
    public static Person create(double totalMonthlyIncomeInPln, int numOfDependants, Education education, MaritalStatus maritalStatus) {
        PersonalData personalData = new PersonalData(null, null, null, totalMonthlyIncomeInPln, maritalStatus, education, numOfDependants);
        return new Person(personalData, null);
    }
}
