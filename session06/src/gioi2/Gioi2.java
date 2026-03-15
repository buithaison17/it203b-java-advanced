package gioi2;

public class Gioi2 {
    public static void main(String[] args) {
        TicketPoolGioi2 roomA = new TicketPoolGioi2("Phòng A");
        TicketPoolGioi2 roomB = new TicketPoolGioi2("Phòng B");
        BookingCounterGioi2 counter1 = new BookingCounterGioi2("Quầy 1", roomA, roomB);
        BookingCounterGioi2 counter2 = new BookingCounterGioi2("Quầy 2", roomB, roomA);

        Thread thread1 = new Thread(counter1);
        Thread thread2 = new Thread(counter2);
        thread1.start();
        thread2.start();
    }
}
