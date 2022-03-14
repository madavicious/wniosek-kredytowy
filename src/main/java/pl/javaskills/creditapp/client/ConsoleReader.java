package pl.javaskills.creditapp.client;

import org.jetbrains.annotations.NotNull;
import pl.javaskills.creditapp.core.model.*;

import java.util.Scanner;



public class ConsoleReader {

    public LoanApplication readInputParameters() {
        Scanner in = new Scanner(System.in);
        String name = getName(in);
        String lastName = getLastName(in);
        String mothersMaidenName = getMothersMaidenName(in);
        String email = getEmail(in);
        String phoneNumber = getPhoneNumber(in);
        int numOfSourcesOfIncome = getNumOfSourcesOfIncome(in);
        SourceOfIncome[] sourcesOfIncome = getSourceOfIncomes(in, numOfSourcesOfIncome);
        MaritalStatus maritalStatus = getMaritalStatus(in);
        int numOfFamilyDependants = getNumOfDependants(in);
        Education education = getEducation(in);
        PurposeOfLoanType purposeOfLoanType = getPurposeOfLoanType(in);
        double amount = getPurposeOfLoanAmount(in);

        byte period = getPeriod(in);

        PersonalData personalData = PersonalData.Builder.create()
                .withName(name)
                .withLastName(lastName)
                .withMothersMaidenName(mothersMaidenName)
                .withEducation(education)
                .withMaritalStatus(maritalStatus)
                .withNumOfDependants(numOfFamilyDependants)
                .build();
        ContactData contactData = ContactData.Builder.create()
                .withEmail(email)
                .withPhoneNumber(phoneNumber)
                .build();
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(purposeOfLoanType, amount, period);
        FinanceData financeData = new FinanceData(sourcesOfIncome);

        return new LoanApplication(NaturalPerson.Builder.create()
                .withPersonalData(PersonalData.Builder.create()
                        .withName(name)
                        .withLastName(lastName)
                        .withMothersMaidenName(mothersMaidenName)
                        .withEducation(education)
                        .withMaritalStatus(maritalStatus)
                        .withNumOfDependants(numOfFamilyDependants)
                        .build())
                .withContactData(contactData)
                .withFinanceData(financeData)
                .build(), purposeOfLoan);
    }

    private byte getPeriod(Scanner in) {
        String input;
        do {
            System.out.println("Enter loan period (in years):");
            input = in.next();
        }while (!NumberValidator.validateInteger(input, 5,10,15,20,25,30));
        byte period = Byte.valueOf(input);
        return period;
    }

    @NotNull
    private SourceOfIncome[] getSourceOfIncomes(Scanner in, int numOfSourcesOfIncome) {
        SourceOfIncome[] sourcesOfIncome = new SourceOfIncome[numOfSourcesOfIncome];
        for(int i = 1; i <= numOfSourcesOfIncome; i++) {
            IncomeType incomeType = getIncomeType(in, i);
            double netMonthlyIncome = getNetMonthlyIncome(in, i);

            SourceOfIncome sourceOfIncome = new SourceOfIncome(incomeType, netMonthlyIncome);
            sourcesOfIncome[i-1] = sourceOfIncome;
        }
        return sourcesOfIncome;
    }

    private double getNetMonthlyIncome(Scanner in, int i) {
        String input;
        do {
            System.out.println("Enter net monthly income of source of income " + i);
            input = in.next();
        } while (!NumberValidator.validateDoubles(input,0.0, Double.MAX_VALUE));
        double netMonthlyIncome = in.nextDouble();
        return netMonthlyIncome;
    }

    private int getNumOfSourcesOfIncome(Scanner in) {
        String input;
        do {
            System.out.println("How many sources of income do you have?:");
            input = in.next();
        } while (!NumberValidator.validateInteger(input, 0, Integer.MAX_VALUE));
        int numOfSourcesOfIncome = Integer.valueOf(input);
        return numOfSourcesOfIncome;
    }

    private int getNumOfDependants(Scanner in) {
        String input;
        do {
            System.out.println("Enter number of family dependants (including applicant):");
            input = in.next();
        } while (!NumberValidator.validateInteger(input, 1, Integer.MAX_VALUE));
        int numOfFamilyDependants = Integer.valueOf(input);
        return numOfFamilyDependants;
    }

    private double getPurposeOfLoanAmount(Scanner in) {
        String input;
        do {
            System.out.println("Enter loan amount");
            input = in.next();
        } while (!NumberValidator.validateDoubles(input,0.0, Double.MAX_VALUE));
        return Double.valueOf(input);
    }

    private String getName(Scanner in) {
        String input;
        do {
            System.out.println("Enter your name:");
            input = in.next();
        }    while(!StringValidator.validateStrings(input, Constants.NAME_REGEX));
        return input;
    }

    private String getLastName(Scanner in) {
        String input;
        do {
            System.out.println("Enter your last name:");
            input = in.next();
        }    while(!StringValidator.validateStrings(input, Constants.LAST_NAME_REGEX));
        return input;
    }

    private String getMothersMaidenName(Scanner in) {
        String input;
        do {
            System.out.println("Enter your mother's maiden name:");
            input = in.next();
        }    while(!StringValidator.validateStrings(input, Constants.LAST_NAME_REGEX));
        return input;
    }

    private String getEmail(Scanner in) {
        String input;
        do {
            System.out.println("Enter your email:");
            input = in.next();
        } while (!StringValidator.validateStrings(input, Constants.EMAIL_REGEX));
        return input;
    }

    private String getPhoneNumber(Scanner in) {
        String input;
        do {
            System.out.println("Enter your phone number:");
            input = in.next();
        } while (!StringValidator.validateStrings(input, Constants.PHONE_REGEX));
        return input;
    }

    @NotNull
    private IncomeType getIncomeType(Scanner in, int i) {
        String incomeTypeInput;
        do {
            System.out.println("Enter type of source of income " + i + " " + generateIncomeTypeElements());
            incomeTypeInput = in.next();
        } while (!EnumValidator.validateIncomeType(incomeTypeInput));
        IncomeType incomeType = IncomeType.valueOf(incomeTypeInput);
        return incomeType;
    }

    @NotNull
    private Education getEducation(Scanner in) {
        String educationInput;
        do {
            System.out.println("What is your education level? " + generateEducationElements());
            educationInput = in.next();
        } while (!EnumValidator.validateEducation(educationInput));
        Education education = Education.valueOf(educationInput);
        return education;
    }

    @NotNull
    private PurposeOfLoanType getPurposeOfLoanType(Scanner in) {
        String purposeOfLoanTypeInput;
        do {
            System.out.println("What is purpose of loan? " + generatePurposeOfLoanTypeElements());
            purposeOfLoanTypeInput = in.next();
        } while (!EnumValidator.validatePurposeOfLoanType(purposeOfLoanTypeInput));
        PurposeOfLoanType purposeOfLoanType = PurposeOfLoanType.valueOf(purposeOfLoanTypeInput);
        return purposeOfLoanType;
    }

    @NotNull
    private MaritalStatus getMaritalStatus(Scanner in) {
        String maritalStatusInput;
        do {
            System.out.println("What is your material status? " + generateMaritalStatusElements());
            maritalStatusInput = in.next();
        } while(!EnumValidator.validateMaritalStatus(maritalStatusInput));
        MaritalStatus maritalStatus = MaritalStatus.valueOf(maritalStatusInput);
        return maritalStatus;
    }

    @NotNull
    private String generateMaritalStatusElements() {
        String elements = "(";
        for (int i = 0; i < MaritalStatus.values().length; i++) {
            elements += MaritalStatus.values()[i].name();
            if (i < MaritalStatus.values().length - 1){
                elements += ", ";
            }
        }
        elements += ")";
        return elements;
    }

    @NotNull
    private String generateEducationElements() {
        String elements = "(";
        for (int i = 0; i < Education.values().length; i++) {
            elements += Education.values()[i].name();
            if (i < Education.values().length - 1){
                elements += ", ";
            }
        }
        elements += ")";
        return elements;
    }

    @NotNull
    private String generateIncomeTypeElements() {
        String elements = "(";
        for (int i = 0; i < IncomeType.values().length; i++) {
            elements += IncomeType.values()[i].name();
            if (i < IncomeType.values().length - 1){
                elements += ", ";
            }
        }
        elements += ")";
        return elements;
    }

    @NotNull
    private String generatePurposeOfLoanTypeElements() {
        String elements = "(";
        for (int i = 0; i < PurposeOfLoanType.values().length; i++) {
            elements += PurposeOfLoanType.values()[i].name();
            if (i < PurposeOfLoanType.values().length - 1){
                elements += ", ";
            }
        }
        elements += ")";
        return elements;
    }


}
