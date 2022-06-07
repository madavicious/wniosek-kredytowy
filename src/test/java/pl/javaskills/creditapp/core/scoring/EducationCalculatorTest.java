package pl.javaskills.creditapp.core.scoring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pl.javaskills.creditapp.core.model.Education;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.model.PersonTestFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EducationCalculatorTest {

    private final EducationCalculator cut = new EducationCalculator();

    @ParameterizedTest
    @DisplayName("should return point attached to enum element")
    @EnumSource(Education.class)
    public void test(Education education) {
        //given
        Person person = PersonTestFactory.create(education);
        //when
        int scoring = cut.calculate(person);
        //then
        assertEquals(education.getScoringPoints(), scoring);
    }

}