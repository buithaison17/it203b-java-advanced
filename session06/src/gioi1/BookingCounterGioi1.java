package gioi1;

import java.util.Random;

public class BookingCounterGioi1 implements Runnable {
    private String counterName;
    private TicketPoolGioi1 roomA;
    private TicketPoolGioi1 roomB;
    private int soldCount = 0;

    public BookingCounterGioi1(String counterName, TicketPoolGioi1 roomA, TicketPoolGioi1 roomB) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            TicketGioi1 ticket = null;
            if (random.nextBoolean()) {
                ticket = roomA.sellTicket();
            } else {
                ticket = roomB.sellTicket();
            }
            soldCount++;
            System.out.println(counterName + " bán vé " + ticket.getId());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getCounterName() {
        return counterName;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }

    public TicketPoolGioi1 getRoomA() {
        return roomA;
    }

    public void setRoomA(TicketPoolGioi1 roomA) {
        this.roomA = roomA;
    }

    public TicketPoolGioi1 getRoomB() {
        return roomB;
    }

    public void setRoomB(TicketPoolGioi1 roomB) {
        this.roomB = roomB;
    }

    public int getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(int soldCount) {
        this.soldCount = soldCount;
    }
}
