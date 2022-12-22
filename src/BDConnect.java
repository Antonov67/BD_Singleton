import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BDConnect {
    private  Connection connection;
    private static BDConnect instance;
    private BDConnect() {}
    public static BDConnect getInstance(){
        if (instance == null){
            instance = new BDConnect();
        }
        return instance;
    }

    public Statement getStatement(){
        Statement statement;
        try {
            connection = DriverManager.getConnection(BDSettings.URL, BDSettings.DB_USER,BDSettings.DB_PSWRD);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }
    public void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
