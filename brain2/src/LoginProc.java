

import java.io.IOException;
import vo.Myconn;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import javax.servlet.*;

@WebServlet("/LoginProc")
public class LoginProc extends HttpServlet {   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginProc 실행");
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		String id = request.getParameter("id");
		System.out.printf("입력받은 ID : %s",id);

		String passwd = request.getParameter("pw");
		try {
			conn = Myconn.getConn();
			String sql = "select * from members where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			String result =null;
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("id 존재");
				String userpass = rs.getString("passwd");
				System.out.printf("userpass : %s",userpass);
				System.out.printf("passwd : %s",passwd);
				if(userpass.equals(passwd)) {
					//id passwd 일치
					HttpSession session = request.getSession();
					session.setAttribute("id", id);
					response.sendRedirect("main.jsp");
				}
				else {
					result = "passwdno";
					response.sendRedirect("login.jsp?result="+result+"&id="+id);

					//passwd 불일치
				}
			}
			else {
				result = "idno";
				response.sendRedirect("login.jsp?result="+result);

				System.out.println("id 없엉");

				// id가 없음
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
