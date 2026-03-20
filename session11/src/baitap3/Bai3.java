package baitap3;

import baitap1.DBContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Bai3 {
    public static void main(String[] args) {
        try (
                Connection connection = DBContext.getConnection();
                Statement statement = connection.createStatement();
        ) {
            String sql = "UPDATE beds SET bed_status = 'available' WHERE id = 1;";
            // executeUpdate() dùng để thực hiện các câu lệnh như thê, xóa, cập nhật, ...
            // và trả về số dòng ảnh hưởng
            // Nếu giá trị trả về lớn hơn 0 y tá sẽ biết được mã giường này có tồn tại hay không
            int rowEffect = statement.executeUpdate(sql);
            // Kiểm tra số dòng tác động và in thông báo tương ứng
            if (rowEffect > 0) {
                System.out.println("Cập nhật thành công");
            } else {
                System.out.println("Không tìm thấy giướng");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
