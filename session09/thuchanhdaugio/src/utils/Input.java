package utils;

import java.util.Scanner;

public class Input {
    private static Scanner sc = new Scanner(System.in);

    public static String InputString(String title) {
        while (true) {
            System.out.print(title);
            String str = sc.nextLine();
            if (str.isBlank()) {
                System.out.println("Không được để trống");
            } else if (str.length() < 6) {
                System.out.println("Phải có ít nhất 6 ký tụ");
            } else {
                return str;
            }
        }
    }

    public static double InputDoublePositive(String title) {
        while (true) {
            System.out.print(title);
            try {
                double num = Double.parseDouble(sc.nextLine());
                if (num < 0) {
                    System.out.println("Hãy nhập số lớn hơn không");
                } else {
                    return num;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập không hợp lệ. Hãy nhập lại");
            }

        }
    }

    public static int InputIntegerPositive(String title) {
        while (true) {
            System.out.print(title);
            try {
                int num = Integer.parseInt(sc.nextLine());
                if (num < 0) {
                    System.out.println("Hãy nhập số lớn hơn không");
                } else {
                    return num;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập không hợp lệ. Hãy nhập lại");
            }

        }
    }
}
