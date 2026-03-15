package xuatsac2;

import java.util.*;
import java.util.concurrent.*;

public class CinemaSystemXuatSac2 {

    private List<RoomXuatSac2> rooms = new ArrayList<>();
    private ExecutorService executor;
    private List<BookingCounterXuatSac2> counters = new ArrayList<>();

    public void startSimulation(int roomCount, int ticketsPerRoom, int counterCount) {

        for (int i = 0; i < roomCount; i++) {
            char name = (char) ('A' + i);
            rooms.add(new RoomXuatSac2(String.valueOf(name), ticketsPerRoom));
        }

        executor = Executors.newFixedThreadPool(counterCount);

        for (int i = 1; i <= counterCount; i++) {
            BookingCounterXuatSac2 counter =
                    new BookingCounterXuatSac2("Quầy " + i, rooms);

            counters.add(counter);
            executor.submit(counter);
        }

        System.out.println("Đã khởi tạo hệ thống với "
                + roomCount + " phòng, "
                + (roomCount * ticketsPerRoom) + " vé, "
                + counterCount + " quầy");
    }

    public void stopSimulation() {

        for (BookingCounterXuatSac2 c : counters) {
            c.stop();
        }

        executor.shutdown();
        System.out.println("Đã tạm dừng tất cả quầy bán vé.");
    }

    public void showStats() {

        int revenue = 0;

        System.out.println("=== THỐNG KÊ ===");

        for (RoomXuatSac2 r : rooms) {

            int sold = r.getSoldCount();
            int total = r.getTotalTickets();

            System.out.println("Phòng " + r.getName()
                    + ": Đã bán " + sold + "/" + total + " vé");

            revenue += sold * 250000;
        }

        System.out.println("Tổng doanh thu: " + revenue + " VNĐ");
    }
}