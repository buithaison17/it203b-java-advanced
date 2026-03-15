package kha1;

public class Kha1 {
    public static void main(String[] args) {
        TicketPoolKha1 roomA = new TicketPoolKha1("roomA");
        TicketPoolKha1 roomB = new TicketPoolKha1("roomB");
        BookingCounterKha1 counter1 = new BookingCounterKha1("counter1", roomA, roomB);
        BookingCounterKha1 counter2 = new BookingCounterKha1("counter2", roomA, roomB);
        Thread thread1 = new Thread(counter1);
        Thread thread2 = new Thread(counter2);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Kết thúc chương trình");
        System.out.println("Quầy 1 bán được " + counter1.getSoldCount() + " vé");
        System.out.println("Quầy 2 bán được " + counter2.getSoldCount() + " vé");
        System.out.println("Vé còn lại Phòng A " + roomA.remainingTickets() + " vé");
        System.out.println("Vé còn lại Phòng B " + roomB.remainingTickets() + " vé");
    }
}
