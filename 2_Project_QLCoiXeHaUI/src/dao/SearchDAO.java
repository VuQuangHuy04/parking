
package dao;

import database.DBConnect;
import java.util.ArrayList;
import model.Ticket;
import java.sql.*;
import utils.DateValidator;

public class SearchDAO {

    public static ArrayList<Ticket> searchAll(String keyword, String field) {
        ArrayList<Ticket> list = new ArrayList<>();

        try (Connection conn = DBConnect.getConnection()) {
            String sql;
            PreparedStatement stmt;

            if (field.equals("parking_date")) {
                if (DateValidator.isMonthFormat(keyword)) {
                    sql = "SELECT * FROM ticket_details WHERE MONTH(parking_date) = ? AND YEAR(parking_date) = ?";
                    stmt = conn.prepareStatement(sql);
                    String[] parts = keyword.split("-");
                    stmt.setInt(1, Integer.parseInt(parts[0]));
                    stmt.setInt(2, Integer.parseInt(parts[1]));
                } else if (DateValidator.isYearFormat(keyword)) {
                    sql = "SELECT * FROM ticket_details WHERE YEAR(parking_date) = ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, Integer.parseInt(keyword));
                } else {
                    sql = "SELECT * FROM ticket_details WHERE parking_date = ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, keyword);
                }
            } else {
                sql = "SELECT * FROM ticket_details WHERE " + field + " LIKE ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, "%" + keyword + "%");
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Ticket d = new Ticket(
                        rs.getString("ticket_id"),
                        rs.getString("license_plate"),
                        rs.getString("vehicle_type"),
                        rs.getString("parking_date"),
                        rs.getString("checkin_time"),
                        rs.getString("checkout_time")
                );
                list.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static ArrayList<Ticket> search(String keyword, String field, String vehicleType) {
        ArrayList<Ticket> list = new ArrayList<>();

        try (Connection conn = DBConnect.getConnection()) {
            String sql;
            PreparedStatement stmt;

            if (field.equals("parking_date")) {
                if (DateValidator.isMonthFormat(keyword)) {
                    sql = "SELECT * FROM ticket_details WHERE vehicle_type = ? AND MONTH(parking_date) = ? AND YEAR(parking_date) = ?";
                    stmt = conn.prepareStatement(sql);
                    String[] parts = keyword.split("-");
                    stmt.setString(1, vehicleType);
                    stmt.setInt(2, Integer.parseInt(parts[0]));
                    stmt.setInt(3, Integer.parseInt(parts[1]));
                } else if (DateValidator.isYearFormat(keyword)) {
                    sql = "SELECT * FROM ticket_details WHERE vehicle_type = ? AND YEAR(parking_date) = ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, vehicleType);
                    stmt.setInt(2, Integer.parseInt(keyword));
                } else {
                    sql = "SELECT * FROM ticket_details WHERE vehicle_type = ? AND parking_date = ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, vehicleType);
                    stmt.setString(2, keyword);
                }
            } else {
                sql = "SELECT * FROM ticket_details WHERE vehicle_type = ? AND " + field + " LIKE ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, vehicleType);
                stmt.setString(2, "%" + keyword + "%");
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Ticket d = new Ticket(
                        rs.getString("ticket_id"),
                        rs.getString("license_plate"),
                        rs.getString("vehicle_type"),
                        rs.getString("parking_date"),
                        rs.getString("checkin_time"),
                        rs.getString("checkout_time")
                );
                list.add(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
