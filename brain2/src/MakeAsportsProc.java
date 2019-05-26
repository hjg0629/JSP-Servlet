

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.sql.Date;
import vo.Myconn;
import vo.MatchVO;
import dao.MakeMatchDAO;
import java.util.*;
@WebServlet("/MakeAsportsProc")
public class MakeAsportsProc extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MatchVO vo = new MatchVO();
		int tf = Integer.parseInt(request.getParameter("teamflag"));
		int needman = Integer.parseInt(request.getParameter("memnum"));
		int nowman = 0;
		int flag1 = Integer.parseInt(request.getParameter("flag1"));
		String st = request.getParameter("stime");
		System.out.printf("%s\n", st);
		//java.sql.Timestamp stime = java.sql.Timestamp.valueOf(st);
		String et = request.getParameter("etime");
		//java.sql.Timestamp etime = java.sql.Timestamp.valueOf(et);
		try {
			conn = Myconn.getConn();
			vo.setTitle(request.getParameter("title"));
			vo.setStime(st);
			vo.setEtime(et);
			vo.setContents(request.getParameter("etc"));
			vo.setAddr(request.getParameter("place"));
			vo.setTeamflag(tf);
			vo.setFlag1(flag1);
			vo.setFlag2(request.getParameter("AEvent"));
			vo.setNeedman(needman);
			vo.setNowman(nowman);
			int result = MakeMatchDAO.Insert(vo);
			if(result == 1) {
				System.out.println("글쓰기 성공");
			}
			else System.out.println("실패 ;;");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
