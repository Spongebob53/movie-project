package model.company;

public class HistoryVO {
    private String history_customer;
    private int history_movie;
    private String history_date;
    private String history_theater;

    public HistoryVO() {
    }

    public HistoryVO(String history_customer, int history_movie, String history_date, String history_theater) {
        this.history_customer = history_customer;
        this.history_movie = history_movie;
        this.history_date = history_date;
        this.history_theater = history_theater;
    }

    public String getHistory_customer() {
        return history_customer;
    }

    public void setHistory_customer(String history_customer) {
        this.history_customer = history_customer;
    }

    public int getHistory_movie() {
        return history_movie;
    }

    public void setHistory_movie(int history_movie) {
        this.history_movie = history_movie;
    }

    public String getHistory_date() {
        return history_date;
    }

    public void setHistory_date(String history_date) {
        this.history_date = history_date;
    }

    public String getHistory_theater() {
        return history_theater;
    }

    public void setHistory_theater(String history_theater) {
        this.history_theater = history_theater;
    }
}
