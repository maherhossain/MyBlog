package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest reqt = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            HttpSession ses = reqt.getSession(false);
 
            String reqURI = reqt.getRequestURI();
            if ((ses != null && ses.getAttribute("uname") != null && !ses.getAttribute("uname").equals("") )){
                if(ses.getAttribute("uname").equals("admin")){
                    resp.sendRedirect(reqt.getContextPath() + "/admin/welcome.xhtml");
                } else{
                    chain.doFilter(request, response);
                }    
                
            }
            
            else{
                resp.sendRedirect(reqt.getContextPath() + "/login");
            }
            
        } catch (Exception e) {
        }
       
    }

    @Override
    public void destroy() {
       
    }
    
}
