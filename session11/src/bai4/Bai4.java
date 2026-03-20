package bai4;

import baitap1.DBContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Bai4 {
    public static void main(String[] args) {
        try (Connection connection = DBContext.getConnection();
             Statement statement = connection.createStatement()) {
            // name = '' → không đúng với bất kỳ bệnh nhân nào
            // nếu nhập thêm OR '1'='1' thì sẽ luôn đúng vì 1 luôn bằng 1.
            // Toàn bộ mệnh đề WHERE trở thành TRUE, dẫn đến việc truy xuất tất cả bản ghi trong bảng patients.
            String patientName = "sonbui";
            // String sql = "select * from patients where patient_name = '" + patientName + "'";
            // Giải pháp là lại bảo toàn bộ cái kí tự nguy hiểm trước khi nối SQL
            String sql = String.format("select * from patients where patient_name = '%s'", patientName);
            sql = sql.replaceAll("--", "");
            sql = sql.replaceAll(";", "");
            statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
