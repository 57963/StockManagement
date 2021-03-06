import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        try {
            ResultSet userRs = SQL.query("SELECT userID, location, firstName, surname, rights FROM stock_management.users " +
                    "WHERE username = ? AND password = PASSWORD(?);",httpServletRequest.getParameter("username"),httpServletRequest.getParameter("password"));
            if (userRs.next()){
                ResultSet locationRs = SQL.query("SELECT * FROM stock_management.locations WHERE locationID=?",userRs.getInt("location")+"");
                locationRs.next();
                Location location = new Location(locationRs.getInt("locationID"),locationRs.getString("name"), locationRs.getInt("locationID")==1? Location.LocationType.HeadOffice: Location.LocationType.Store);
                httpServletRequest.getSession().setAttribute("loggedIn",true);
                httpServletRequest.getSession().setAttribute("userID",userRs.getInt("userID"));
                httpServletResponse.sendRedirect("/home");
            }else{
                httpServletRequest.getSession().setAttribute("loggedIn",false);
                httpServletRequest.getSession().setAttribute("error", "Incorrect login details.");
                httpServletResponse.sendRedirect("");
            }
        } catch (Exception e){
            e.printStackTrace();
            httpServletRequest.getSession().setAttribute("error", "Database error.");
            httpServletResponse.sendRedirect("");
            httpServletRequest.getSession().setAttribute("loggedIn",false);
        }
    }
}
