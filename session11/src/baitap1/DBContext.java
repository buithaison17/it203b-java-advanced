package baitap1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBContext {
// Nguyên nhân: mở kết nối liên tục mà không đóng hoặc không quản lý tập trung
// Kết luận: luôn cần đóng kết nối và quản lý tập trung để đảm bảo hệ thống y tế chạy liên tục, ổn định
//    public static Connection getConnection() {
//        String url = "jdbc:mysql://localhost:3306/database";
//        String user = "root";
//        String password = "sonbui123";
//        try {
//            return DriverManager.getConnection(url, user, password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    // Viết lại
    private static String url = "jdbc:mysql://localhost:3306/database";
    private static String user = "root";
    private static String password = "sonbui123";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void main(String[] args) {
        // Thực hiện truy vấn dùng try with resources để tự động đóng kết nối
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "select  * from patients";
            statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}