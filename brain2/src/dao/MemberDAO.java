package dao;
import java.sql.*;
import vo.MemberVO;
import vo.Myconn;
public class MemberDAO {

public MemberVO getInfo(String id) {
MemberVO vo = new MemberVO();
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
try {
	conn = Myconn.getConn();
	String sql = "select * from members where id=?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	rs = pstmt.executeQuery();
	if(rs.next()) {
		vo.setId(rs.getString("id"));
		System.out.printf("%s\n", vo.getId());
		vo.setAllMatch(rs.getInt("allMatch"));
		System.out.printf("%d\n", vo.getAllMatch());
		vo.setSuccessMatch(rs.getInt("successMatch"));
		System.out.printf("%d\n", vo.getSuccessMatch());
		vo.setName(rs.getString("Uname"));
		System.out.printf("%s\n", vo.getName());
		vo.setEmail(rs.getString("email"));
		System.out.printf("%s\n", vo.getEmail());
		vo.setPasswd(rs.getString("passwd"));
		System.out.printf("%s\n", vo.getPasswd());
		vo.setKtid(rs.getString("ktid"));
		System.out.printf("%s\n", vo.getKtid());
	}
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return vo;
}
}