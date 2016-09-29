import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        if(((User)httpServletRequest.getSession().getAttribute("user")).getLocation().getLocationType()== Location.LocationType.HeadOffice){
            httpServletRequest.getRequestDispatcher("/WEB-INF/views/hohome.jsp").forward(httpServletRequest,httpServletResponse);
        }else{
            httpServletRequest.getRequestDispatcher("/WEB-INF/views/storehome.jsp").forward(httpServletRequest,httpServletResponse);
        }

    }
}
