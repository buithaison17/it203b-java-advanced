package xuatsac1;

public class XuatSac1 {

    public static void main(String[] args) {

        TicketPool poolA = new TicketPool("A");

        Thread timeout = new Thread(new TimeoutManager(poolA));
        timeout.start();

        Thread q1 = new Thread(new BookingCounter("Quầy 1", poolA));
        Thread q2 = new Thread(new BookingCounter("Quầy 2", poolA));
        Thread q3 = new Thread(new BookingCounter("Quầy 3", poolA));
        Thread q4 = new Thread(new BookingCounter("Quầy 4", poolA));
        Thread q5 = new Thread(new BookingCounter("Quầy 5", poolA));

        q1.start();
        q2.start();
        q3.start();
        q4.start();
        q5.start();
    }
}