package gioi2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TicketPoolGioi2 {
    private String roomName;
    private List<TicketGioi2> tickets = new ArrayList<>();

    public TicketPoolGioi2(String roomName) {
        this.roomName = roomName;

        for (int i = 0; i < 10; i++) {
            UUID uuid = UUID.randomUUID();
            TicketGioi2 ticket = new TicketGioi2(uuid.toString(), uuid.toString(), false);
            tickets.add(ticket);
        }
    }

    public synchronized TicketGioi2 sellTicket() {
        while (remainingTickets() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (TicketGioi2 t : tickets) {
            if (!t.isSold()) {
                t.setSold(true);
                return t;
            }
        }
        return null;
    }

    public synchronized void addTicket(int count) {
        for (int i = 0; i < count; i++) {
            UUID uuid = UUID.randomUUID();
            TicketGioi2 ticket = new TicketGioi2(uuid.toString(), uuid.toString(), false);
            tickets.add(ticket);
        }
        notifyAll();
    }

    public int remainingTickets() {
        int count = 0;
        for (TicketGioi2 ticket : tickets) {
            if (!ticket.isSold()) count++;
        }
        return count;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public List<TicketGioi2> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketGioi2> tickets) {
        this.tickets = tickets;
    }
}
