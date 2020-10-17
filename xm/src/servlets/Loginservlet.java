package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/servlets/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取表单元素值
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserDao userdao=new UserDao();
		HttpSession session=request.getSession();
		try {
			String users=userdao.login(username, password);
			if(users!=null) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("登录成功！(3秒后回到首页界面)");
				session.setAttribute("success", users);
				response.setHeader("Refresh", "3;url=/xm/ShowInfo.html");
			}
			else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("登录失败！用户名或密码错误！(3秒后回到登录界面)");
				response.setHeader("Refresh", "3;url=/xm/login.html");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
