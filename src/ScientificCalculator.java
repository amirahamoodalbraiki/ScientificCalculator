import java.util.InputMismatchException;
import java.util.Scanner;

public class ScientificCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();

            System.out.print("Choose an option (1-18): ");
            int choice;

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // clear buffer
                continue;
            }

            switch (choice) {
                case 1 -> performAddition(scanner);
                case 2 -> performSubtraction(scanner);
                case 3 -> performMultiplication(scanner);
                case 4 -> performDivision(scanner);
                case 5 -> performSquareRoot(scanner);
                case 6 -> performPower(scanner);
                case 7 -> performSine(scanner);
                case 8 -> performCosine(scanner);
                case 9 -> performTangent(scanner);
                case 10 -> performNaturalLog(scanner);
                case 11 -> performLogBase10(scanner);
                case 12 -> performAbsoluteValue(scanner);
                case 13 -> performRound(scanner);
                case 14 -> performCeiling(scanner);
                case 15 -> performFloor(scanner);
                case 16 -> performMin(scanner);
                case 17 -> performMax(scanner);
                case 18 -> exit = true;
                default -> System.out.println("Invalid choice! Try again.");
            }
        }

        scanner.close();
        System.out.println("Calculator closed.");
    }

    public static void displayMenu() {
        System.out.println("\n=== Scientific Calculator Menu ===");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println("5. Square Root (√x)");
        System.out.println("6. Power (x^y)");
        System.out.println("7. Sine (sin x)");
        System.out.println("8. Cosine (cos x)");
        System.out.println("9. Tangent (tan x)");
        System.out.println("10. Natural Logarithm (ln x)");
        System.out.println("11. Logarithm Base 10 (log₁₀ x)");
        System.out.println("12. Absolute Value (|x|)");
        System.out.println("13. Round to nearest integer");
        System.out.println("14. Ceiling (round up)");
        System.out.println("15. Floor (round down)");
        System.out.println("16. Minimum of two numbers");
        System.out.println("17. Maximum of two numbers");
        System.out.println("18. Exit");
    }

    // --- Arithmetic Methods ---
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        return a / b;
    }

    // --- Scientific Methods ---
    public static double calculateSquareRoot(double a) {
        if (a < 0) throw new ArithmeticException("Cannot take square root of negative number");
        return Math.sqrt(a);
    }

    public static double calculatePower(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static double calculateSine(double degrees) {
        return Math.sin(Math.toRadians(degrees));
    }

    public static double calculateCosine(double degrees) {
        return Math.cos(Math.toRadians(degrees));
    }

    public static double calculateTangent(double degrees) {
        double radians = Math.toRadians(degrees);
        if ((degrees % 180) == 90) throw new ArithmeticException("Tangent undefined at " + degrees + " degrees");
        return Math.tan(radians);
    }

    public static double calculateNaturalLogarithm(double num) {
        if (num <= 0) throw new ArithmeticException("Logarithm of non-positive number is undefined");
        return Math.log(num);
    }

    public static double calculateLogarithmBase10(double num) {
        if (num <= 0) throw new ArithmeticException("Log base 10 of non-positive number is undefined");
        return Math.log10(num);
    }

    public static double calculateAbsoluteValue(double num) {
        return Math.abs(num);
    }

    public static long roundNumber(double num) {
        return Math.round(num);
    }

    public static double ceilingNumber(double num) {
        return Math.ceil(num);
    }

    public static double floorNumber(double num) {
        return Math.floor(num);
    }

    public static double findMin(double a, double b) {
        return Math.min(a, b);
    }

    public static double findMax(double a, double b) {
        return Math.max(a, b);
    }

    // --- Perform Methods ---
    private static void performAddition(Scanner scanner) {
        double[] nums = getTwoNumbers(scanner);
        System.out.println("Result: " + add(nums[0], nums[1]));
    }

    private static void performSubtraction(Scanner scanner) {
        double[] nums = getTwoNumbers(scanner);
        System.out.println("Result: " + subtract(nums[0], nums[1]));
    }

    private static void performMultiplication(Scanner scanner) {
        double[] nums = getTwoNumbers(scanner);
        System.out.println("Result: " + multiply(nums[0], nums[1]));
    }

    private static void performDivision(Scanner scanner) {
        try {
            double[] nums = getTwoNumbers(scanner);
            System.out.println("Result: " + divide(nums[0], nums[1]));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void performSquareRoot(Scanner scanner) {
        double num = getOneNumber(scanner);
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

    private static void performSine(Scanner scanner) {
        double degrees = getOneNumber(scanner);
        System.out.println("Result: " + calculateSine(degrees));
    }

    private static void performCosine(Scanner scanner) {
        double degrees = getOneNumber(scanner);
        System.out.println("Result: " + calculateCosine(degrees));
    }

    private static void performTangent(Scanner scanner) {
        double degrees = getOneNumber(scanner);
        try {
            System.out.println("Result: " + calculateTangent(degrees));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void performNaturalLog(Scanner scanner) {
        double num = getOneNumber(scanner);
        try {
            System.out.println("Result: " + calculateNaturalLogarithm(num));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void performLogBase10(Scanner scanner) {
        double num = getOneNumber(scanner);
        try {
            System.out.println("Result: " + calculateLogarithmBase10(num));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void performAbsoluteValue(Scanner scanner) {
        double num = getOneNumber(scanner);
        System.out.println("Result: " + calculateAbsoluteValue(num));
    }

    private static void performRound(Scanner scanner) {
        double num = getOneNumber(scanner);
        System.out.println("Result: " + roundNumber(num));
    }

    private static void performCeiling(Scanner scanner) {
        double num = getOneNumber(scanner);
        System.out.println("Result: " + ceilingNumber(num));
    }

    private static void performFloor(Scanner scanner) {
        double num = getOneNumber(scanner);
        System.out.println("Result: " + floorNumber(num));
    }

    private static void performMin(Scanner scanner) {
        double[] nums = getTwoNumbers(scanner);
        System.out.println("Result: " + findMin(nums[0], nums[1]));
    }

    private static void performMax(Scanner scanner) {
        double[] nums = getTwoNumbers(scanner);
        System.out.println("Result: " + findMax(nums[0], nums[1]));
    }

    // --- Input Helpers ---
    private static double[] getTwoNumbers(Scanner scanner) {
        try {
            System.out.print("Enter first number: ");
            double a = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double b = scanner.nextDouble();
            return new double[]{a, b};
        } catch (InputMismatchException e) {
            scanner.next(); // clear invalid input
            System.out.println("Invalid input! Enter numbers only.");
            return getTwoNumbers(scanner); // retry
        }
    }

    private static double getOneNumber(Scanner scanner) {
        try {
            System.out.print("Enter number: ");
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            scanner.next(); // clear invalid input
            System.out.println("Invalid input! Enter a number.");
            return getOneNumber(scanner); // retry
        }
    }
}
