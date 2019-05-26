

import java.io.IOException;
import vo.Myconn;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.*;

@WebServlet("/RegisterProg")
public class RegisterProc extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		Connection conn = null;
		PreparedStatement pstmt = null;
		String id = request.getParameter("id");
		String passwd = request.getParameter("pw");
		String name = request.getParameter("name");
		String email1 =request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String ktid = request.getParameter("ktid");
		try {
			conn = Myconn.getConn();
			if(conn == null) {
				System.out.println("¾¾¹ß");
			}
			String sql = "insert into members values( ?,?,?,?,0,0,? );";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email1+"@"+email2);
			pstmt.setString(5, ktid);
			int result = pstmt.executeUpdate();
			if(result == 1) {
				response.sendRedirect("login.jsp");
			}
			else response.sendRedirect("regiser.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try{
				pstmt.close();
			}
			catch(Exception e) {
				
			}
			try{
				conn.close();
			}
			catch(Exception e) {
				
			}
		}
	}

}
