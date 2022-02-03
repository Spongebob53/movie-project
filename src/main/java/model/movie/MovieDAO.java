package model.movie;

import service.ConnectDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieDAO extends ConnectDB {
    private static MovieDAO instance;
    private static final String url = "jdbc:oracle:thin:@db202201202020_high?TNS_ADMIN=/Users/spongebob53/Oracle/instantclient/network/Wallet_DB202201202020";
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
            ps.setInt(1,movie.getMovie_id());
            rs = ps.executeQuery();

            while(rs.next()){
                int movie_id = rs.getInt("movie_id");
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
            if( rs != null ) { try{ rs.close(); } catch(Exception ex){} }
            if( ps != null ) { try{ ps.close(); } catch(Exception ex){} }
            if( conn != null ) { try{ conn.close(); } catch(Exception ex){} }
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
                int movie_id = rs.getInt("movie_id");
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
            if( rs != null ) { try{ rs.close(); } catch(Exception ex){} }
            if( ps != null ) { try{ ps.close(); } catch(Exception ex){} }
            if( conn != null ) { try{ conn.close(); } catch(Exception ex){} }
        }
    }
}
