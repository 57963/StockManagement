import javax.mail.Session;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class Utils {
    static void addAllInfo(HttpSession session){
        ResultSet rs = SQL.query("SELECT * FROM stock_management.locations");
        ArrayList<Location> locations = new ArrayList<>();
        try {
            while (rs.next()){
                locations.add(new Location(rs.getInt("locationID"),rs.getString("name"),rs.getInt("type")==1? Location.LocationType.HeadOffice: Location.LocationType.Store));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        session.setAttribute("locations",locations);
        rs = SQL.query("SELECT userID, location, firstName, surname, rights FROM stock_management.users");
        ArrayList<User> users = new ArrayList<>();
        try {
            while (rs.next()) {
                users.add(new User(rs.getInt("userID"),rs.getString("firstName"),rs.getString("surname"),rs.getInt("rights")==1? User.Rights.Admin: User.Rights.User,locations.get(rs.getInt("location")-1)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        session.setAttribute("users",users);
        for(Location l: locations){
            for(User u:users){
                if(u.getLocation()==l){
                    l.getUsers().add(u);
                }
            }
        }
        rs = SQL.query("SELECT * FROM stock_management.sales");
        ArrayList<Sales> sales = new ArrayList<>();
        try{
            while(rs.next()){
                sales.add(new Sales(rs.getInt("week"),rs.getInt("year"),locations.get(rs.getInt("location")-1),rs.getInt("stock"),rs.getInt("quantity"),rs.getFloat("net")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        for(Location l: locations){
            for(Sales s:sales){
                if(s.getLocation()==l){
                    l.getSales().add(s);
                }
            }
        }
        session.setAttribute("sales",sales);
        session.setAttribute("user",getUserFromID((int)session.getAttribute("userID"),session));
        for(int i = 1; i< 53 ;i++){
            //sql.update("insert into stock_management.sales(week, year, location, stock, quantity, net) VALUES ("+i+",2016,1,1,1,"+((Math.sin(i/4f)*100f)+200)+")");
        }
    }

    static User getUserFromID(int ID,HttpSession session){
        for(User u: (ArrayList<User>)session.getAttribute("users")){
            if(u.getID()==ID){
                return u;
            }
        }
        return null;
    }
    static Location getLocationFromID(int ID,HttpSession session){
        for(Location l: (ArrayList<Location>)session.getAttribute("locations")){
            if(l.getID()==ID){
                return l;
            }
        }
        return null;
    }

    static int nextID(){
        ResultSet rs = SQL.query("SELECT userID FROM stock_management.users");
        try {
            int nextID = 1;
            while (rs.next()){
                if(rs.getInt("userID")!=nextID){
                    return nextID;
                }
                nextID++;
            }
            return nextID;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(null);
    }

    static String uniqueUsername(String testUsername){
        boolean unique = false;
        int modifier = -1;
        ResultSet rs;
        try {
            while(!unique){
                unique=true;
                rs = SQL.query("SELECT username FROM stock_management.users");
                modifier++;
                while (rs.next()){
                    if (rs.getString("username").equals(testUsername+(modifier==0?"":modifier))){
                        unique = false;
                    }
                }

            }
            return testUsername+(modifier==0?"":modifier);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
