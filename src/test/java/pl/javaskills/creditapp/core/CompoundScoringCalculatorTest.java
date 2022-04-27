package pl.javaskills.creditapp.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.javaskills.creditapp.core.model.CreditApplicationTestFactory;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.scoring.CompoundScoringCalculator;
import pl.javaskills.creditapp.core.scoring.ScoringCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
class CompoundScoringCalculatorTest {

    private ScoringCalculator calculator1Mock = Mockito.mock(ScoringCalculator.class);
    private ScoringCalculator calculator2Mock = Mockito.mock(ScoringCalculator.class);
    private ScoringCalculator calculator3Mock = Mockito.mock(ScoringCalculator.class);
    private CompoundScoringCalculator cut = new CompoundScoringCalculator(calculator1Mock, calculator2Mock, calculator3Mock);


    @Test
    @DisplayName("should return sum of calculations")
    public void test1() {
        //given
        LoanApplication loanApplication = CreditApplicationTestFactory.create();
        BDDMockito.given(calculator1Mock.calculate(eq(loanApplication)))
                .willReturn(100);
        BDDMockito.given(calculator2Mock.calculate(eq(loanApplication)))
                .willReturn(200);
        BDDMockito.given(calculator3Mock.calculate(eq(loanApplication)))
                .willReturn(50);
        //when
        int scoring = cut.calculate(loanApplication);
        //then
        assertEquals(350, scoring);
    }
}