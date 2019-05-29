

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.sql.Date;
import vo.Myconn;
import vo.MatchVO;
import vo.MemberVO;
import dao.MatchDAO;
import dao.MemberDAO;

@WebServlet("/MakeMatchProc")
public class MakeMatchProc extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		System.out.println("<<<<<<<<<<<<<<<<<<< MakeMatchProc 실행 >>>>>>>>>>>>>>>>>>>>>");
		HttpSession session = request.getSession();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MatchVO vo = new MatchVO();
		int tf = Integer.parseInt(request.getParameter("teamflag"));
		int needman = Integer.parseInt(request.getParameter("memnum"));
		int nowman = 0;
		int flag1 = Integer.parseInt(request.getParameter("flag1"));
		String st = request.getParameter("stime");
		//java.sql.Timestamp stime = java.sql.Timestamp.valueOf(st);
		String et = request.getParameter("etime");
		//java.sql.Timestamp etime = java.sql.Timestamp.valueOf(et);
		try {
			conn = Myconn.getConn();
			vo.setTitle(request.getParameter("title"));
			vo.setStime(st);
			vo.setEtime(et);
			vo.setWriter(session.getAttribute("id").toString());
			vo.setContents(request.getParameter("etc"));
			vo.setAddr(request.getParameter("place"));
			vo.setTeamflag(tf);
			vo.setFlag1(flag1);
			String tmp = request.getParameter("Event");
			vo.setFlag2(request.getParameter("Event"));
			vo.setNeedman(needman);
			vo.setNowman(nowman);
			int result = MatchDAO.Insert(vo);
			String pr = null;
			if(result == 1) {
				System.out.println("MakeMatchProc : Match Making 성공!");
				pr = "success";
				boolean makeresult = MemberDAO.makeMatch((String)session.getAttribute("id"));
				if(makeresult) {
					System.out.println("MakeMatchProc : 총 매칭 시도 수 1 증가 성공!!");
				}else System.out.println("MakeMatchProc : 총 매칭 시도 수 1 증가 실패");
				response.sendRedirect("main.jsp?result="+pr);
			}
			else {
				System.out.println("MakeMatchProc : 총 매칭 시도 수 1 증가 성공!!");
				response.sendRedirect("makeasports.jsp?result="+pr);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("<<<<<<<<<<<<<<<<<<< MakeMatchProc 종료 >>>>>>>>>>>>>>>>>>>>>");

	}
}
