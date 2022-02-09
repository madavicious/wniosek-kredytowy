package pl.javaskills.creditapp.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.model.PersonTestFactory;
import pl.javaskills.creditapp.core.scoring.EducationCalculator;
import pl.javaskills.creditapp.core.scoring.IncomeCalculator;
import pl.javaskills.creditapp.core.scoring.MaritalStatusCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
class PersonScoringCalculatorTest {

    @InjectMocks
    private PersonScoringCalculator cut;

    @Mock
    private EducationCalculator educationCalculatorMock;
    @Mock
    private MaritalStatusCalculator maritalStatusCalculatorMock;
    @Mock
    private IncomeCalculator incomeCalculatorMock;

    @Test
    @DisplayName("should return sum of calculations")
    public void test1() {
        //given
        Person person = PersonTestFactory.create();
        BDDMockito.given(educationCalculatorMock.calculate(eq(person)))
                .willReturn(100);
        BDDMockito.given(maritalStatusCalculatorMock.calculate(eq(person)))
                .willReturn(200);
        BDDMockito.given(incomeCalculatorMock.calculate(eq(person)))
                .willReturn(50);
        //when
        int scoring = cut.calculate(person);
        //then
        assertEquals(350, scoring);

    }
}