package baitap5;

import java.util.List;
import java.util.Scanner;

public class Bai5 {
    private static Scanner sc = new Scanner(System.in);
    private static Repository repository = new Repository();

    private static void processAddPatient() {
        System.out.print("Nhập tên: ");
        String fullName = sc.nextLine();
        System.out.print("Nhập khoa điều trị: ");
        String departmentTreat = sc.nextLine();
        System.out.print("Nhập số ngày điều trị: ");
        int days = Integer.parseInt(sc.nextLine());
        boolean result = repository.addPatient(fullName, departmentTreat, days);
        if (result) {
            System.out.println("Thêm thành công");
        } else {
            System.out.println("Thêm thất bại");
        }
    }

    public static void processUpdatePatient() {
        System.out.println("Nhập ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập tên: ");
        String fullName = sc.nextLine();
        System.out.print("Nhập khoa điều trị: ");
        String departmentTreat = sc.nextLine();
        System.out.print("Nhập số ngày điều trị: ");
        int days = Integer.parseInt(sc.nextLine());

        boolean result = repository.updatePatient(id, fullName, departmentTreat, days);
        if (result){
            System.out.println("Cập nhật thành công");
        }else {
            System.out.println("Cập nhật thất bại");
        }
    }

    public static void displayAll() {
        List<Patient> patients = repository.findAll();
        for (Patient patient : patients) {
            System.out.println(patient.toString());
        }
    }

    public static void processDischargedHospital() {
        System.out.print("Nhập ID bệnh nhân: ");
        int id = Integer.parseInt(sc.nextLine());
        double total = repository.dischargedHospital(id);
        if (total != -1) {
            System.out.println("Viện phí: " + total);
        }
    }

    public static void main(String[] args) {
        int choice = -1;
        do {
            System.out.println("1. Danh sách bệnh nhân");
            System.out.println("2. Tiếp nhận bệnh nhân mới");
            System.out.println("3. Cập nhật bệnh án");
            System.out.println("4. Xuất viện và tính phí");
            System.out.println("5. Thoát");
            System.out.print("Chức năng: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Nhập không hợp lệ");
            }
            switch (choice) {
                case 1:
                    displayAll();
                    break;
                case 2:
                    processAddPatient();
                    break;
                case 3:
                    processUpdatePatient();
                    break;
                case 4:
                    processDischargedHospital();
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        } while (choice != 5);
    }
}
