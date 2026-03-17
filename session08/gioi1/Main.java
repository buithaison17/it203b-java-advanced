package gioi1;

import java.util.Scanner;

import kha1.AirConditioner;
import kha1.Fan;
import kha1.Light;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Fan fan = new Fan();
    private static Light light = new Light();
    private static AirConditioner airConditioner = new AirConditioner();
    private static RemoteControl remoteControl = new RemoteControl();

    public static void assignButton() {
        System.out.print("Chon slot: ");
        int slot = sc.nextInt();
        int choice;

        do {
            System.out.println("1. Bat den");
            System.out.println("2. Tat den");
            System.out.println("3. Bat quat");
            System.out.println("4. Tat quat");
            System.out.println("5. Set dieu hoa");
            System.out.println("6. Thoat");
            System.out.print("Chon: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    remoteControl.setButton(slot, new LightOnCommand(light));
                    return;
                case 2:
                    remoteControl.setButton(slot, new LightOffCommand(light));
                    return;
                case 3:
                    remoteControl.setButton(slot, new FanOnCommand(fan));
                    return;
                case 4:
                    remoteControl.setButton(slot, new FanOffCommand(fan));
                    return;
                case 5:
                    System.out.print("Nhap nhiet do: ");
                    int temp = sc.nextInt();
                    remoteControl.setButton(slot, new ACSetTemperatureCommand(temp, airConditioner));
                    return;
                default:
                    System.out.println("Chuc nang khong hop le");
                    break;
            }
        } while (choice != 6);
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1. Gan nut");
            System.out.println("2. Nhan nut");
            System.out.println("3. Undo");
            System.out.println("4. Thoat");
            System.out.print("Chon: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    assignButton();
                    break;
                case 2:
                    System.out.print("Nhan nut: ");
                    int index = sc.nextInt();
                    remoteControl.press(index);
                    break;
                case 3:
                    remoteControl.undo();
                    break;
                default:
                    System.out.println("Chuc nang khong hop le");
                    break;
            }
        } while (choice != 4);
    }
}
