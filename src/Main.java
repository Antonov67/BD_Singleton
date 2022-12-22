import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Statement statement = BDConnect.getInstance().getStatement();
        String sql = "SELECT * FROM users";
        try {
            ResultSet set = statement.executeQuery(sql);
            while (set.next()){
                System.out.println(set.getString(1)
                        + " " + set.getString(2)
                        + " "  + set.getString(3)
                        + " " + set.getString(4)
                        + " " + set.getString(5)
                        + " " + set.getString(6));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}