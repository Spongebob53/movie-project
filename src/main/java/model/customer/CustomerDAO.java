package model.customer;

import service.ConnectDB;
import service.JoinCustomer;

import java.sql.*;

public class CustomerDAO extends ConnectDB {
    private static CustomerDAO instance;
//    private static final String url = "jdbc:oracle:thin:@db202201202020_high?TNS_ADMIN=/Users/spongebob53/Oracle/instantclient/network/Wallet_DB202201202020";
    private static final String url = "jdbc:oracle:thin:@db202201202020_high?TNS_ADMIN=/Users/iyxuna/Downloads/Wallet_DB202201202020";
    private static final String id = "admin";
    private static final String pw = "1q2w3e4r5t^Y";

    public static CustomerDAO getInstance() throws Exception {
        if (instance == null) {
            instance = new CustomerDAO();
        }
        return instance;
    }

    private CustomerDAO() throws Exception {
        super();
    }

    // 회원가입 메소드
    public int insertC(CustomerVO customer) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        JoinCustomer join = new JoinCustomer();
        int rs = 0;
        try {
            conn = DriverManager.getConnection(url, id, pw);

            String sql = "INSERT INTO customer(customer_id, customer_pw, customer_salt) VALUES(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, customer.getCustomer_id());
            ps.setString(2, join.getSalt_pw(customer.getCustomer_pw(), join.getSalt()));
            ps.setString(3, join.getSalt());
            rs = ps.executeUpdate();
            return rs;
        } catch (Exception e) {
            throw new Exception("계정 정보 저장 오류 : " + e.toString());
        } finally {
            if(ps != null){try{ps.close();}catch(Exception e){}}
            if(conn != null){try{conn.close();}catch(Exception e){}}
        }
    }

    public void insertCInfo(CustomerInfoVO info) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection(url, id, pw);

            String sql2 = "INSERT INTO customer_info(customer_id, customer_name, customer_tel, customer_email) VALUES(?,?,?,?)";
            ps = conn.prepareStatement(sql2);
            ps.setString(1, info.getCustomer_id());
            ps.setString(2, info.getCustomer_name());
            ps.setString(3, info.getCustomer_tel());
            ps.setString(4, info.getCustomer_email());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("개인 정보 저장 오류 : " + e.toString());
        } finally {
            if(ps != null){try{ps.close();}catch(Exception e){}}
            if(conn != null){try{conn.close();}catch(Exception e){}}
        }
    }


    public void insertCTerm(CustomerTermVO term) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection(url, id, pw);

            String sql3 = "INSERT INTO customer_term(customer_id, term_1, term_2, term_3) VALUES(?,?,?,?)";
            ps = conn.prepareStatement(sql3);
            ps.setString(1, term.getCustomer_id());
            ps.setString(2, term.getTerm_1());
            ps.setString(3, term.getTerm_2());
            ps.setString(4, term.getTerm_3());
            ps.executeQuery();
        } catch (Exception e) {
            throw new Exception("약관 체크 저장 오류 : " + e.toString());
        } finally {
            if(ps != null){try{ps.close();}catch(Exception e){}}
            if(conn != null){try{conn.close();}catch(Exception e){}}
        }
    }

    // 로그인 확인 결과 반환 메소드
    public boolean login(CustomerVO customer) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;
        JoinCustomer join = new JoinCustomer();
        try {
            conn = DriverManager.getConnection(url, id, pw);
            String sql = "SELECT * FROM customer WHERE customer_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, customer.getCustomer_id());
            rs = ps.executeQuery();
            while (rs.next()) {
                String inputPw = join.getSalt_pw(customer.getCustomer_pw(), rs.getString("customer_salt"));
                if (rs.getString("customer_pw").equals(inputPw)) {
                    result = true;
                }
            }
            if(rs != null){try{rs.close();}catch(Exception e){}}
            if(ps != null){try{ps.close();}catch(Exception e){}}
            if(conn != null){try{conn.close();}catch(Exception e){}}
            return result;
        } catch (Exception e) {
            throw new Exception("로그인 오류 : " + e.toString());
        }
    }

    // 계정 중복 체크
    public boolean checkID(CustomerVO customer) throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;

        conn = DriverManager.getConnection(url,id,pw);
        String sql = "SELECT customer_id FROM customer WHERE customer_id = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1,customer.getCustomer_id());
        if(ps.executeUpdate()==0){
            return false;
        }
        return true;
    }
}