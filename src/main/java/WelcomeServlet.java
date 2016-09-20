import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(urlPatterns = "")
public class WelcomeServlet extends HttpServlet{
    String[][] results = new String[2][3];
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        SQL sql = new SQL();
        ResultSet rs = sql.query("SELECT * FROM stock_management.users");
        try {
            for(int i = 0; i< 2;i++){
                rs.next();
                results[i][0] = ""+ rs.getInt(1);
                results[i][1] = ""+ rs.getString(2);
                results[i][2] = ""+ rs.getString(3);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        httpServletRequest.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(httpServletRequest,httpServletResponse);
        sql.close();
    }
}