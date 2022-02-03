package model.customer;

public class CustomerInfoVO {
    private String customer_id;
    private String customer_name;
    private String customer_tel;
    private String customer_birth;
    private String customer_email;
    private int customer_point;

    public CustomerInfoVO() {
    }

    public CustomerInfoVO(String customer_id, String customer_name, String customer_tel, String customer_birth, String customer_email, int customer_point) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_tel = customer_tel;
        this.customer_birth = customer_birth;
        this.customer_email = customer_email;
        this.customer_point = customer_point;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_tel() {
        return customer_tel;
    }

    public void setCustomer_tel(String customer_tel) {
        this.customer_tel = customer_tel;
    }

    public String getCustomer_birth() {
        return customer_birth;
    }

    public void setCustomer_birth(String customer_birth) {
        this.customer_birth = customer_birth;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public int getCustomer_point() {
        return customer_point;
    }

    public void setCustomer_point(int customer_point) {
        this.customer_point = customer_point;
    }
}
