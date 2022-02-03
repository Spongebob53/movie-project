package model.company;

public class BookVO {
    private String book_id;
    private String customer_id;

    public BookVO() {
    }

    public BookVO(String book_id, String customer_id) {
        this.book_id = book_id;
        this.customer_id = customer_id;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }
}
