package model.customer;

public class CustomerAdVO {
    private String customer_id;
    private int ad_email;
    private int ad_sns;
    private int ad_tel;

    public CustomerAdVO() {
    }

    public CustomerAdVO(String customer_id, int ad_email, int ad_sns, int ad_tel) {
        this.customer_id = customer_id;
        this.ad_email = ad_email;
        this.ad_sns = ad_sns;
        this.ad_tel = ad_tel;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public int getAd_email() {
        return ad_email;
    }

    public void setAd_email(int ad_email) {
        this.ad_email = ad_email;
    }

    public int getAd_sns() {
        return ad_sns;
    }

    public void setAd_sns(int ad_sns) {
        this.ad_sns = ad_sns;
    }

    public int getAd_tel() {
        return ad_tel;
    }

    public void setAd_tel(int ad_tel) {
        this.ad_tel = ad_tel;
    }
}
