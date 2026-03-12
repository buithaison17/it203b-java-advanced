package utils;

import java.util.Scanner;

public class Input {
    private static final Scanner sc = new Scanner(System.in);

    public static String inputString(String title) {
        while (true) {
            System.out.print(title);
            String str = sc.nextLine();
            if (str.isBlank()) {
                System.out.println("Không được để trống");
            } else {
                return str;
            }
        }
    }

    public static int inputIntegerPositive(String title) {
        while (true) {
            System.out.print(title);
            try {
                int num = Integer.parseInt(sc.nextLine());
                if (num < 0) {
                    System.out.println("Nhập số lớn hơn 0");
                } else {
                    return num;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập không đúng định dạng");
            }
        }
    }

    public static double inputDoubleInteger(String title) {
        while (true) {
            System.out.print(title);
            try {
                double num = Double.parseDouble(sc.nextLine());
                if (num < 0) {
                    System.out.println("Nhập số lớn hơn 0");
                } else {
                    return num;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập không đúng định dạng");
            }
        }
    }

}
