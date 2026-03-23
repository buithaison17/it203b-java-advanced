package baitap3;

import connections.DatabaseConnection;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class Bai3 {
    public static void main(String[] args) {
        // - Khi thực hiện câu truy vấn với tham số đầu ra là kiểu DECIMAL, JDBC bắt buộc phải biết kiểu dữ liệu của tham số đầu ra
        // trước khi thực thi. Điều này đảm bảo rằng JDBC có thể định dạng giá trị đầu ra dựa trên kiểu dữ liệu của cột trong cơ sở dữ liệu.
        // - Khi sử dụng registerOutParameter(), chúng ta phải đăng ký kiểu dữ liệu của tham số đầu ra bằng cách sử dụng hằng số tương ứng trong lớp Types.
        // Ví dụ, nếu tham số đầu ra là kiểu DECIMAL(10, 2) trong SQL, chúng ta sẽ đăng ký nó bằng hằng số Types.DECIMAL và truyền vào đó số chiều là 10 và số hậu cho là 2.
        // - Việc đăng ký kiểu dữ liệu của tham số đầu ra là bắt buộc, vì nếu không sẽ gây ra lỗi khi thực thi câu truy vấn.
        String sql = "call  get_surgery_fee(?,?)";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             CallableStatement statement = connection.prepareCall(sql)) {
            statement.registerOutParameter(2, Types.DECIMAL);
            statement.setInt(1, 1);
            statement.execute();
            BigDecimal fee = statement.getBigDecimal(2);
            System.out.println(fee);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
