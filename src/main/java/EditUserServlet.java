import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(urlPatterns = "/editUser")
public class EditUserServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        SQL.update("UPDATE stock_management.users SET username = '' WHERE userID = ?",httpServletRequest.getParameter("ID"));
        String username = Utils.uniqueUsername(httpServletRequest.getParameter("firstName") +httpServletRequest.getParameter("surname"));
        SQL.update("UPDATE stock_management.users SET username = ?, password = PASSWORD(?), location = ?, firstName = ?, surname = ?, rights = ? WHERE userID = ?",username, username, httpServletRequest.getParameter("location"),httpServletRequest.getParameter("firstName"),httpServletRequest.getParameter("surname"),httpServletRequest.getParameter("rights"),httpServletRequest.getParameter("ID"));
        httpServletResponse.sendRedirect("/users");
    }
}
