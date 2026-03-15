package gioi2;

public class TicketSupplierGioi2 implements Runnable {
    TicketPoolGioi2 roomA;
    TicketPoolGioi2 roomB;
    int supplyCount;
    int interval;
    int rounds;

    public TicketSupplierGioi2(TicketPoolGioi2 roomA, TicketPoolGioi2 roomB, int supplyCount, int interval, int rounds) {
        this.roomA = roomA;
        this.roomB = roomB;
        this.supplyCount = supplyCount;
        this.interval = interval;
        this.rounds = rounds;
    }

    @Override
    public void run() {
        for (int i = 0; i < rounds; i++) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            roomA.addTicket(supplyCount);
            System.out.println("Nhà cung cấp đã thêm " + supplyCount + " vé vào phòng A");
            roomB.addTicket(supplyCount);
            System.out.println("Nhà cung cấp đã thêm " + supplyCount + " vé vào phòng B");
        }
    }
}
