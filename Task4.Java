import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Hardcoded exchange rates (for simplicity)
        double usdToEurRate = 0.93; // 1 USD = 0.93 EUR
        double usdToGbpRate = 0.80; // 1 USD = 0.80 GBP
        double eurToGbpRate = 0.86; // 1 EUR = 0.86 GBP

        System.out.println("Welcome to the Simple Currency Converter!");

        // Display available currencies
        System.out.println("Available currencies: USD, EUR, GBP");

        // Input base currency
        System.out.print("Enter the base currency (USD, EUR, GBP): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        // Input target currency
        System.out.print("Enter the target currency (USD, EUR, GBP): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Input amount to convert
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        // Perform conversion
        double convertedAmount = 0;
        boolean validConversion = true;

        switch (baseCurrency + "_TO_" + targetCurrency) {
            case "USD_TO_EUR":
                convertedAmount = amount * usdToEurRate;
                break;
            case "USD_TO_GBP":
                convertedAmount = amount * usdToGbpRate;
                break;
            case "EUR_TO_USD":
                convertedAmount = amount / usdToEurRate;
                break;
            case "EUR_TO_GBP":
                convertedAmount = amount * eurToGbpRate;
                break;
            case "GBP_TO_USD":
                convertedAmount = amount / usdToGbpRate;
                break;
            case "GBP_TO_EUR":
                convertedAmount = amount / eurToGbpRate;
                break;
            default:
                validConversion = false;
                System.out.println("Invalid currency pair. Please try again.");
        }

        // Display result
        if (validConversion) {
            System.out.printf("%.2f %s = %.2f %s\n", amount, baseCurrency, convertedAmount, targetCurrency);
        }

        scanner.close();
    }
}