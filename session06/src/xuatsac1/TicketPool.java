package xuatsac1;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {
    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName) {
        this.roomName = roomName;

        for (int i = 1; i <= 5; i++) {
            String name = roomName + "-" +  String.format("%03d", i);
            tickets.add(new Ticket(name));
        }
    }

    public synchronized Ticket holdTicket() {
        for (Ticket ticket : tickets) {
            if (!ticket.isHeld()) {
                ticket.setHeld(true);
                // Kết thúc sau 5s nếu chưa thanh toán
                ticket.setHoldExpiryTime(System.currentTimeMillis() + 5000);
                System.out.println("Đang giữ vé " + ticket.getId());
                return ticket;
            }
        }
        return null;
    }

    public synchronized void sellHeldTicket(Ticket ticket) {
        if (ticket == null) return;
        tickets.remove(ticket);
        System.out.println("Đã bán vé " + ticket.getId());
    }

    public synchronized void releaseExpiredTickets() {
        for (Ticket ticket : tickets) {
            long now = System.currentTimeMillis();
            if (ticket.isHeld() && now > ticket.getHoldExpiryTime()) {
                ticket.setHeld(false);
                ticket.setHoldExpiryTime(0);
                System.out.println("Đã hủy vé " + ticket.getId() + " vì quá bạn");
            }
        }
    }
}