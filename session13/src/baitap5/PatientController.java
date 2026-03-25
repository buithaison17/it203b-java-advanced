package baitap5;

import connection.DatabaseConnection;

import java.sql.*;

public class PatientController {
    // Phân tích rủi ro và bẫy lỗi
    // - Nhập sai kiểu dữ liệu: nhập chữ thay vì số sẽ có ngoại lệ gây crash chương trình
    // - Giường đã có người năm nhưng vẫn chọn được: ghi đè dữ lệu, sai logic
    // - Tiền âm hoặc bằng 0: sai logic
    // Luồng chức năng
    //  1. Nhập thông tin bệnh nhân
    // 2. Validate dữ liệu đầu vào
    // 3. Mở kết nối database
    // 4. setAutoCommnit(false)
    // 5. Thực hiện
    // - Insert bệnh nhân
    // - Update giường bệnh
    // - Insert tài chính
    // 6. Commit nếu tất cả thành công
    // 7 . Rollback nếu thấy bại
    // 8. In thông báo
    // 9. Đóng kết nối với database
    // Thiết kế databse
    // Patients: patient_id, name, age, bed_id
    // Beds: bed_id, status
    // finaces: id, patient_id, bed_id, amount, created_at
    public void addPatient(String name, int age, int bedId, double amount) {
        Connection connection = null;
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            // Insert bệnh nhân
            String addPatientSql = "insert into  patients(name, age, bed_id) values(?, ?, ?)";
            PreparedStatement stmAddPatient = connection.prepareStatement(addPatientSql, Statement.RETURN_GENERATED_KEYS);
            stmAddPatient.setString(1, name);
            stmAddPatient.setInt(2, age);
            stmAddPatient.setInt(3, bedId);
            int resultAddPatient = stmAddPatient.executeUpdate();
            ResultSet key = stmAddPatient.getGeneratedKeys();
            key.next();
            int patientId = key.getInt(1);
            System.out.println(patientId);

            // Update giường bệnh
            String updateBedSql = "update beds set status = 'OCCUPIED' where bed_id = ? and  status = 'AVAILABLE'";
            PreparedStatement stmUpdateBed = connection.prepareStatement(updateBedSql);
            stmUpdateBed.setInt(1, bedId);
            int resultUpdateBed = stmUpdateBed.executeUpdate();

            // Insert tài chính
            String insertFinaceSql = "insert into finances(patient_id, bed_id, amount) values (?, ?, ?)";
            PreparedStatement stmInsertFinace = connection.prepareStatement(insertFinaceSql);
            stmInsertFinace.setInt(1, patientId);
            stmInsertFinace.setInt(2, bedId);
            stmInsertFinace.setDouble(3, amount);
            int resultInsertFinace = stmInsertFinace.executeUpdate();

            if (resultAddPatient <= 0 || resultInsertFinace <= 0 || resultUpdateBed <= 0) {
                System.out.println("Thất bại");
                connection.rollback();
            } else {
                System.out.println("Thành công");
                connection.commit();
            }

        } catch (SQLException e) {
            try {
                System.out.println("Đã có lỗi xảy ra");
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                try {
                    connection.close();
                } catch (SQLException exception) {
                    throw new RuntimeException(exception);
                }
            }
        }

    }

    public void displayAllBedAvailable() {
        try (Connection connection = DatabaseConnection.getInstance().getConnection(); PreparedStatement stm = connection.prepareStatement("select bed_id, status from beds where  status = 'AVAILABLE'")) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int bedId = rs.getInt("bed_id");
                String status = rs.getString("status");
                System.out.printf("ID: %d, Trạng thái: %s\n", bedId, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
