package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Logincheck
 */
@WebFilter(urlPatterns= {"/ShowInfo.html"})
public class Logincheck implements Filter {

    /**
     * Default constructor. 
     */
    public Logincheck() {
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
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;
		HttpSession session=req.getSession();
		//获取上下文路径
		String ctxPath=request.getServletContext().getContextPath();
		//获取请求的地址路径
		String url=req.getRequestURI();
		//获取请求对象
		String subUrl=url.substring(ctxPath.length()+1);
		if(subUrl.indexOf("LoginServlet")>-1||subUrl.indexOf("login.html")>-1) {
			chain.doFilter(request, response);
		}
		else {
			//如果有session，表示已经登录，则通过，否则跳转至登录页面
			if(session.getAttribute("success")!=null) {
				chain.doFilter(request, response);
			}
			else {
				System.out.println("您还未登录！");
				rep.sendRedirect("login.html");
			}
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
