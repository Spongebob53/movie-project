package model.company;

public class RoomVO {
    private String room_id;
    private String room_name;
    private int room_seat;

    public RoomVO() {
    }

    public RoomVO(String room_id, String room_name, int room_seat) {
        this.room_id = room_id;
        this.room_name = room_name;
        this.room_seat = room_seat;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public int getRoom_seat() {
        return room_seat;
    }

    public void setRoom_seat(int room_seat) {
        this.room_seat = room_seat;
    }
}
