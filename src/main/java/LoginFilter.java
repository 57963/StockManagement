import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "*")
public class LoginFilter implements Filter {
    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if(req.getRequestURI().startsWith("/styles/") || req.getRequestURI().startsWith("/scripts/") || req.getRequestURI().startsWith("/lib/") || req.getRequestURI().equals("/") || req.getRequestURI().equals("/login")){
            filterChain.doFilter(servletRequest,servletResponse);
        } else if(req.getSession().getAttribute("loggedIn")!=null){
            if((boolean)(req.getSession().getAttribute("loggedIn"))){
                Utils.addAllInfo(req.getSession());
                filterChain.doFilter(servletRequest,servletResponse);
            } else {
                ((HttpServletResponse)servletResponse).sendRedirect("");
            }

        } else {
            ((HttpServletResponse)servletResponse).sendRedirect("");
        }
    }
}
