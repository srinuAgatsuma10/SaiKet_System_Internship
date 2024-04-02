import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nTemperature Converter Menu:");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1-3): ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    celsiusToFahrenheit(scanner);
                    break;
                case 2:
                    fahrenheitToCelsius(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the temperature converter. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
    
    // Method to convert Celsius to Fahrenheit
    private static void celsiusToFahrenheit(Scanner scanner) {
        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println(celsius + " Celsius is equal to " + fahrenheit + " Fahrenheit");
    }
    
    // Method to convert Fahrenheit to Celsius
    private static void fahrenheitToCelsius(Scanner scanner) {
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();
        double celsius = (fahrenheit - 32) * 5 / 9;
        System.out.println(fahrenheit + " Fahrenheit is equal to " + celsius + " Celsius");
    }
}
