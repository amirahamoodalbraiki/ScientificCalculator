import java.util.InputMismatchException;
import java.util.Scanner;

public class ScientificCalculator {

    // ===== ADDITION & SUBTRACTION =====

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    private static void performAddition(Scanner scanner) {
        double[] nums = getTwoNumbers(scanner);
        System.out.println("Result: " + add(nums[0], nums[1]));
    }

    private static void performSubtraction(Scanner scanner) {
        double[] nums = getTwoNumbers(scanner);
        System.out.println("Result: " + subtract(nums[0], nums[1]));
    }

    // ===== MULTIPLICATION & DIVISION =====

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    private static void performMultiplication(Scanner scanner) {
        double[] nums = getTwoNumbers(scanner);
        System.out.println("Result: " + multiply(nums[0], nums[1]));
    }

    private static void performDivision(Scanner scanner) {
        double[] nums = getTwoNumbers(scanner);
        try {
            System.out.println("Result: " + divide(nums[0], nums[1]));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ===== SQUARE ROOT & POWER =====

    public static double calculateSquareRoot(double a) {
        if (a < 0) {
            throw new ArithmeticException("Cannot take square root of negative number");
        }
        return Math.sqrt(a);
    }

    public static double calculatePower(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    private static void performSquareRoot(Scanner scanner) {
        System.out.print("Enter number: ");
        double num = scanner.nextDouble();
        try {
            System.out.println("Result: " + calculateSquareRoot(num));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void performPower(Scanner scanner) {
        double[] nums = getTwoNumbers(scanner);
        System.out.println("Result: " + calculatePower(nums[0], nums[1]));
    }

    // ===== INPUT UTILITY =====

    private static double[] getTwoNumbers(Scanner scanner) {
        double[] nums = new double[2];
        try {
            System.out.print("Enter first number: ");
            nums[0] = scanner.nextDouble();
            System.out.print("Enter second number: ");
            nums[1] = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
            scanner.next();
        }
        return nums;
    }

    // ===== MAIN & MENU =====

    public static void displayMenu() {
        System.out.println("\n--- SCIENTIFIC CALCULATOR MENU ---");
        System.out.println("1.  Add");
        System.out.println("2.  Subtract");
        System.out.println("3.  Multiply");
        System.out.println("4.  Divide");
        System.out.println("5.  Square Root");
        System.out.println("6.  Power");
        System.out.println("0.  Exit");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> performAddition(scanner);
                case 2 -> performSubtraction(scanner);
                case 3 -> performMultiplication(scanner);
                case 4 -> performDivision(scanner);
                case 5 -> performSquareRoot(scanner);
                case 6 -> performPower(scanner);
                case 0 -> System.out.println("Calculator closed.");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        scanner.close();
    }
}
