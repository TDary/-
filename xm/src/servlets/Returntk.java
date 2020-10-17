package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDao;
/**
 * Servlet implementation class Returntk
 */
@WebServlet("/servlets/Returntk")
public class Returntk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Returntk() {
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
		int Arrangement_id=Integer.parseInt(request.getParameter("argeid"));
		//System.out.print(Arrangement_id);
		UserDao deltkdao=new UserDao();
		try {
			int result=deltkdao.deletetk(Arrangement_id);
			if(result>0) {
				System.out.println("退票成功！");
				response.sendRedirect("/xm/ordershow.jsp");
			}
			else {
				System.out.println("退票失败！");
				response.sendRedirect("/xm/ordershow.jsp");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
