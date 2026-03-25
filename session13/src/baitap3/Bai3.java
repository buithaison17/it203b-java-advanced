package baitap3;

import connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bai3 {
    public static void xuatVienVaThanhToan(int patientId, double amount) {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);

            // Thanh toán viện phí
            String payAmountSql = "update patients set balance = blance - ? where patient_id = ?";
            PreparedStatement statement1 = connection.prepareStatement(payAmountSql);
            statement1.setDouble(1, amount);
            statement1.setInt(2, patientId);
            int res1 = statement1.executeUpdate();

            // Cập nhật trạng thái bệnh nhân
            String updatePatientSql = "update patients set status = 'DA XUAT VIEN' where patient_id = ?";
            PreparedStatement statement2 = connection.prepareStatement(updatePatientSql);
            statement2.setInt(1, patientId);
            int res2 = statement2.executeUpdate();

            // Cập nhập trạng thái giường
            String updateBedSql = """
                    update beds b
                    join assignedBed a on a.bed_id = b.id
                    join patients p on a.patient_id = p.id
                    set b.status = 'CO SAN'
                    where p.id = ? and p.status = 'DA XUAT VIEN'
                    """;
            PreparedStatement statement3 = connection.prepareStatement(updateBedSql);
            statement3.setInt(1, patientId);
            int res3 = statement3.executeUpdate();

            // Kiểm tra điều kiện
            if (res1 <= 0 || res2 <= 0 || res3 <= 0) {
                connection.rollback();
            } else {
                connection.commit();
            }
        } catch (SQLException e) {
            // Rollback nếu có lỗi trong CSDL
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

    public static void main(String[] args) {
        xuatVienVaThanhToan(2, 100000);
    }
}
