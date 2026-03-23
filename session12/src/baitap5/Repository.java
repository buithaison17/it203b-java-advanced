package baitap5;

import connections.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    public boolean addPatient(String fullName, String departmentTreat, int days) {
        String sql = "insert into patients(fullName, departmentTreat, days) values (?,?,?)";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, departmentTreat);
            preparedStatement.setInt(3, days);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updatePatient(int id, String fullName, String departmentTreat, int days) {
        String sql = "update patients set fullName = ?, departmentTreat = ?, days = ? where id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, departmentTreat);
            preparedStatement.setInt(3, days);
            preparedStatement.setInt(4, id);
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public double dischargedHospital(int id) {
        String sql = "call CALCULATE_DISCHARGE_FEE(?,?)";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             CallableStatement callableStatement = connection.prepareCall(sql)) {
            callableStatement.setInt(1, id);
            callableStatement.registerOutParameter(2, Types.DOUBLE);
            callableStatement.execute();
            return callableStatement.getDouble(2);
        } catch (SQLException e) {
            System.out.println("Đã xảy ra lỗi");
            return -1;
        }
    }

    public List<Patient> findAll() {
        List<Patient> list = new ArrayList<>();

        String sql = "select id, fullName, departmentTreat, days from patients;";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("fullName");
                String departmentTreat = resultSet.getString("departmentTreat");
                int days = resultSet.getInt("days");
                Patient patient = new Patient(id, fullName, departmentTreat, days);
                list.add(patient);
            }
        } catch (SQLException e) {
            System.out.println("Đã xảy ra lỗi");
        }
        return list;
    }
}
