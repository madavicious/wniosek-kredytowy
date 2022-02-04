package pl.javaskills.creditapp.client;

import pl.javaskills.creditapp.core.model.*;

import java.util.Scanner;



public class ConsoleReader {

    public LoanApplication readInputParameters() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = in.next();

        System.out.println("Enter your last name:");
        String lastName = in.next();

        System.out.println("Enter your mother's maiden name:");
        String mothersMaidenName = in.next();

        System.out.println("Enter total monthly income in PLN:");
        double totalMonthlyIncomeInPln = in.nextDouble();

        System.out.println("What is your material status? (SINGLE, MARRIED, DIVORCED, WIDOWED, SEPARATED)");
        MaritalStatus maritalStatus = MaritalStatus.valueOf(in.next());

        System.out.println("Enter number of family dependants (including applicant):");
        int numOfFamilyDependants = in.nextInt();

        System.out.println("What is your education level? (NONE, PRIMARY, MIDDLE, SECONDARY, POST_SECONDARY, TERTIARY)");
        Education education = Education.valueOf(in.next());

        System.out.println("Enter your email address:");
        String email = in.next();

        System.out.println("Enter your phone number");
        String phoneNumber = in.next();

        System.out.println("What is purpose of loan? (MORTGAGE, PERSONAL_LOAN):");
        PurposeOfLoanType purposeOfLoanType = PurposeOfLoanType.valueOf(in.next());

        System.out.println("Enter loan amount:");
        double amount = in.nextDouble();

        System.out.println("Enter loan period (in years):");
        byte period = in.nextByte();

        PersonalData personalData = new PersonalData(name, lastName, mothersMaidenName, totalMonthlyIncomeInPln, maritalStatus, education, numOfFamilyDependants);
        ContactData contactData = new ContactData(email, phoneNumber);
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(purposeOfLoanType, amount, period);
        Person person = new Person(personalData, contactData);

        return new LoanApplication(person, purposeOfLoan);
    }

}
