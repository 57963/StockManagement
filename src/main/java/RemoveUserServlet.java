import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/removeUser")
public class RemoveUserServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        SQL sql = new SQL();
        sql.update("DELETE FROM stock_management.users WHERE userID=?",httpServletRequest.getParameter("ID"));
        httpServletResponse.sendRedirect("/users");
        sql.close();
    }
}
