package pl.javaskills.creditapp.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.model.PersonTestFactory;
import pl.javaskills.creditapp.core.scoring.CompoundScoringCalculator;
import pl.javaskills.creditapp.core.scoring.PersonCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
class CompoundScoringCalculatorTest {

    private PersonCalculator calculator1Mock = Mockito.mock(PersonCalculator.class);
    private PersonCalculator calculator2Mock = Mockito.mock(PersonCalculator.class);
    private PersonCalculator calculator3Mock = Mockito.mock(PersonCalculator.class);
    private CompoundScoringCalculator cut = new CompoundScoringCalculator(calculator1Mock, calculator2Mock, calculator3Mock);


    @Test
    @DisplayName("should return sum of calculations")
    public void test1() {
        //given
        Person person = PersonTestFactory.create();
        BDDMockito.given(calculator1Mock.calculate(eq(person)))
                .willReturn(100);
        BDDMockito.given(calculator2Mock.calculate(eq(person)))
                .willReturn(200);
        BDDMockito.given(calculator3Mock.calculate(eq(person)))
                .willReturn(50);
        //when
        int scoring = cut.calculate(person);
        //then
        assertEquals(350, scoring);
    }
}