package Inheritance;
/*
 * 
 * 
 * 1. In a bustling e-commerce platform, customers can select from multiple payment methods to finalize their purchases. As a part of this system, you need to implement a simple program that allows customers to enter the total amount of their order and choose a payment method (credit card, debit card, or PayPal). Each payment method has specific conditions: credit card payments incur a 2% fee, debit card payments incur a flat fee of $1.00, and PayPal payments have no additional fees. They process the payment and return the final amount charged.
Input Format
•	A decimal represents the total amount of the order followed by a choice of payment method credit, debit, paypal.
Output Format
•	A message displaying the final amount charged after any applicable fees.
•	If the input contains negative amounts or no valid payment method, print Invalid input.
Constraints
•	-200.0 < amount < 200.00

 * 
 */


 import java.util.Scanner;

 abstract class Payment {
     protected double amount;
 
     public Payment(double amount) {
         this.amount = amount;
     }
 
     public abstract double calculateFinalAmount();
 }
 
 class CreditPayment extends Payment {
     public CreditPayment(double amount) {
         super(amount);
     }
 
     @Override
     public double calculateFinalAmount() {
         return amount + (amount * 0.02);
     }
 }
 
 class DebitPayment extends Payment {
     public DebitPayment(double amount) {
         super(amount);
     }
 
     @Override
     public double calculateFinalAmount() {
         return amount + 1.00;
     }
 }
 
 class PayPalPayment extends Payment {
     public PayPalPayment(double amount) {
         super(amount);
     }
 
     @Override
     public double calculateFinalAmount() {
         return amount;
     }
 }
 
 public class PaymentSystem {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
 
            double amount = sc.nextDouble();
            String paymentMethod = sc.next().toLowerCase();

            if (amount < 0) {
                System.out.println("Invalid input");
                return;
            }

            Payment payment;
            switch (paymentMethod) {
                case "credit":
                    payment = new CreditPayment(amount);
                    break;
                case "debit":
                    payment = new DebitPayment(amount);
                    break;
                case "paypal":
                    payment = new PayPalPayment(amount);
                    break;
                default:
                    System.out.println("Invalid input");
                    return;
            }

            System.out.printf("Final amount charged: $%.2f%n", payment.calculateFinalAmount());
        sc.close();
     }
 }