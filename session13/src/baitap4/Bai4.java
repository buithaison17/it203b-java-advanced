package baitap4;

import connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bai4 {
    // Dữ liệu đầu vào: cần có danh sách bệnh nhân, và danh sách dịch vụ bệnh nhân sử dụng trong databse
    // Giải dùng: dùng join hoặc sub querry
    // Ưu điểm và nhược điểm của join: ngắn gón dễ viết nhưng có thể 1 bệnh nhân có nhiều dòng
    // Ưu và nhược điểm của sub querry: code dễ hiểu không bị nhân dòng nhưng code dài dòng
    public static Map<Integer, BenhNhanDTO> getData() {
        Map<Integer, BenhNhanDTO> map = new HashMap<>();
        String sql = """
                select p.patient_id, p.name, p.gender, s.service_id, s.service_name from patients p             
                left join services s on s.patient_id = p.patient_id
                """;
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("patient_id");
                BenhNhanDTO benhNhanDTO = map.get(id);
                // Tạo mới và thêm vào map nếu chưa có nếu chưa có
                if (benhNhanDTO == null) {
                    String name = resultSet.getString("name");
                    String gender = resultSet.getString("gender");
                    benhNhanDTO = new BenhNhanDTO(id, name, gender, new ArrayList<>());
                    map.put(id, benhNhanDTO);
                }
                // Lấy ds bệnh nhân sử dụng
                int serviceId = resultSet.getInt("service_id");
                // Nếu serviceId vừa lấy ra là không null thêm vào dv bệnh nhân
                if (!resultSet.wasNull()) {
                    String serviceName = resultSet.getString("service_name");
                    DichVu dichVu = new DichVu(serviceId, id, serviceName);
                    benhNhanDTO.getDsDichVu().add(dichVu);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) {
        Map<Integer, BenhNhanDTO> map = getData();
        for (Map.Entry<Integer, BenhNhanDTO> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
