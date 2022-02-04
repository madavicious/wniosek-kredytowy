package pl.javaskills.creditapp.core;

import org.junit.Assert;
import org.junit.Test;
import pl.javaskills.creditapp.core.PersonScoringCalculator;
import pl.javaskills.creditapp.core.model.*;

import static pl.javaskills.creditapp.core.model.Education.*;
import static pl.javaskills.creditapp.core.model.MaritalStatus.*;

public class PersonScoringCalculatorTest {

    private PersonScoringCalculator cut = new PersonScoringCalculator();
    @Test
    public void test1() {
        int totalMonthlyIncomeInPln = 5000;
        int numOfDependants = 2;
        Education education = PRIMARY;
        MaritalStatus maritalStatus = MARRIED;
        PersonalData personalData = new PersonalData(null,null, null, totalMonthlyIncomeInPln, maritalStatus, education, numOfDependants);
        ContactData contactData = new ContactData(null, null);
        Person person = new Person(personalData, contactData);
        int result = cut.calculate(person);
        Assert.assertEquals(200, result);
    }

    @Test
    public void test2() {
        int totalMonthlyIncomeInPln = 5500;
        int numOfDependants = 1;
        Education education = MIDDLE;
        MaritalStatus maritalStatus = DIVORCED;
        PersonalData personalData = new PersonalData(null,null, null, totalMonthlyIncomeInPln, maritalStatus, education, numOfDependants);
        ContactData contactData = new ContactData(null, null);
        Person person = new Person(personalData, contactData);
        int result = cut.calculate(person);
        Assert.assertEquals(500, result);
    }

    @Test
    public void test3() {
        int totalMonthlyIncomeInPln = 9000;
        int numOfDependants = 3;
        Education education = NONE;
        MaritalStatus maritalStatus = SINGLE;
        PersonalData personalData = new PersonalData(null,null, null, totalMonthlyIncomeInPln, maritalStatus, education, numOfDependants);
        ContactData contactData = new ContactData(null, null);
        Person person = new Person(personalData, contactData);
        int result = cut.calculate(person);
        Assert.assertEquals(100, result);
    }
}
