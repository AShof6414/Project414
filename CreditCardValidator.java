import java.util.Scanner;

public class CreditCardValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for credit card no.
        System.out.print("Enter your credit card number: ");
        long creditCardNumber = scanner.nextLong();

        // Converting credit card number to a string
        String cardNumberString = String.valueOf(creditCardNumber);

        // Based on the first digits, the card type is to be determined
        String cardType;
        if (cardNumberString.startsWith("34") || cardNumberString.startsWith("37")) {
            cardType = "American Express";
        } else if (cardNumberString.startsWith("51") || cardNumberString.startsWith("52") ||
                   cardNumberString.startsWith("53") || cardNumberString.startsWith("54") ||
                   cardNumberString.startsWith("55")) {
            cardType = "MasterCard";
        } else if (cardNumberString.startsWith("4")) {
            cardType = "Visa";
        } else {
            cardType = "Unknown";
        }

        // Result output
        System.out.println("Card Type: " + cardType);

        // Close the scanner
        scanner.close();
    }
}

