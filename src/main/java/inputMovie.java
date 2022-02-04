
import model.movie.MovieDAO;
import model.movie.MovieVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class inputMovie {
    private static inputMovie instance;

//    private static final String url = "jdbc:oracle:thin:@db202201202020_high?TNS_ADMIN=/Users/spongebob53/Oracle/instantclient/network/Wallet_DB202201202020";
    private static final String url = "jdbc:oracle:thin:@db202201202020_high?TNS_ADMIN=/Users/iyxuna/Downloads/Wallet_DB202201202020";
    private static final String id = "admin";
    private static final String pw = "1q2w3e4r5t^Y";

    public static inputMovie getInstance() throws Exception {
        if (instance == null) {
            instance = new inputMovie();
        }
        return instance;
    }

    private inputMovie() throws Exception {
        super();
    }

    public static ArrayList getRoomId() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> rooms_id = new ArrayList();

        try {
            conn = DriverManager.getConnection(url, id, pw);
            String sql1 = "SELECT room_id FROM room";
            ps = conn.prepareStatement(sql1);
            rs = ps.executeQuery();
            while(rs.next()){
                rooms_id.add(rs.getString("room_id"));
            }
            return rooms_id;
        }catch(Exception e){
            throw new Exception("상영관 호출하기 오류 : " + e.toString());
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {

                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }
    }

    public static MovieVO getMovieTime() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MovieVO movie = new MovieVO();
        try {
            conn = DriverManager.getConnection(url, id, pw);
            String sql = "SELECT movie_id, movie_time FROM movie WHERE movie_title = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, perMovie());
            rs = ps.executeQuery();
            while (rs.next()) {
                movie.setMovie_id(rs.getString("movie_id"));
                movie.setMovie_time(rs.getInt("movie_time"));
            }
            return movie;
        } catch (Exception e) {
            throw new Exception("영화 시간 호출 오류 : " + e.toString());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {

                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> rooms_id;

        try {
            conn = DriverManager.getConnection(url, id, pw);
            rooms_id = getRoomId();
            for (String room_id : rooms_id) {
                int addHour = 0;
                int addMinute = 0;
                for (int a = 0; a < 5; a++) {
                    String time = "22/2/4 " + (8 + addHour) + ":" + (0 + addMinute);
                    MovieVO movie = getMovieTime();
                    String movie_id = movie.getMovie_id();
                    int movie_time = movie.getMovie_time();
                    String sql = "INSERT INTO movie_show(movie_show_id, movie_id, room_id, show_start) VALUES(?||LPAD(seq_movie_show.nextval,7,'0'),LPAD(?,5,'0'),?,TO_DATE(?,'YY/MM/DD HH24:MI'))";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, time.substring(0,2));
                    ps.setString(2, movie_id);
                    ps.setString(3, room_id);
                    ps.setString(4, time);
                    ps.executeQuery();
                    movie_time += 30;
                    addHour += movie_time / 60;
                    addMinute += movie_time % 60;
                    if (addMinute > 59) {
                        addHour++;
                        addMinute -= 60;
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception("상영 정보 등록 오류 : " + e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {

                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }
    }

    public static String perMovie() {
        int ran = (int) (Math.round(Math.random() * 100) + 1);
        String word = null;

        if (ran > 70) {
            word = "해적";
        } else if (ran > 50) {
            word = "킹메이커";
        } else if (ran > 33) {
            word = "스파이더맨";
        } else if (ran > 22) {
            word = "자두야";
        } else if (ran > 14) {
            word = "씽2게더";
        } else if (ran > 9) {
            word = "특송";
        } else if (ran > 6) {
            word = "경관의 피";
        } else if (ran > 4) {
            word = "셜록홈즈";
        } else if (ran > 2) {
            word = "구찌";
        } else {
            word = "인어가 잠든 집";
        }
        return word;
    }
}
