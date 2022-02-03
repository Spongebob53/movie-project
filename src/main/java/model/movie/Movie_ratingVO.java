package model.movie;

public class Movie_ratingVO {
    private int movie_id;
    private int movie_cumulative;
    private float movie_grade;

    public Movie_ratingVO() {
    }

    public Movie_ratingVO(int movie_id, int movie_cumulative, float movie_grade) {
        this.movie_id = movie_id;
        this.movie_cumulative = movie_cumulative;
        this.movie_grade = movie_grade;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getMovie_cumulative() {
        return movie_cumulative;
    }

    public void setMovie_cumulative(int movie_cumulative) {
        this.movie_cumulative = movie_cumulative;
    }

    public float getMovie_grade() {
        return movie_grade;
    }

    public void setMovie_grade(float movie_grade) {
        this.movie_grade = movie_grade;
    }
}
