package dao;

import database.DBConnect;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RevenueDAO {
    public static ArrayList<Object[]> getRevenue(String type, String input, String vehicleFilter) throws Exception {
        ArrayList<Object[]> result = new ArrayList<>();
        Connection conn = DBConnect.getConnection();

        String condition = "";
        if (type.equals("Date")) type = "Day";

        // 1. Kiểm tra định dạng đầu vào dựa trên loại thống kê
        switch (type.trim()) {
            case "Day":
                if (!input.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    throw new IllegalArgumentException("Input for Date must be in format YYYY-MM-DD");
                }
                condition = "parking_date = ?";
                break;
            case "Month":
                if (!input.matches("\\d{2}-\\d{4}")) {
                    throw new IllegalArgumentException("Input for Month must be in format MM-YYYY");
                }
                condition = "MONTH(parking_date) = ? AND YEAR(parking_date) = ?";
                break;
            case "Year":
                if (!input.matches("\\d{4}")) {
                    throw new IllegalArgumentException("Input for Year must be in format YYYY");
                }
                condition = "YEAR(parking_date) = ?";
                break;
            default:
                throw new IllegalArgumentException("Invalid time type: " + type);
        }

        // 2. Lấy cấu hình giá vé động từ Database thay vì fix cứng
        HashMap<String, Integer> currentFares = FareDAO.getAllFares();
        int motorbikePrice = currentFares.getOrDefault("Motorbike", 10000); // Giá mặc định 10k nếu lỗi DB
        int carPrice = currentFares.getOrDefault("Car", 20000);             // Giá mặc định 20k nếu lỗi DB

        // 3. Xây dựng câu lệnh SQL Query để đếm số lượng xe theo loại
        String query = "SELECT vehicle_type, COUNT(*) AS count FROM ticket_details WHERE " + condition;

        if (!vehicleFilter.equals("All")) {
            query += " AND vehicle_type = ?";
        }

        query += " GROUP BY vehicle_type";

        PreparedStatement ps = conn.prepareStatement(query);

        // 4. Truyền tham số cho PreparedStatement
        if (type.equals("Day")) {
            ps.setString(1, input);
            if (!vehicleFilter.equals("All")) ps.setString(2, vehicleFilter);
        } else if (type.equals("Month")) {
            String[] parts = input.split("-");
            ps.setInt(1, Integer.parseInt(parts[0]));
            ps.setInt(2, Integer.parseInt(parts[1]));
            if (!vehicleFilter.equals("All")) ps.setString(3, vehicleFilter);
        } else if (type.equals("Year")) {
            ps.setInt(1, Integer.parseInt(input));
            if (!vehicleFilter.equals("All")) ps.setString(2, vehicleFilter);
        }

        ResultSet rs = ps.executeQuery();

        int motorbikeCount = 0, carCount = 0;

        // 5. Đọc dữ liệu số lượng xe từ kết quả truy vấn
        while (rs.next()) {
            String typeVehicle = rs.getString("vehicle_type");
            int count = rs.getInt("count");

            if (typeVehicle.equalsIgnoreCase("Motorbike")) {
                motorbikeCount = count;
            } else if (typeVehicle.equalsIgnoreCase("Car")) {
                carCount = count;
            }
        }

        // 6. Tính toán tổng doanh thu dựa trên giá vé động vừa lấy từ DB
        int totalRevenue = (motorbikeCount * motorbikePrice) + (carCount * carPrice);

        // 7. Xử lý hiển thị dữ liệu lên JTable dựa trên bộ lọc loại xe
        Object carCountDisplay = vehicleFilter.equals("Motorbike") ? "" : carCount;
        Object carPriceDisplay = vehicleFilter.equals("Motorbike") ? "" : carPrice;

        Object motorbikeCountDisplay = vehicleFilter.equals("Car") ? "" : motorbikeCount;
        Object motorbikePriceDisplay = vehicleFilter.equals("Car") ? "" : motorbikePrice;

        result.add(new Object[] {
                carCountDisplay,
                motorbikeCountDisplay,
                carPriceDisplay,
                motorbikePriceDisplay,
                totalRevenue
        });

        // 8. Đóng kết nối an toàn
        rs.close();
        ps.close();
        conn.close();
        return result;
    }
}