package kha1;

public class HardwareConnection {
    private static HardwareConnection hardwareConnection;

    private HardwareConnection() {
    }

    public static HardwareConnection getInstance() {
        if (hardwareConnection == null) {
            hardwareConnection = new HardwareConnection();
        }
        return hardwareConnection;
    }

    public void connection() {
        System.out.println("Da ket noi voi phan cung");
    }

    public void disconnect() {
        System.out.println("Ngat ket noi voi phan cung");
    }

}
