import java.util.InputMismatchException;
import java.util.Scanner;

public class Kha2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Nhap so nguoi: ");
            int num1 = sc.nextInt();
            System.out.print("Nhap so nhom: ");
            int num2 = sc.nextInt();
            if (num2 > num1) {
                throw new IllegalArgumentException("So nhom khong duoc lon hon so nguoi");
            }
            try {
                System.out.println((double) num1 / num2);
            } catch (ArithmeticException e) {
                System.out.println("Khong the chi cho 0");
            }
        } catch (InputMismatchException ex) {
            System.out.println("[ERROR] 2026-03-06");
        }
    }
}
