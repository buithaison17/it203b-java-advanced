package kha1;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TicketPoolKha1 {
    private String roomName;
    private List<TicketKha1> tickets = new ArrayList<>();

    public TicketPoolKha1(String roomName) {
        this.roomName = roomName;

        for (int i = 0; i < 10; i++) {
            UUID uuid = UUID.randomUUID();
            TicketKha1 ticket = new TicketKha1(uuid.toString(), uuid.toString(), false);
            tickets.add(ticket);
        }
    }

    public synchronized TicketKha1 sellTicket() {
        for (TicketKha1 ticketKha1 : tickets) {
            if (!ticketKha1.isSold()) {
                ticketKha1.setSold(true);
                return ticketKha1;
            }
        }
        return null;
    }

    public int remainingTickets() {
        int count = 0;
        for (TicketKha1 ticket : tickets) {
            if (!ticket.isSold()) count++;
        }
        return count;
    }
}
