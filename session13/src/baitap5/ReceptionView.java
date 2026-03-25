package baitap5;

import java.util.Scanner;

public class ReceptionView {
    public static void addPatient(Scanner sc, PatientController patientController) {
        String name = "";
        int age = 0;
        int bedId = 0;
        double amount = 0.0;
        // Nhập tên

        while (true) {
            System.out.print("Nhập tên: ");
            name = sc.nextLine();
            if (name.isBlank()) {
                System.out.println("Không được để trống");
            } else {
                break;
            }
        }

        // Nhập tuổi
        while (true) {
            System.out.print("Nhập tuổi: ");
            try {
                age = Integer.parseInt(sc.nextLine());
                if (age <= 0) {
                    System.out.println("Tuổi phải lớn hơn 0");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập không hợp lệ");
            }
        }

        // Nhập mã giường
        while (true) {
            System.out.print("Nhập mã giường: ");
            try {
                bedId = Integer.parseInt(sc.nextLine());
                if (bedId <= 0) {
                    System.out.println("Nhập không hợp lệ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập không hợp lệ");
            }
        }

        // Nhập số tiến
        while (true) {
            System.out.print("Nhập số tiền: ");
            try {
                amount = Double.parseDouble(sc.nextLine());
                if (amount <= 0) {
                    System.out.println("Nhập không hợp lệ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập không hợp lệ");
            }
        }

        patientController.addPatient(name, age, bedId, amount);
    }

    public static void main(String[] args) {
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        PatientController patientController = new PatientController();

        do {
            System.out.println("1. Xem danh sách giường bệnh trống");
            System.out.println("2. Tiếp nhận bệnh nhân");
            System.out.println("3. Thoát");
            System.out.print("Nhập chức năng: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Nhập không hợp lệ");
            }
            switch (choice) {
                case 1:
                    patientController.displayAllBedAvailable();
                    break;
                case 2:
                    addPatient(sc, patientController);
                    break;
            }
        } while (choice != 3);
        sc.close();
    }
}
