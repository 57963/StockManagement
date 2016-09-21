import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/hohome")
public class HOHomeServlet extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
            httpServletRequest.getRequestDispatcher("/WEB-INF/views/hohome.jsp").forward(httpServletRequest,httpServletResponse);
        }
}
