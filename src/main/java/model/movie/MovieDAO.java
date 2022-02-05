package model.movie;

import model.company.AreaVO;
import model.company.Movie_showVO;
import model.company.RoomVO;
import model.company.TheaterVO;
import oracle.jdbc.proxy.annotation.Pre;
import service.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieDAO extends ConnectDB {
    private static MovieDAO instance;
    private static final String url = "jdbc:oracle:thin:@db202201202020_high?TNS_ADMIN=/Users/spongebob53/Oracle/instantclient/network/Wallet_DB202201202020";
//    private static final String url = "jdbc:oracle:thin:@db202201202020_high?TNS_ADMIN=/Users/iyxuna/Downloads/Wallet_DB202201202020";
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

    // 영화 세부정보
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

    // 영화 리스트
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

    // 지역 리스트 가져오기
    public ArrayList<AreaVO> areaList() throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<AreaVO> areas = new ArrayList();

        try {
            conn = DriverManager.getConnection(url,id,pw);
            String sql = "SELECT * FROM area";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                AreaVO area = new AreaVO();
                area.setArea_id(rs.getString("area_id"));
                area.setArea_name(rs.getString("area_name"));
                areas.add(area);
            }
            return areas;
        } catch (Exception e) {
            throw new Exception("지역 리스트 오류 : " + e.toString());
        }finally{
            if(rs != null){try{rs.close();}catch(Exception e){}}
            if(ps != null){try{ps.close();}catch(Exception e){}}
            if(conn != null){try{conn.close();}catch(Exception e){}}
        }
    }

    // 지역별 지점 리스트 가져오기
    public ArrayList<TheaterVO> theaterList(String area_id) throws Exception {
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
            throw new Exception("지점 리스트 오류 : " + e.toString());
        }finally {
            if( rs != null ) { try{ rs.close(); } catch(Exception e){} }
            if( ps != null ) { try{ ps.close(); } catch(Exception e){} }
            if( conn != null ) { try{ conn.close(); } catch(Exception e){} }
        }
    }

    // 지점별 상영관 리스트 가져오기
    public ArrayList<RoomVO> roomList(String theater_id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<RoomVO> rooms= new ArrayList();

        try {
            conn = DriverManager.getConnection(url,id,pw);
            String sql = "SELECT * FROM room WHERE LIKE ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,theater_id+'%');
            rs = ps.executeQuery();
            while (rs.next()){
                RoomVO room = new RoomVO();
                room.setRoom_id(rs.getString("room_id"));
                room.setRoom_name(rs.getString("room_name"));
                room.setRoom_seat(rs.getInt("room_seat"));
                rooms.add(room);
            }
            return rooms;
        } catch (Exception e) {
            throw new Exception("상영관 리스트 오류 : " + e.toString());
        }finally {
            if( rs != null ) { try{ rs.close(); } catch(Exception e){} }
            if( ps != null ) { try{ ps.close(); } catch(Exception e){} }
            if( conn != null ) { try{ conn.close(); } catch(Exception e){} }
        }
    }

    // 지점별 상영 영화 목록
    public ArrayList<Movie_showVO> showList(String theater_id) throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Movie_showVO> shows = new ArrayList();
        try{
            conn = DriverManager.getConnection(url,id,pw);
            String sql = "SELECT * FROM movie_show WHERE room_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, theater_id+'%');
            rs = ps.executeQuery();
            while (rs.next()){
                Movie_showVO show = new Movie_showVO();
                show.setMovie_show_id(rs.getString("movie_show_id"));
                show.setMovie_id(rs.getString("movie_id"));
                show.setRoom_id(rs.getString("room_id"));
                show.setShow_start(rs.getString("show_start"));
                shows.add(show);
            }
            return shows;
        }catch(Exception e){
            throw new Exception("지점별 상영 목록 오류 : " + e.toString());
        }finally {
            if( rs != null ) { try{ rs.close(); } catch(Exception e){} }
            if( ps != null ) { try{ ps.close(); } catch(Exception e){} }
            if( conn != null ) { try{ conn.close(); } catch(Exception e){} }
        }
    }

    // 예매 아이디 생성
    public String makeBookID(String movie_id, String room_id, String show_start, String seat_id) throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String book_id = null;
        try{
            conn = DriverManager.getConnection(url,id,pw);
            String sql = "SELECT movie_show_id FROM movie_show WHERE movie_id = ? AND room_id = ? AND show_start = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,movie_id);
            ps.setString(2,room_id);
            ps.setString(3,show_start);
            rs = ps.executeQuery();
            while(rs.next()){
                book_id = rs.getString("movie_show_id")+seat_id;
            }
            return book_id;
        }catch(Exception e){
            throw new Exception("예매 아이디 오류 : " + e.toString());
        }finally {
            if( rs != null ) { try{ rs.close(); } catch(Exception e){} }
            if( ps != null ) { try{ ps.close(); } catch(Exception e){} }
            if( conn != null ) { try{ conn.close(); } catch(Exception e){} }
        }
    }

    // 상영별 예매 완료된 좌석 불러오기
    public ArrayList<String> booked(String movie_show_id) throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> bookList = new ArrayList();

        try{
            conn = DriverManager.getConnection(url,id,pw);
            String sql = "SELECT book_id FROM book WHERE book_id LIKE ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, movie_show_id+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                bookList.add(rs.getString("book_id").substring(9));
            }
            return bookList;
        }catch(Exception e){
            throw new Exception("예매 좌석 확인 오류 : " + e.toString());
        }finally {
            if( rs != null ) { try{ rs.close(); } catch(Exception e){} }
            if( ps != null ) { try{ ps.close(); } catch(Exception e){} }
            if( conn != null ) { try{ conn.close(); } catch(Exception e){} }
        }
    }
}
