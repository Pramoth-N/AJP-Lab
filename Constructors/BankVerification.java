package Constructors;
/*
 * 
 * 1. Imagine a bank that needs to manage accounts with a strict verification system. Each BankAccount has an accountNumber and an accountBalance. To keep an account active, the account number should be between -500 and 500, and the balance should be between 0 and 1000. Implement a system that takes an account's details and checks if it meets these requirements.

Input Format
•	The input contains two values in a single line an integer accountNumber and a float accountBalance.

Output Format
•	true if the account is valid, false otherwise.
•	Print Invalid input, if non-numeric inputs present.
Constraints
•	-500 <= Account number <= 500 
•	-1000.00 <= Account balance <= 1000.00

 * 
 */

import java.util.Scanner;

public class BankVerification {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int accountNumber = scanner.nextInt();
            float accountBalance = scanner.nextFloat();
            boolean isValid = accountNumber >= -500 && accountNumber <= 500 && accountBalance >= 0 && accountBalance <= 1000;
            System.out.println(isValid);
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
}
