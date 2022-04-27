package pl.javaskills.creditapp.core.scoring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.javaskills.creditapp.core.model.*;

import java.util.ArrayList;
import java.util.Set;

class GuarantorsCalculatorTest {

    private GuarantorsCalculator cut = new GuarantorsCalculator();

    @Test
    public void test1(){
        //given
        NaturalPerson person = createNaturalPerson();
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(PurposeOfLoanType.MORTGAGE, 50000.00, 30);
        Set<Guarantor>guarantorSet = Set.of(new Guarantor("002121213", 18));
        LoanApplication loanApplication = CreditApplicationTestFactory.create(person, purposeOfLoan, guarantorSet);

        //when
        int scoring = cut.calculate(loanApplication);

        //then
        Assertions.assertEquals(50, scoring);
    }

    @Test
    public void test2(){
        //given
        NaturalPerson person = createNaturalPerson();
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(PurposeOfLoanType.MORTGAGE, 50000.00, 30);
        Set<Guarantor>guarantorSet = Set.of(new Guarantor("00212121322", 18), new Guarantor("98989821123", 41));
        LoanApplication loanApplication = CreditApplicationTestFactory.create(person, purposeOfLoan, guarantorSet);

        //when
        int scoring = cut.calculate(loanApplication);

        //then
        Assertions.assertEquals(75, scoring);
    }

    private NaturalPerson createNaturalPerson() {
        NaturalPerson person = NaturalPerson.Builder
                .create()
                .withFamilyMembers(new ArrayList<>())
                .withPersonalData(PersonalData.Builder.create()
                        .withName("Test")
                        .withLastName("Test")
                        .withMothersMaidenName("Test")
                        .withEducation(Education.MIDDLE)
                        .withMaritalStatus(MaritalStatus.MARRIED)
                        .build())
                .withFinanceData(new FinanceData(new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, 10000.00)))
                .build();
        return person;
    }

}