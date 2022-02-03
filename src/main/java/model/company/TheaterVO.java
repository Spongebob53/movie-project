package model.company;

public class TheaterVO {
    private String theater_id;
    private String theater_name;

    public TheaterVO() {
    }

    public TheaterVO(String theater_id, String theater_name) {
        this.theater_id = theater_id;
        this.theater_name = theater_name;
    }

    public String getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(String theater_id) {
        this.theater_id = theater_id;
    }

    public String getTheater_name() {
        return theater_name;
    }

    public void setTheater_name(String theater_name) {
        this.theater_name = theater_name;
    }
}
