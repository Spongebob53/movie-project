package model.movie;

public class MovieVO {
    private String movie_id;
    private String movie_title;
    private int movie_time;
    private int movie_age;
    private String movie_gerne;

    public MovieVO() {
    }

    public MovieVO(String movie_id, String movie_title, int movie_time, int movie_age, String movie_gerne) {
        this.movie_id = movie_id;
        this.movie_title = movie_title;
        this.movie_time = movie_time;
        this.movie_age = movie_age;
        this.movie_gerne = movie_gerne;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public int getMovie_time() {
        return movie_time;
    }

    public void setMovie_time(int movie_time) {
        this.movie_time = movie_time;
    }

    public int getMovie_age() {
        return movie_age;
    }

    public void setMovie_age(int movie_age) {
        this.movie_age = movie_age;
    }

    public String getMovie_gerne() {
        return movie_gerne;
    }

    public void setMovie_gerne(String movie_gerne) {
        this.movie_gerne = movie_gerne;
    }
}
