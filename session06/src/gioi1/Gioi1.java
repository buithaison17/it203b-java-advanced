package gioi1;

public class Gioi1 {
    public static void main(String[] args) {
        TicketPoolGioi1 roomA = new TicketPoolGioi1("Phòng A");
        TicketPoolGioi1 roomB = new TicketPoolGioi1("Phòng B");
        TicketSupplierGioi1 ticketSupplier = new TicketSupplierGioi1(roomA, roomB, 3, 3000, 3);
        BookingCounterGioi1 counter1 = new BookingCounterGioi1("Counter 1", roomA, roomB);
        BookingCounterGioi1 counter2 = new BookingCounterGioi1("Counter 2", roomA, roomB);
        Thread thread1 = new Thread(counter1);
        Thread thread2 = new Thread(counter2);
        Thread thread3 = new Thread(ticketSupplier);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
