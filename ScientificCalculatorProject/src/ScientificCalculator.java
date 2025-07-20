import java.util.InputMismatchException;
import java.util.Scanner;

public class ScientificCalculator {

    // ===== ADDITION & SUBTRACTION =====
    public static double add(double a, double b) { return a + b; }
    public static double subtract(double a, double b) { return a - b; }

    private static void performAddition(Scanner scanner) {
        double[] nums = getTwoNumbers(scanner);
        System.out.println("Result: " + add(nums[0], nums[1]));
    }

    private static void performSubtraction(Scanner scanner) {
        double[] nums = getTwoNumbers(scanner);
        System.out.println("Result: " + subtract(nums[0], nums[1]));
    }

    // ===== MULTIPLICATION & DIVISION =====
    public static double multiply(double a, double b) { return a * b; }
    public static double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
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
        if (a < 0) throw new ArithmeticException("Cannot take square root of negative number");
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

    // ===== TRIGONOMETRIC FUNCTIONS =====
    public static double calculateSine(double degrees) {
        return Math.sin(Math.toRadians(degrees));
    }

    public static double calculateCosine(double degrees) {
        return Math.cos(Math.toRadians(degrees));
    }

    public static double calculateTangent(double degrees) {
        if ((degrees % 180) == 90)
            throw new ArithmeticException("Tangent undefined at " + degrees + " degrees");
        return Math.tan(Math.toRadians(degrees));
    }

    private static void performSine(Scanner scanner) {
        System.out.print("Enter angle in degrees: ");
        double degrees = scanner.nextDouble();
        System.out.println("Result: " + calculateSine(degrees));
    }

    private static void performCosine(Scanner scanner) {
        System.out.print("Enter angle in degrees: ");
        double degrees = scanner.nextDouble();
        System.out.println("Result: " + calculateCosine(degrees));
    }

    private static void performTangent(Scanner scanner) {
        System.out.print("Enter angle in degrees: ");
        double degrees = scanner.nextDouble();
        try {
            System.out.println("Result: " + calculateTangent(degrees));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ===== LOGARITHMIC FUNCTIONS =====
    public static double calculateNaturalLogarithm(double num) {
        if (num <= 0) throw new ArithmeticException("Natural log undefined for non-positive numbers");
        return Math.log(num);
    }

    public static double calculateLogarithmBase10(double num) {
        if (num <= 0) throw new ArithmeticException("Log base 10 undefined for non-positive numbers");
        return Math.log10(num);
    }

    private static void performNaturalLog(Scanner scanner) {
        System.out.print("Enter number: ");
        double num = scanner.nextDouble();
        try {
            System.out.println("Result: " + calculateNaturalLogarithm(num));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void performLogBase10(Scanner scanner) {
        System.out.print("Enter number: ");
        double num = scanner.nextDouble();
        try {
            System.out.println("Result: " + calculateLogarithmBase10(num));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ===== ROUNDING FUNCTIONS =====
    public static double roundNumber(double num) { return Math.round(num); }
    public static double ceilNumber(double num) { return Math.ceil(num); }
    public static double floorNumber(double num) { return Math.floor(num); }

    private static void performRound(Scanner scanner) {
        System.out.print("Enter number: ");
        double num = scanner.nextDouble();
        System.out.println("Rounded: " + roundNumber(num));
    }

    private static void performCeil(Scanner scanner) {
        System.out.print("Enter number: ");
        double num = scanner.nextDouble();
        System.out.println("Ceiling: " + ceilNumber(num));
    }

    private static void performFloor(Scanner scanner) {
        System.out.print("Enter number: ");
        double num = scanner.nextDouble();
        System.out.println("Floor: " + floorNumber(num));
    }

    // ===== ABS, MIN, MAX =====
    public static double absolute(double num) {
        return Math.abs(num);
    }

    public static double minimum(double a, double b) {
        return Math.min(a, b);
    }

    public static double maximum(double a, double b) {
        return Math.max(a, b);
    }

    private static void performAbsolute(Scanner scanner) {
        System.out.print("Enter number: ");
        double num = scanner.nextDouble();
        System.out.println("Absolute: " + absolute(num));
    }

    private static void performMin(Scanner scanner) {
        double[] nums = getTwoNumbers(scanner);
        System.out.println("Minimum: " + minimum(nums[0], nums[1]));
    }

    private static void performMax(Scanner scanner) {
        double[] nums = getTwoNumbers(scanner);
        System.out.println("Maximum: " + maximum(nums[0], nums[1]));
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

    // ===== MENU =====
    public static void displayMenu() {
        System.out.println("\n--- SCIENTIFIC CALCULATOR MENU ---");
        System.out.println("1.  Add");
        System.out.println("2.  Subtract");
        System.out.println("3.  Multiply");
        System.out.println("4.  Divide");
        System.out.println("5.  Square Root");
        System.out.println("6.  Power");
        System.out.println("7.  Sine");
        System.out.println("8.  Cosine");
        System.out.println("9.  Tangent");
        System.out.println("10. Natural Logarithm");
        System.out.println("11. Log Base 10");
        System.out.println("12. Round");
        System.out.println("13. Ceil");
        System.out.println("14. Floor");
        System.out.println("15. Absolute");
        System.out.println("16. Minimum");
        System.out.println("17. Maximum");
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
                case 7 -> performSine(scanner);
                case 8 -> performCosine(scanner);
                case 9 -> performTangent(scanner);
                case 10 -> performNaturalLog(scanner);
                case 11 -> performLogBase10(scanner);
                case 12 -> performRound(scanner);
                case 13 -> performCeil(scanner);
                case 14 -> performFloor(scanner);
                case 15 -> performAbsolute(scanner);
                case 16 -> performMin(scanner);
                case 17 -> performMax(scanner);
                case 0 -> System.out.println("Calculator closed.");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        scanner.close();
    }
}
