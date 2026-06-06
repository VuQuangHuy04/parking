
package utils;

public class TicketIdValidator {
    public static boolean isValidTicketId(String id) {
        return id != null && id.matches("VX\\d{3}");
    }
}
