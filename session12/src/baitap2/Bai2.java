package baitap2;

import connections.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Bai2 {
    public static void main(String[] args) {
        // Phân tích: setDouble() và setInt() là các phương thức của PreparedStatement,
        // chúng được thiết kế để tự động định dạng theo đúng cú pháp của cơ sở dữ liệu.
        // Điều này giúp lập trình viên không cần phải lo lắng về định dạng dấu chấm hoặc dấu phẩy của hệ điều hành.
        // Mỗi phương thức này sẽ tự động định dạng giá trị đầu vào dựa trên kiểu dữ liệu của cột trong cơ sở dữ liệu.
        // Ví dụ, nếu cột temperature trong cơ sở dữ liệu được định nghĩa dưới dạng số thực,
        // thì setDouble() sẽ đảm bảo rằng giá trị được định dạng dựa trên quy ước của cơ sở dữ liệu.
        String sql = "update  vitals set temperature = ? where id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, 55);
            statement.setInt(2, 1);
            statement.executeUpdate();
            System.out.println("Cập nhật thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
