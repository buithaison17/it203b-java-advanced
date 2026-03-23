package baitap4;

import connections.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bai4 {
    public static void main(String[] args) {
        // Đối với cơ sở dữ liệu quan hệ, việc phân tích (Parse) và lập kế hoạch thực thi (Execution Plan) thường đòi hỏi quá trình phân tích cấu trúc câu lệnh và tìm kiếm các thông tin cần thiết như thông tin về các cột, bảng, và các tiêu chí tìm kiếm.
        // Để tối ưu hóa quá trình này, cơ sở dữ liệu sẽ được lưu trữ các thông tin này trong bộ nhớ cache. Khi cần thiết, các thông tin này sẽ được tải lên từ bộ nhớ cache vào bộ nhớ vật lý để thực hiện các thao tác liên quan đến cấu trúc câu lệnh.
        // Vì vậy, việc phân tích (Parse) và lập kế hoạch thực thi (Execution Plan) 1.000 lần cho cùng một cấu trúc câu lệnh có thể gây ra một lợi ích tài nguyên lớn đối với cơ sở dữ liệu.
        // Để tối ưu hóa quá trình này, có thể sử dụng các thuật toán như caching để lưu trữ các thông tin cấu trúc câu lệnh trong bộ nhớ cache và tìm kiếm nhanh chóng các thông tin này.
        // Điều này giúp giảm thiểu sự lãng phí tài nguyên của cơ sở dữ liệu và cải thiện hiệu suất của các câu lệnh truy vấn.
        String sql = "select * from doctors where doctor_id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 1; i <= 1000; i++) {
                statement.setInt(1, i);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    System.out.println(resultSet.getString("full_name"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Không dùng prepare statement thời gian tăng tuyến tinh do mỗi lần chạy phải tiến hành tạo mới câu lệnh SQL, ..
        // Dùng prepare statement thì chỉ cận tạo 1 cậu lênh SQL duy nhất Database sẽ thay tham số từ đó thòi gian sẽ tăng nhanh hơn
    }
}
