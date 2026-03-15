package gioi2;

public class BookingCounterGioi2 implements Runnable {
    private String counterName;
    private TicketPoolGioi2 roomA;
    private TicketPoolGioi2 roomB;
    private int soldCount = 0;

    public BookingCounterGioi2(String counterName, TicketPoolGioi2 roomA, TicketPoolGioi2 roomB) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
    }

    @Override
    public void run() {
        while (roomA.remainingTickets() > 0 || roomB.remainingTickets() > 0) {
            sellCombo();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void sellCombo() {
        TicketPoolGioi2 t1;
        TicketPoolGioi2 t2;
        if (roomA.getRoomName().compareTo(roomB.getRoomName()) < 0) {
            t1 = roomA;
            t2 = roomB;
        } else {
            t1 = roomB;
            t2 = roomA;
        }
        synchronized (t1) {
            synchronized (t2) {
                System.out.println(counterName + " đã khóa " + t1.getRoomName());
                System.out.println(counterName + " đã khóa " + t2.getRoomName());

                TicketGioi2 ticket1 = t1.sellTicket();
                TicketGioi2 ticket2 = t2.sellTicket();
                if (ticket1 != null && ticket2 != null) {
                    ticket1.setSold(true);
                    ticket2.setSold(true);
                    soldCount += 2;
                    System.out.println(counterName + " bán combo "
                            + ticket1.getId() + " và " + ticket2.getId());
                } else {
                    if (ticket1 != null) {
                        ticket1.setSold(false);
                    }
                    if (ticket2 != null) {
                        ticket2.setSold(false);
                    }
                    System.out.println(counterName + " bán combo thất bại");
                }
            }
        }
    }

    public String getCounterName() {
        return counterName;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }

    public TicketPoolGioi2 getRoomA() {
        return roomA;
    }

    public void setRoomA(TicketPoolGioi2 roomA) {
        this.roomA = roomA;
    }

    public TicketPoolGioi2 getRoomB() {
        return roomB;
    }

    public void setRoomB(TicketPoolGioi2 roomB) {
        this.roomB = roomB;
    }

    public int getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(int soldCount) {
        this.soldCount = soldCount;
    }
}
