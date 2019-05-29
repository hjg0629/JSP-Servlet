import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import vo.Myconn;
import vo.AlarmVO;
import dao.AlarmDAO;
import dao.MemberDAO;

@WebServlet("/MakeAlarmProc")
public class MakeAlarmProc extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		System.out.println("<<<<<<<<<<<<<<<<<<< MakeMatchProc 실행 >>>>>>>>>>>>>>>>>>>>>");
		HttpSession session = request.getSession();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AlarmVO vo = new AlarmVO();
		
		String jm = request.getParameter("joinman");
		String cm = request.getParameter("createman");
		int k = Integer.parseInt(request.getParameter("Kind"));
		String ft = request.getParameter("finishtime").toString();
		int f = Integer.parseInt(request.getParameter("flag"));
		int msn  = Integer.parseInt(request.getParameter("matchseqNo"));
		
		try {
			conn = Myconn.getConn();
			vo.setJoinman(jm);
			vo.setCreateman(cm);
			vo.setKind(k);
			vo.setFinishtime(Timestamp.valueOf(ft));
			vo.setFlag(f);
			vo.setMatchseqNo(msn);
			
			int result = AlarmDAO.Insert(vo);
			String pr = null;
			if(result == 1) {
				System.out.println("MakeAlarmProc : Alarm Making 성공!");
				pr = "success";
				boolean makeresult = MemberDAO.makeMatch((String)session.getAttribute("id"));
				response.sendRedirect("main.jsp?result="+pr);
			}
			else {
				response.sendRedirect("makeasports.jsp?result="+pr);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("<<<<<<<<<<<<<<<<<<< MakeAlarmProc 종료 >>>>>>>>>>>>>>>>>>>>>");

	}
}
