import java.util.Scanner;

public class Kha1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhap nam sinh: ");
            int year = Integer.parseInt(sc.nextLine());
            System.out.println(year);
        } catch (NumberFormatException ex) {
            System.out.println("Da xay ra loi");
        } finally {
            sc.close();
            System.out.println("[ERROR] 2026-03-06");
        }
    }
}
