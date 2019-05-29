

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import vo.Myconn;
/**
 * Servlet implementation class ConfirmId
 */
@WebServlet("/ConfirmId")
public class ConfirmId extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = "can";
		try {
			conn = Myconn.getConn();
			String sql = "select * from members where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = "not";
			}
			response.sendRedirect("confirmidResult.jsp?result="+result+"&id="+id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
			}
			catch(Exception e) {
				
			}
			try {
				conn.close();
			}
			catch(Exception e) {
				
			}
		}
	}

}
