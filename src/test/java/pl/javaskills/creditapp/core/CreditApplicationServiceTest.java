package pl.javaskills.creditapp.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.javaskills.creditapp.core.exception.RequirementNotMetException;
import pl.javaskills.creditapp.core.exception.ValidationException;
import pl.javaskills.creditapp.core.model.CreditApplicationTestFactory;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.scoring.ScoringCalculator;
import pl.javaskills.creditapp.core.validation.CompoundPostValidator;
import pl.javaskills.creditapp.core.validation.CreditApplicationValidator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;


@ExtendWith(MockitoExtension.class)
class CreditApplicationServiceTest {
    @InjectMocks
    private CreditApplicationService cut;

    @Mock
    private ScoringCalculator scoringCalculatorMock;

    @Mock
    private CompoundPostValidator compoundPostValidatorMock;

    @Mock
    private CreditApplicationValidator creditApplicationValidatorMock;

    @Mock
    private PersonScoringCalculatorFactory personScoringCalculatorFactoryMock;

    @Mock
    private CreditRatingCalculator creditRatingCalculatorMock;

    @BeforeEach
    public void init() throws ValidationException, RequirementNotMetException {
        BDDMockito.given(personScoringCalculatorFactoryMock.getCalculator(any(Person.class))).willReturn(scoringCalculatorMock);

        BDDMockito.doNothing().when(creditApplicationValidatorMock).validate(any(LoanApplication.class));
        BDDMockito.doNothing().when(compoundPostValidatorMock).validate(any(LoanApplication.class), anyInt(), anyDouble());

    }

    @Test
    @DisplayName("should return NEGATIVE_SCORING when scoring is < 300")
    public void test1() {
        //given
        LoanApplication loanApplication = CreditApplicationTestFactory.create();
        BDDMockito.given(scoringCalculatorMock.calculate(eq(loanApplication))).willReturn(100);

        //when
        final CreditApplicationDecision decision = cut.getDecision(loanApplication);
        //then
        assertEquals(DecisionType.NEGATIVE_SCORING, decision.getType());
    }

    @Test
    @DisplayName("should return CONTACT_REQUIRED when scoring is <= 400")
    public void test2() {
        //given
        LoanApplication loanApplication = CreditApplicationTestFactory.create();
        BDDMockito.given(scoringCalculatorMock.calculate(eq(loanApplication))).willReturn(350);

        //when
        final CreditApplicationDecision decision = cut.getDecision(loanApplication);
        //then
        assertEquals(DecisionType.CONTACT_REQUIRED, decision.getType());
    }

    @Test
    @DisplayName("should return NEGATIVE_RATING when scoring is > 400 and credit rating > expected loan amount")
    public void test3() {
        //given
        LoanApplication loanApplication = CreditApplicationTestFactory.create(190000.00);
        BDDMockito.given(scoringCalculatorMock.calculate(eq(loanApplication))).willReturn(450);

        BDDMockito.given(creditRatingCalculatorMock.calculate(eq(loanApplication))).willReturn(189000.0);

        //when
        final CreditApplicationDecision decision = cut.getDecision(loanApplication);
        //then
        assertEquals(DecisionType.NEGATIVE_RATING, decision.getType());
    }

    @Test
    @DisplayName("should return POSITIVE when scoring is > 400 and credit rating <= expected loan amount")
    public void test4() {
        //given
        LoanApplication loanApplication = CreditApplicationTestFactory.create(150000.00);
        BDDMockito.given(scoringCalculatorMock.calculate(eq(loanApplication))).willReturn(450);
        BDDMockito.given(creditRatingCalculatorMock.calculate(eq(loanApplication))).willReturn(151000.0);

        //when
        final CreditApplicationDecision decision = cut.getDecision(loanApplication);
        //then
        assertEquals(DecisionType.POSITIVE, decision.getType());
    }

}