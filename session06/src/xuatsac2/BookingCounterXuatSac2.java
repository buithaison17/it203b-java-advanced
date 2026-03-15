package xuatsac2;

import java.util.List;
import java.util.Random;

public class BookingCounterXuatSac2 implements Runnable {

    private String name;
    private List<RoomXuatSac2> rooms;
    private boolean running = true;

    public BookingCounterXuatSac2(String name, List<RoomXuatSac2> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {

        Random random = new Random();

        while (running) {

            RoomXuatSac2 room = rooms.get(random.nextInt(rooms.size()));

            TicketXuatSac2 ticket = room.sellTicket();

            if (ticket != null) {
                System.out.println(name + " bán vé " + ticket.getId());
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}