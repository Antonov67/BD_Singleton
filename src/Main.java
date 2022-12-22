import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    static Statement statement = BDConnect.getInstance().getStatement();
    public static void main(String[] args) throws SQLException {
        ResultSet set = allRecords();
        while (set.next()){
            System.out.println(set.getString(1)
                    + " " + set.getString(2)
                    + " "  + set.getString(3)
                    + " " + set.getString(4)
                    + " " + set.getString(5)
                    + " " + set.getString(6));
        }
    }
    //выбор всех данных
    static ResultSet allRecords(){
        String sql = "SELECT * FROM users";
        ResultSet set;
        try {
            set = statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return set;
    }


}