package pl.javaskills.creditapp.core.scoring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.javaskills.creditapp.core.model.IncomeType;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.model.PersonTestFactory;
import pl.javaskills.creditapp.core.model.SourceOfIncome;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IncomeCalculatorTest {

    private final IncomeCalculator cut = new IncomeCalculator();

    @Test
    @DisplayName("should return 100 points for each 1000 zl for family member")
    public void test1() {
        //given
        SourceOfIncome s1 = new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, 5000.00);
        Person person = PersonTestFactory.create(2, s1);
        //when
        int scoring = cut.calculate(person);
        //then
        assertEquals(200, scoring);

    }

    @Test
    @DisplayName("should return extra 100 points when there is more than 1 source of income")
    public void test2() {
        //given
        SourceOfIncome s1 = new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, 4000.00);
        SourceOfIncome s2 = new SourceOfIncome(IncomeType.RETIREMENT, 1000.00);
        Person person = PersonTestFactory.create(2, s1, s2);
        //when
        int scoring = cut.calculate(person);
        //then
        assertEquals(300, scoring);

    }

}