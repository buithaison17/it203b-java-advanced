package xuatsac2;

import java.util.ArrayList;
import java.util.List;

public class RoomXuatSac2 {

    private String name;
    private List<TicketXuatSac2> tickets = new ArrayList<>();

    public RoomXuatSac2(String name, int ticketCount) {
        this.name = name;

        for (int i = 1; i <= ticketCount; i++) {
            tickets.add(new TicketXuatSac2(name + "-" + i));
        }
    }

    public synchronized TicketXuatSac2 sellTicket() {

        for (TicketXuatSac2 t : tickets) {
            if (!t.isSold()) {
                t.setSold(true);
                return t;
            }
        }

        return null;
    }

    public int getSoldCount() {
        int count = 0;

        for (TicketXuatSac2 t : tickets) {
            if (t.isSold()) count++;
        }

        return count;
    }

    public int getTotalTickets() {
        return tickets.size();
    }

    public String getName() {
        return name;
    }
}