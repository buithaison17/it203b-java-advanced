package kha2;

import java.util.Random;

public class BookingCounterKha2 implements Runnable {
    private String counterName;
    private TicketPoolKha2 roomA;
    private TicketPoolKha2 roomB;
    private int soldCount = 0;

    public BookingCounterKha2(String counterName, TicketPoolKha2 roomA, TicketPoolKha2 roomB) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            TicketKha2 ticket = null;
            // 1 trong 2 phòng bán vé
            if (random.nextBoolean()) {
                ticket = roomA.sellTicket();
            } else {
                roomB.sellTicket();
            }
            // Nếu phòng đã chọn hết vé
            if (ticket == null) {
                ticket = roomA.sellTicket();
                if (ticket == null) {
                    ticket = roomB.sellTicket();
                }
            }
            // Nếu cả 2 phòng đều hết vé
            if (ticket == null) {
                break;
            }
            soldCount++;
            System.out.println(counterName + " đã bán vé " + ticket.getRoomName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(counterName + " kết thúc.");
    }

    public String getCounterName() {
        return counterName;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }

    public TicketPoolKha2 getRoomA() {
        return roomA;
    }

    public void setRoomA(TicketPoolKha2 roomA) {
        this.roomA = roomA;
    }

    public TicketPoolKha2 getRoomB() {
        return roomB;
    }

    public void setRoomB(TicketPoolKha2 roomB) {
        this.roomB = roomB;
    }

    public int getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(int soldCount) {
        this.soldCount = soldCount;
    }
}
