package kha2;

public class Kha2 {
    public static void main(String[] args) {
        TicketPoolKha2 roomA = new TicketPoolKha2("Phòng A");
        TicketPoolKha2 roomB = new TicketPoolKha2("Phòng B");
        TicketSupplier ticketSupplier = new TicketSupplier(roomA, roomB, 3, 3000, 3);
        BookingCounterKha2 counter1 = new BookingCounterKha2("Counter 1", roomA, roomB);
        BookingCounterKha2 counter2 = new BookingCounterKha2("Counter 2", roomA, roomB);
        Thread thread1 = new Thread(counter1);
        Thread thread2 = new Thread(counter2);
        Thread thread3 = new Thread(ticketSupplier);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
