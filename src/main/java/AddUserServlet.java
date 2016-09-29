import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/addUser")
public class AddUserServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String username = httpServletRequest.getParameter("firstName")+httpServletRequest.getParameter("surname");
        Location location = null;
        for(Location l :(ArrayList<Location>)httpServletRequest.getSession().getAttribute("locations")){
            if(l.getName().equals(httpServletRequest.getParameter("location"))){
                location=l;
            }
        }
        SQL sql = new SQL();
        sql.update("INSERT INTO stock_management.users (username,password,location,firstName,surname,rights) VALUES (?,PASSWORD(?),?,?,?,?);",username,username,location.getID()+"",httpServletRequest.getParameter("firstName"),httpServletRequest.getParameter("surname"),(httpServletRequest.getParameter("rights").equals("Admin")?1:0)+"");
        sql.close();
        httpServletResponse.sendRedirect("/users");
    }
}
