package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDao;
/**
 * Servlet implementation class Registservlet
 */
@WebServlet("/servlets/Registservlet")
public class Registservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registservlet() {
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
		//实例化Dao类
		UserDao userdao=new UserDao();
		//获取表单元素
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		String birth=request.getParameter("birth");
		String phone=request.getParameter("phone");
		String idnum=request.getParameter("idnum");
		String introduce=request.getParameter("introduce");
		String address=request.getParameter("address");
		Date birthdy=null;
		try {
			if(birth!="") {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				birthdy=sdf.parse(birth);
				int x=userdao.regist(username, password, sex, birthdy, phone, idnum, introduce, address);
				if(x>0) {
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.println("注册成功！(3秒后回到登录界面)");
					response.setHeader("Refresh", "3;url=/xm/login.html");
				}
				else {
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.println("注册失败！(请重新填写)");
					response.sendRedirect("/xm/regist.html");
				}
			}
			else {
				int x=userdao.regist(username, password, sex, birthdy, phone, idnum, introduce, address);
				if(x>0) {
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.println("注册成功！(3秒后回到登录界面)");
					response.setHeader("Refresh", "3;url=/xm/login.html");
				}
				else {
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.println("注册失败！(请重新填写)");
					response.sendRedirect("/xm/regist.html");
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
