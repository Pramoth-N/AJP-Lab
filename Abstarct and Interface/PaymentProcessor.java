import java.util.Scanner;
import java.util.regex.Pattern;

interface PaymentMethod {
    boolean validate();
    void processPayment();
}

class CreditCardPayment implements PaymentMethod {
    private String cardNumber;
    private String cardholderName;
    private String expirationDate;

    public CreditCardPayment(String cardNumber, String cardholderName, String expirationDate) {
        this.cardNumber = cardNumber;
        this.cardholderName = cardholderName;
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean validate() {
        return validateCardNumber(cardNumber) && validateExpirationDate(expirationDate) && !cardholderName.isEmpty();
    }

    private boolean validateCardNumber(String cardNumber) {
        return Pattern.matches("\\d{4}-\\d{4}-\\d{4}-\\d{4}", cardNumber); // 16-digit card number
    }

    private boolean validateExpirationDate(String expirationDate) {
        return Pattern.matches("(0[1-9]|1[0-2])/\\d{2}", expirationDate); // MM/YY
    }

    @Override
    public void processPayment() {
        System.out.println("Payment method: CreditCard");
        System.out.println("Cardholder: " + cardholderName);
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Expiration Date: " + expirationDate);
    }
}

class PayPalPayment implements PaymentMethod {
    private String email;
    private String transactionID;

    public PayPalPayment(String email, String transactionID) {
        this.email = email;
        this.transactionID = transactionID;
    }

    @Override
    public boolean validate() {
        return validateEmail(email) && validateTransactionID(transactionID);
    }

    private boolean validateEmail(String email) {
        return Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email);
    }

    private boolean validateTransactionID(String transactionID) {
        return transactionID.matches("[A-Za-z0-9]+");
    }

    @Override
    public void processPayment() {
        System.out.println("Payment method: PayPal");
        System.out.println("Email: " + email);
        System.out.println("Transaction ID: " + transactionID);
    }
}

public class PaymentProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String paymentType = sc.nextLine();
        PaymentMethod paymentMethod = null;

        if (paymentType.equalsIgnoreCase("CreditCard")) {
            String cardNumber = sc.next();
            String cardholderName = sc.next();
            String expirationDate = sc.next();
            paymentMethod = new CreditCardPayment(cardNumber, cardholderName, expirationDate);
        } else if (paymentType.equalsIgnoreCase("PayPal")) {
            String email = sc.next();
            String transactionID = sc.next();
            paymentMethod = new PayPalPayment(email, transactionID);
        } else {
            System.out.println("Invalid input");
            sc.close();
            return;
        }
        sc.close();
        if (paymentMethod.validate()) {
            paymentMethod.processPayment();
        } else {
            System.out.println("Invalid input");
        }
        
    }
}
