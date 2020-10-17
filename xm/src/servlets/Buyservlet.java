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
 * Servlet implementation class Buyservlet
 */
@WebServlet("/servlets/Buyservlet")
public class Buyservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buyservlet() {
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
		int car_id=Integer.parseInt(request.getParameter("id"));
		int number=Integer.parseInt(request.getParameter("count"));
		HttpSession session=request.getSession();
		String uname=(String) session.getAttribute("success");
		int y=0;
		int a=0;
		UserDao buy=new UserDao();
		try {
			int x=buy.buyticket(car_id, number);
			int ID=buy.findId(uname);
			for(int i=0;i<number;i++) {
				y=buy.addbook(car_id);
				a=buy.addbookid(ID,car_id);
			}
			if(a>0&&x>0&&y>0) {
				System.out.println("购买成功！");
				response.sendRedirect("/xm/Show.jsp");
			}
			else {
				System.out.println("购买失败！");
				response.sendRedirect("/xm/Show.jsp");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
