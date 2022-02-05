package model.movie;

import model.company.TheaterVO;
import service.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieDAO extends ConnectDB {
    private static MovieDAO instance;
//    private static final String url = "jdbc:oracle:thin:@db202201202020_high?TNS_ADMIN=/Users/spongebob53/Oracle/instantclient/network/Wallet_DB202201202020";
    private static final String url = "jdbc:oracle:thin:@db202201202020_high?TNS_ADMIN=/Users/iyxuna/Downloads/Wallet_DB202201202020";
    private static final String id = "admin";
    private static final String pw = "1q2w3e4r5t^Y";

    public static MovieDAO getInstance() throws Exception {
        if (instance == null) {
            instance = new MovieDAO();
        }
        return instance;
    }

    private MovieDAO() throws Exception {
        super();
    }

    // 영화 세부정보 메소드
    public MovieVO movieInfo(MovieVO movie) throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = DriverManager.getConnection(url,id,pw);
            String sql = "SELECT * FROM movie WHERE movie_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,movie.getMovie_id());
            rs = ps.executeQuery();

            while(rs.next()){
                String movie_id = rs.getString("movie_id");
                String movie_title = rs.getString("movie_title");
                int movie_time = rs.getInt("movie_time");
                int movie_age = rs.getInt("movie_age");
                String movie_gerne = rs.getString("movie_gerne");
                movie = new MovieVO(movie_id,movie_title,movie_time,movie_age,movie_gerne);
            }
            return movie;
        }catch(Exception e){
            throw new Exception("영화 정보 오류 : " + e.toString());
        } finally{
            if( rs != null ) { try{ rs.close(); } catch(Exception e){} }
            if( ps != null ) { try{ ps.close(); } catch(Exception e){} }
            if( conn != null ) { try{ conn.close(); } catch(Exception e){} }
        }
    }

    // 영화 목록 메소드
    public List<MovieVO> getMovieList() throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean isEmpty = true;
        List<MovieVO> mList = new ArrayList();

        try{
            conn = DriverManager.getConnection(url,id,pw);
            String sql = "SELECT * FROM movie";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                isEmpty = false;
                String movie_id = rs.getString("movie_id");
                String movie_title = rs.getString("movie_title");
                int movie_time = rs.getInt("movie_time");
                int movie_age = rs.getInt("movie_age");
                String movie_gerne = rs.getString("movie_gerne");

                MovieVO movie = new MovieVO(movie_id, movie_title, movie_time, movie_age, movie_gerne);
                mList.add(movie);
            }
            if(isEmpty){
                return Collections.emptyList();
            }
            return mList;
        }catch(Exception e){
            throw new Exception("영화 리스트 오류 : " + e.toString());
        }finally{
            if( rs != null ) { try{ rs.close(); } catch(Exception e){} }
            if( ps != null ) { try{ ps.close(); } catch(Exception e){} }
            if( conn != null ) { try{ conn.close(); } catch(Exception e){} }
        }
    }

    //예매하기
    public int book(String book_id, String customer_id) throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection(url,id,pw);
            String sql = "INSERT INTO book(book_id, customer_id) VALUES (?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,book_id);
            ps.setString(2,customer_id);
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("예약 저장 오류 : " + e.toString());
        }finally {
            if( ps != null ) { try{ ps.close(); } catch(Exception e){} }
            if( conn != null ) { try{ conn.close(); } catch(Exception e){} }
        }
    }

    // 좌석 수 가져오기
    public int theater_seat(String room_id) throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int seatNum = 0;
        try {
            conn = DriverManager.getConnection(url,id,pw);
            String sql = "SELECT room_seat FROM room WHERE room_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,room_id);
            rs = ps.executeQuery();
            while (rs.next()){
                seatNum = rs.getInt("room_seat");
            }
            return seatNum;
        } catch (SQLException e) {
            throw new Exception("좌석 수 호출 오류 : " + e.toString());
        }finally {
            if( rs != null ) { try{ rs.close(); } catch(Exception e){} }
            if( ps != null ) { try{ ps.close(); } catch(Exception e){} }
            if( conn != null ) { try{ conn.close(); } catch(Exception e){} }
        }
    }

    // 지역 리스트 가져오기


    // 지역별 지점 리스트 가져오기
    public ArrayList<TheaterVO> searchTheater(String area_id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<TheaterVO> theaters= new ArrayList();

        try {
            conn = DriverManager.getConnection(url,id,pw);
            String sql = "SELECT theater_name, theater_id FROM room WHERE LIKE ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,area_id+'%');
            rs = ps.executeQuery();
            while (rs.next()){
                TheaterVO theater = new TheaterVO();
                theater.setTheater_id(rs.getString("theater_id"));
                theater.setTheater_name(rs.getString("theater_name"));
                theaters.add(theater);
            }
            return theaters;
        } catch (Exception e) {
            throw new Exception("지점 찾기 오류 : " + e.toString());
        }finally {
            if( rs != null ) { try{ rs.close(); } catch(Exception e){} }
            if( ps != null ) { try{ ps.close(); } catch(Exception e){} }
            if( conn != null ) { try{ conn.close(); } catch(Exception e){} }
        }
    }


}
