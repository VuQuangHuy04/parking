
package dao;

import database.DBConnect;
import model.Ticket;
import java.sql.*;

public class CheckoutDAO {
    public static Ticket findByLicensePlate(String plate) {
        Ticket ticket = null;
        String sql = "SELECT * FROM ticket_details WHERE license_plate = ?";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, plate);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ticket = new Ticket(
                    rs.getString("ticket_id"),
                    rs.getString("license_plate"),
                    rs.getString("vehicle_type"),
                    rs.getString("parking_date"),
                    rs.getString("checkin_time"),
                    rs.getString("checkout_time")
                );
            }

            rs.close(); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
        return ticket;
    }

    public static boolean updateCheckoutTime(String ticketId, String checkoutTime) {
        String sql = "UPDATE ticket_details SET checkout_time = ? WHERE ticket_id = ?";
    
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, checkoutTime);
            stmt.setString(2, ticketId);
            return stmt.executeUpdate() > 0;

        } catch (Exception ex) { 
            ex.printStackTrace();
            return false;
        }
    }
    //lấy giá vé theo loại xe
    public static int getFareAmount(String vehicleType) {
        String sql = "SELECT fare_amount FROM parking_fare WHERE vehicle_type = ?";
        try (Connection conn = database.DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, vehicleType);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("fare_amount");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return vehicleType.equalsIgnoreCase("Car") ? 20000 : 10000; // Giá mặc định phòng hờ lỗi DB
    }
}
