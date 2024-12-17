package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import objects.Cart;
import objects.User;

/**
 * Servlet Filter implementation class AuthorizeAdmin
 */
@WebFilter("/admin/*")
public class AuthorizeAdmin extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public AuthorizeAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest	request1=((HttpServletRequest)request);
		HttpServletResponse	response1=((HttpServletResponse)response);
		HttpSession session =request1.getSession();
		if(session.getAttribute("user")!=null) {
		Triplet<User, String,Cart> trip = (Triplet<User, String,Cart>) session.getAttribute("user") ;
		String role = trip.getValue1();
		if(role.equals("ROLE_ADMIN")) {
			chain.doFilter(request, response);
		}else {
			 response1.sendRedirect(request1.getContextPath()+"/404notfound");
		}
		 
		 }else {
			 response1.sendRedirect(request1.getContextPath()+"/404notfound");
		 }
	
}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
