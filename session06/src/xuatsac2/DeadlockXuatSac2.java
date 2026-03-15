package xuatsac2;

import java.lang.management.*;

public class DeadlockXuatSac2 {
    public static void detectDeadlock() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        long[] ids = bean.findDeadlockedThreads();
        System.out.println("Đang quét deadlock...");
        if (ids == null) {
            System.out.println("Không phát hiện deadlock.");
        } else {
            System.out.println("Phát hiện deadlock!");
        }
    }
}