package DeleteData;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Delete")
public class delete extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		String action=request.getParameter("action");
		String email = (String) session.getAttribute("email");
		String crop= (String) session.getAttribute("crop");
		
		if(action.equals("Yes")) {
		dao d= new dao();
		try {
			d.delete(crop, email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		session.removeAttribute("crop");
		response.sendRedirect("buyer.jsp");
		}
	
}
