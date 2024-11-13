import java.util.Scanner;

public class LibraryValidator {
    private static final Scanner scanner = new Scanner(System.in);

    public static String promptString(String message, int maxLength) {
        while (true) {
            System.out.print(message + ": ");
            String input = scanner.nextLine();
            if (input != null && !input.isBlank() && input.length() <= maxLength) {
                return input.trim();
            }
            System.out.printf("Моля, въведете валиден текст до %d символа.%n", maxLength);
        }
    }

    public static int promptInt(String message, int min, int max) {
        while (true) {
            System.out.print(message + ": ");
            try {
                int value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Моля, въведете валидно число.");
            }
            System.out.printf("Числото трябва да е между %d и %d.%n", min, max);
        }
    }

    public static boolean promptBoolean(String message) {
        while (true) {
            System.out.print(message + " (true/false): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            }
            System.out.println("Моля, въведете 'true' или 'false'.");
        }
    }
}
