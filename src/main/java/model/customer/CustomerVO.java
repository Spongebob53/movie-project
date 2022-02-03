package model.customer;

public class CustomerVO {
    private String customer_id;
    private String customer_pw;
    private String customer_salt;

    public CustomerVO() {
    }

    public CustomerVO(String customer_id, String customer_pw, String customer_salt) {
        this.customer_id = customer_id;
        this.customer_pw = customer_pw;
        this.customer_salt = customer_salt;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_pw() {
        return customer_pw;
    }

    public void setCustomer_pw(String customer_pw) {
        this.customer_pw = customer_pw;
    }

    public String getCustomer_salt() {
        return customer_salt;
    }

    public void setCustomer_salt(String customer_salt) {
        this.customer_salt = customer_salt;
    }
}
