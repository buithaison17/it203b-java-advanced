package xuatsac1;

import java.util.Random;

public class Ticket {
    private String id;
    private boolean isVip;
    private boolean isHeld = false;
    private long holdExpiryTime = 0;

    public Ticket(String id) {
        this.id = id;
        Random random = new Random();
        isVip = random.nextBoolean();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isHeld() {
        return isHeld;
    }

    public void setHeld(boolean held) {
        isHeld = held;
    }

    public long getHoldExpiryTime() {
        return holdExpiryTime;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public void setHoldExpiryTime(long holdExpiryTime) {
        this.holdExpiryTime = holdExpiryTime;
    }
}
