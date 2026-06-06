
package utils;

public class DateValidator {
    public static boolean isDateFormat(String input) {
        return input.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    public static boolean isMonthFormat(String input) {
        return input.matches("\\d{2}-\\d{4}");
    }

    public static boolean isYearFormat(String input) {
        return input.matches("\\d{4}");
    }

    public static boolean isValidDate(String input) {
        return isDateFormat(input) ||
               isMonthFormat(input) ||
               isYearFormat(input);
    }
}
