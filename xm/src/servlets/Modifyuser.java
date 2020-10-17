package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.UserDao;
/**
 * Servlet implementation class Modifyuser
 */
@WebServlet("/servlets/Modifyuser")
public class Modifyuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifyuser() {
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
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("success");
		UserDao userdao=new UserDao();
		String selectvalue=request.getParameter("sele");
		if(selectvalue.equals("namevalue")) {
			try {
				String name=request.getParameter("content");
				int id=userdao.findId(username);
				int result=userdao.modifyname(id, name);
				if(result>0) {
					System.out.println("修改成功！");
					response.sendRedirect("/xm/servlets/Rushmdf");
				}
				else {
					System.out.println("修改失败！");
					response.sendRedirect("/xm/myaccount.jsp");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("修改失败！");
				response.sendRedirect("/xm/myaccount.jsp");
			}
		}
		else if(selectvalue.equals("pwdvalue")) {
			try {
				String password=request.getParameter("content");
				int id=userdao.findId(username);
				int result=userdao.modifyPwd(id, password);
				if(result>0) {
					System.out.println("修改成功！");
					response.sendRedirect("/xm/servlets/Rushmdf");
				}
				else {
					System.out.println("修改失败！");
					response.sendRedirect("/xm/myaccount.jsp");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("修改失败！");
				response.sendRedirect("/xm/myaccount.jsp");
			}
		}
		else if(selectvalue.equals("sexvalue")) {
			try {
				String sex=request.getParameter("content");
				int id=userdao.findId(username);
				int result=userdao.modifySex(id, sex);
				if(result>0) {
					System.out.println("修改成功！");
					response.sendRedirect("/xm/myaccount.jsp");
				}
				else {
					System.out.println("修改失败！");
					response.sendRedirect("/xm/myaccount.jsp");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("修改失败！");
				response.sendRedirect("/xm/myaccount.jsp");
			}
		}
		else if(selectvalue.equals("birthvalue")) {
			try {
				String birthday=request.getParameter("content");
				int id=userdao.findId(username);
				int result=userdao.modifyBirthday(id, birthday);
				if(result>0) {
					System.out.println("修改成功！");
					response.sendRedirect("/xm/myaccount.jsp");
				}
				else {
					System.out.println("修改失败！");
					response.sendRedirect("/xm/myaccount.jsp");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("修改失败！");
				response.sendRedirect("/xm/myaccount.jsp");
			}
		}
		else if(selectvalue.equals("phonevalue")) {
			try {
				String phone=request.getParameter("content");
				int id=userdao.findId(username);
				int result=userdao.modifyPhone(id, phone);
				if(result>0) {
					System.out.println("修改成功！");
					response.sendRedirect("/xm/myaccount.jsp");
				}
				else {
					System.out.println("修改失败！");
					response.sendRedirect("/xm/myaccount.jsp");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("修改失败！");
				response.sendRedirect("/xm/myaccount.jsp");
			}
		}
		else if(selectvalue.equals("idnumvalue")) {
			try {
				String idnum=request.getParameter("content");
				int id=userdao.findId(username);
				int result=userdao.modifyIdnum(id, idnum);
				if(result>0) {
					System.out.println("修改成功！");
					response.sendRedirect("/xm/myaccount.jsp");
				}
				else {
					System.out.println("修改失败！");
					response.sendRedirect("/xm/myaccount.jsp");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("修改失败！");
				response.sendRedirect("/xm/myaccount.jsp");
			}
		}
	}

}
