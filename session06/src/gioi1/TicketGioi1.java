package gioi1;

public class TicketGioi1 {
    private String id;
    private String roomName;
    private boolean isSold;

    public TicketGioi1(String id, String roomName, boolean isSold) {
        this.id = id;
        this.roomName = roomName;
        this.isSold = isSold;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }
}
