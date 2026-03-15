package xuatsac1;

public class BookingCounter implements Runnable {
    private String counterName;
    private TicketPool ticketPool;

    public BookingCounter(String counterName, TicketPool ticketPool) {
        this.counterName = counterName;
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        Ticket ticket = ticketPool.holdTicket();
        if (ticket != null) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ticketPool.sellHeldTicket(ticket);
        }
    }

    public String getCounterName() {
        return counterName;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }

    public TicketPool getTicketPool() {
        return ticketPool;
    }

    public void setTicketPool(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }
}
