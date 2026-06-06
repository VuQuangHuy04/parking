
package dao;

import database.DBConnect;
import model.Ticket;
import java.sql.*;

public class CheckinDAO {
    public static boolean isLicensePlateExists(String plate) {
        String sql = "SELECT COUNT(*) FROM ticket_details WHERE license_plate = ?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, plate);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        } 
         return false;
    }

    public static boolean insertTicket(Ticket ticket) {
        String sql = "INSERT INTO ticket_details (ticket_id, license_plate, vehicle_type, parking_date, checkin_time, checkout_time) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ticket.getTicketId());
            stmt.setString(2, ticket.getLicensePlate());
            stmt.setString(3, ticket.getVehicleType());
            stmt.setString(4, ticket.getDate());
            stmt.setString(5, ticket.getCheckin());
            
            if (ticket.getCheckout() == null || ticket.getCheckout().isEmpty()) {
                stmt.setNull(6, java.sql.Types.TIME);
            } else {
                stmt.setString(6, ticket.getCheckout());
            }

            return stmt.executeUpdate() > 0;
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
         return false;
    }

    public static String generateTicketId() {
        String sql = "SELECT ticket_id FROM ticket_details ORDER BY ticket_id DESC LIMIT 1";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            int nextId = 1;
            if (rs.next()) {
                String lastId = rs.getString("ticket_id");
                String numberPart = lastId.substring(2);
                nextId = Integer.parseInt(numberPart) + 1;
            }
            return String.format("VX%03d", nextId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null; 
        }
    }
}
