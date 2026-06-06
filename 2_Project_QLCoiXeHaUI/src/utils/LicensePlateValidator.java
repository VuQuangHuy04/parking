
package utils;

public class LicensePlateValidator {
    public static boolean isValidLicensePlate(String plate) {
        return plate != null && plate.matches("\\d{2}[A-Z]-\\d{5}");
    }
}
