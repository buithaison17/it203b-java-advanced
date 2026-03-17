package kha1;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static DeviceFactory factory = null;
    static Device device = null;

    public static void createDevice() {
        int choice;

        do {
            System.out.println("1.Den");
            System.out.println("2. Quat");
            System.out.println("3. Dieu hoa");
            System.out.println("4. Thoat");
            System.out.print("Chon chuc nang: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    factory = new LightFactory();
                    break;
                case 2:
                    factory = new FanFactory();
                    break;
                case 3:
                    factory = new AirConditionerFactory();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Chuc nang khong hop le");
                    break;
            }
            if (factory != null) {
                device = factory.createDevice();
                break;
            }
        } while (choice != 4);
    }

    public static void main(String[] args) {
        HardwareConnection hardwareConnection = HardwareConnection.getInstance();

        int choice;
        do {
            System.out.println("1. Ket noi");
            System.out.println("2. Tao thiet bi");
            System.out.println("3. Bat thiet bi");
            System.out.println("4. Tat thiet bi");
            System.out.println("5. Thoat");
            System.out.print("Chon chuc nang: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    hardwareConnection.connection();
                    break;
                case 2:
                    createDevice();
                    break;
                case 3:
                    device.turnOn();
                    break;
                case 4:
                    device.turnOff();
                    break;
                default:
                    System.out.println("Chuc nang khong hop le");
                    break;
            }
        } while (choice != 5);
    }
}
