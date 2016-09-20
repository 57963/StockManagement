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
        SQL sql = new SQL();
        try {
            ResultSet rs = sql.query("SELECT password=password(?), location*(password=password(?))" +
                    " from stock_management.users where username=?;",httpServletRequest.getParameter("password"),httpServletRequest.getParameter("password"),httpServletRequest.getParameter("username"));
            if (rs.next() && rs.getBoolean(1)){
                httpServletRequest.getSession().setAttribute("loggedIn",true);
                httpServletRequest.getSession().setAttribute("location",rs.getInt(2));

            }else{
                httpServletRequest.getSession().setAttribute("loggedIn",false);
                httpServletResponse.sendRedirect("");
            }
        } catch (Exception e){
            e.printStackTrace();
            httpServletRequest.getSession().setAttribute("loggedIn",false);
        }
        sql.close();
    }
}
