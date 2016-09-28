import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SQL {
    Connection connection;
    ResultSet rs;
    SQL(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    ResultSet query(String query, String... data){
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            for(int i = 0; i< data.length;i++){
                statement.setString(i+1, data[i]);
            }
            rs = statement.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    void update(String update){
        try{
            connection.createStatement().executeUpdate(update);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void close(){
        try {
            rs.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
