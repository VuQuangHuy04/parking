package dao;

import database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class FareDAO {
    // Lấy toàn bộ giá vé hiện tại từ DB
    public static HashMap<String, Integer> getAllFares() {
        HashMap<String, Integer> fares = new HashMap<>();
        String sql = "SELECT * FROM parking_fare";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                fares.put(rs.getString("vehicle_type"), rs.getInt("fare_amount"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return fares;
    }
    // Cập nhật giá vé mới cho một loại xe
    public static boolean updateFare(String vehicleType, int newAmount) {
        String sql = "UPDATE parking_fare SET fare_amount = ? WHERE vehicle_type = ?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, newAmount);
            stmt.setString(2, vehicleType);
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}