

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutProc
 */
@WebServlet("/LogoutProc")
public class LogoutProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("<<<<<<<<<<<<<<<<<<< LogOutProc 실행 >>>>>>>>>>>>>>>>>>>>>");

	

		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println("<<<<<<<<<<<<<<<<<<< LogOutProc 완료 >>>>>>>>>>>>>>>>>>>>>");

		response.sendRedirect("main.jsp");
		System.out.println("main.jsp로 이동합니다....\n");
	}

}
