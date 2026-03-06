import java.io.IOException;

public class Gioi4 {
    public static void saveToFile() throws IOException {
        System.out.println("Dang luu du lieu");
        throw new IOException("Error save to file");
    }

    public static void processUserData() throws IOException {
        System.out.println("Dang tai du lieu");
        saveToFile();
    }

    public static void main(String[] args) {
        try {
            processUserData();
        } catch (IOException e) {
            System.out.println("[ERROR] 2026-03-06");
        }
    }
}
