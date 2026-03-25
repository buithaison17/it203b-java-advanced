package baitap2;

import connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bai2 {
    public static void main(String[] args) {
        // Không nên dùng System.out.println() để in ra lỗi ngoài việc log
        // vì nó không thể rollback nếu có lỗi xảy ra trong khối catch
        // do đó là vi phạm nguyên tắc của Transaction (transactional integrity)
        Connection connection = DatabaseConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement1 = connection.prepareStatement("update patient_wallet set balance = balance - ? where patient_id = ?");
            statement1.setDouble(1, 1000);
            statement1.setInt(2, 3);
            statement1.executeUpdate();
            PreparedStatement statement2 = connection.prepareStatement("update invoicess set status = 'PAID' where invoice_id = ?");
            statement2.setInt(1, 2);
            statement2.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            // Rollback khi có lỗi SQL xảy ra
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
