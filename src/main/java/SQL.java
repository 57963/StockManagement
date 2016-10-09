import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SQL {
    static PreparedStatement setup(String body, String... data){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
            PreparedStatement statement = connection.prepareStatement(body);
            for(int i = 0; i< data.length;i++){
                if(data[i]!=null) {
                    statement.setString(i + 1, data[i]);
                }
            }
            return statement;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    static ResultSet query(String query, String... data){
        try {
            return setup(query,data).executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static void update(String update, String... data){
        try {
            setup(update,data).executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
