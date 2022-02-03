import service.ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static java.lang.Math.round;

public class inputTheater extends ConnectDB {
    private static inputTheater instance;

    private static final String url = "jdbc:oracle:thin:@db202201202020_high?TNS_ADMIN=/Users/spongebob53/Oracle/instantclient/network/Wallet_DB202201202020";
    private static final String id = "admin";
    private static final String pw = "1q2w3e4r5t^Y";

    public static inputTheater getInstance() throws Exception {
        if (instance == null) {
            instance = new inputTheater();
        }
        return instance;
    }

    private inputTheater() throws Exception {
        super();
    }

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, id, pw);
            String sql = "SELECT theater_id FROM theater";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int r = (int) (Math.round(Math.random() * 2) + 4);
                String theater_id = rs.getString("theater_id");
                for (int i = 1; i < r; i++) {
                    int rd = (int) (Math.round(Math.random() * 40) + 120);
                    String sql1 = "INSERT INTO room(room_id, room_name, room_seat) VALUES(?, ?, ?)";
                    ps = conn.prepareStatement(sql1);
                    ps.setString(1, (theater_id + i) + 2);
                    ps.setString(2, i + "관");
                    ps.setInt(3, rd);
                    ps.executeQuery();
                }
            }
        } catch (Exception e) {
            throw new Exception("영화 정보 오류 : " + e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception ex) {
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception ex) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception ex) {
                }
            }
        }
    }
}
