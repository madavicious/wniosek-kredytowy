package pl.javaskills.creditapp.client;

import pl.javaskills.creditapp.core.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class DummyCreditApplicationReader implements CreditAplicationReader{
        
    @Override
    public LoanApplication read(){
        final FamilyMember john = new FamilyMember("John", 18);
        final FamilyMember jane = new FamilyMember("Jane", 40);
        final FamilyMember susie = new FamilyMember("Susie", 5);
        List<FamilyMember> familyMemberList = Arrays.asList(john, jane, susie);
        NaturalPerson person = NaturalPerson.Builder.create()
                .withPesel("12345123451")
                .withFamilyMembers(familyMemberList)
                .withPersonalData(PersonalData.Builder.create()
                        .withName("Test")
                        .withLastName("Test")
                        .withMothersMaidenName("Test")
                        .withEducation(Education.MIDDLE)
                        .withMaritalStatus(MaritalStatus.MARRIED)
                        .build())
                .withContactData(ContactData.Builder.create()
                        .withEmail("test@test")
                        .withPhoneNumber("000000000")
                        .withHomeAddress(new Address("Test", "Test", "00-000", "Test", "5"))
                        .withCorrespondenceAddress(new Address("Test", "Test", "00-000", "Test", "5"))
                        .build())
                .withFinanceData(new FinanceData(new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, 10000)))
                .build();
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(PurposeOfLoanType.MORTGAGE, 50000, 30);
        Set<Guarantor> guarantorSet = Set.of(new Guarantor("12312312312", 18), new Guarantor("22312312312", 41));
        LoanApplication loanApplication = new LoanApplication(person, purposeOfLoan, guarantorSet);

        return loanApplication;
    }
}
