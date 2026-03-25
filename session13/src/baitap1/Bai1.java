package baitap1;

import connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bai1 {
    public static void main(String[] args) {
        // Vì trong JDBC, khi Auto-Commit được bật mặc định, mỗi lệnh SQL được thực thi độc lập và tự động thực hiện COMMIT.
        // Khi có lỗi xảy ra ở giữa dòng code, nhưng không phải lỗi xảy ra trong lệnh SQL, thuốc trong kho đã bị trừ
        // nhưng dữ liệu không bị hủy bỏ vì lỗi xảy ra ở giữa dòng code không làm thay đổi trạng thái Auto-Commit.
        // Vì vậy, các lệnh SQL trước đó vẫn được thực thi và COMMIT, nên dữ liệu trong kho đã bị thay đổi.
        String sql = "update medicine_inventory set quantity = quantity - 1 where medicine_id = ?";
        Connection connection = DatabaseConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            preparedStatement.executeQuery();
            try {
                int x = 10 / 0;
            } catch (ArithmeticException e) {
                // Rollback nếu cos lỗi xảy ra
                connection.rollback();
            }
            // Commit nếu không có lỗi
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
