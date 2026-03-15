package kha2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TicketPoolKha2 {
    private String roomName;
    private List<TicketKha2> tickets = new ArrayList<>();

    public TicketPoolKha2(String roomName) {
        this.roomName = roomName;

        for (int i = 0; i < 10; i++) {
            UUID uuid = UUID.randomUUID();
            TicketKha2 ticket = new TicketKha2(uuid.toString(), uuid.toString(), false);
            tickets.add(ticket);
        }
    }

    public synchronized TicketKha2 sellTicket() {
        for (TicketKha2 ticketKha1 : tickets) {
            if (!ticketKha1.isSold()) {
                ticketKha1.setSold(true);
                return ticketKha1;
            }
        }
        return null;
    }

    public synchronized void addTicket(int count) {
        for (int i = 0; i < count; i++) {
            UUID uuid = UUID.randomUUID();
            TicketKha2 ticket = new TicketKha2(uuid.toString(), uuid.toString(), false);
            tickets.add(ticket);
        }
    }

    public int remainingTickets() {
        int count = 0;
        for (TicketKha2 ticket : tickets) {
            if (!ticket.isSold()) count++;
        }
        return count;
    }
}
