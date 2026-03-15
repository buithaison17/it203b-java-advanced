package xuatsac1;

public class TimeoutManager implements Runnable {
    TicketPool ticketPool;

    public TimeoutManager(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        while (true) {
            ticketPool.releaseExpiredTickets();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
