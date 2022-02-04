package model.company;

public class Movie_showVO {
    private String movie_show_id;
    private String movie_id;
    private String room_id;
    private String show_start;

    public Movie_showVO() {
    }

    public Movie_showVO(String movie_show_id, String movie_id, String room_id, String show_start) {
        this.movie_show_id = movie_show_id;
        this.movie_id = movie_id;
        this.room_id = room_id;
        this.show_start = show_start;
    }

    public String getMovie_show_id() {
        return movie_show_id;
    }

    public void setMovie_show_id(String movie_show_id) {
        this.movie_show_id = movie_show_id;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getShow_start() {
        return show_start;
    }

    public void setShow_start(String show_start) {
        this.show_start = show_start;
    }
}
