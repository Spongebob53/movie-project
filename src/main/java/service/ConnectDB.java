package service;

// 커넥트 클래스
// 인터페이스로 구현하고 싶었으나 public 이라 클래스를 상속받는 쪽으로 시도
// 괜찮을까?? 괜찮다면 db 계정 변수도 넣어도 될까?
// DAO가 커질 것같아 Movie와 Customer 두개의 DAO로 나눠봤는데 이 접근방식은 어떤지??
public class ConnectDB {
    private static ConnectDB instance;
    private static final String dbDriver = "oracle.jdbc.OracleDriver";

    public static ConnectDB getInstance() throws Exception {
        if (instance == null) {
            instance = new ConnectDB();
        }
        return instance;
    }

    protected ConnectDB() throws Exception {
        try {
            Class.forName(dbDriver);
        } catch (Exception e) {
            throw new Exception("DB연결 오류 : " + e.toString());
        }
    }
}
