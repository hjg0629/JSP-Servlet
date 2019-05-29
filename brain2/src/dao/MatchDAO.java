package dao;

import java.sql.*;
import java.util.ArrayList;

import vo.MatchVO;
import vo.Myconn; 

public class MatchDAO {	
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	public static java.sql.Timestamp getDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}
	public static int Insert(MatchVO vo){
		try {			
			System.out.println("[[[[[MatchDAO의  Insert 메소드 실행....]]]]]");

			conn = Myconn.getConn();
			String sql = "insert into matches(flag1, flag2, title,stime,etime,contents,"
					+ "addr, teamflag, needman, nowman, writer) values(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getFlag1());
			pstmt.setString(2, vo.getFlag2());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getStime());
			pstmt.setString(5, vo.getEtime());
			pstmt.setString(6, vo.getContents());
			pstmt.setString(7, vo.getAddr());
			pstmt.setInt(8, vo.getTeamflag());
			pstmt.setInt(9, vo.getNeedman());
			pstmt.setInt(10, vo.getNowman());
			pstmt.setString(11, vo.getWriter());
			int result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("MatchDAO : Insert 성공");
				return 1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("MatchDAO : Insert 실패");

		return 0;
	}
	
	public static int getNext() {
		String SQL="select seqNo from matches order by seqNo desc";
		try {
			Connection conn=Myconn.getConn(); ;
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			ResultSet rs=null;
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1)+1;
			}
			return 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1;
	}
	
	public static ArrayList<MatchVO> getList(int pageNumber){
		System.out.println("[[[[[MatchDAO의 getList 메소드 실행....]]]]]");
		ArrayList<MatchVO> list = new ArrayList<MatchVO>();
		try {
			Connection conn=Myconn.getConn(); 
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			String SQL="select * from matches where seqNo < ? order by seqNo desc LIMIT 10";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,getNext()-(pageNumber-1)*10);
			rs = pstmt.executeQuery(); 
			while(rs.next()) {
				MatchVO match =new MatchVO();
				match.setSeqNo(rs.getInt(1));
				match.setSeqDate(rs.getTimestamp(2));
				match.setFlag1(rs.getInt(3));
				match.setFlag2(rs.getString(4));
				match.setTitle(rs.getString(5));
				match.setStime(rs.getTimestamp(6).toString());
				match.setEtime(rs.getTimestamp(7).toString());
				match.setContents(rs.getString(8));
				match.setAddr(rs.getString(9));
				match.setTeamflag(rs.getInt(10));
				match.setNeedman(rs.getInt(11));
				match.setNowman(rs.getInt(12));
				match.setWriter(rs.getString(13));
				list.add(match);
			}			
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		System.out.println("[[[[[MatchDAO의 getList 메소드 종....]]]]]");
		return list;
	}
	
	public static boolean nextPage(int pageNumber) {
		try {
			Connection conn=Myconn.getConn();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			int pagenumber=1;
			
			String SQL="select * from matches where seqNo < ? AND seqNo > 0";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,getNext()-(pagenumber-1)*10);
			rs = pstmt.executeQuery(); 
			while(rs.next()) {
				return true;
			}			
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public MatchVO getMatches(int seqNo) {
		System.out.println("[[[[[MatchDAO의 getMatches 메소드 실행....]]]]]");
		try {
			Connection conn=Myconn.getConn();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			String SQL="select * from matches where seqNo = ?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,seqNo);
			rs = pstmt.executeQuery(); 
			while(rs.next()) {
				MatchVO match =new MatchVO();
				match.setSeqNo(rs.getInt(1));
				match.setSeqDate(rs.getTimestamp(2));
				match.setFlag1(rs.getInt(3));
				match.setFlag2(rs.getString(4));
				match.setTitle(rs.getString(5));
				match.setStime(rs.getTimestamp(6).toString());
				match.setEtime(rs.getTimestamp(7).toString());
				match.setContents(rs.getString(8));
				match.setAddr(rs.getString(9));
				match.setTeamflag(rs.getInt(10));
				match.setNeedman(rs.getInt(11));
				match.setNowman(rs.getInt(12));
				match.setWriter(rs.getString(13));
				System.out.println("[[[[[MatchDAO의 getMatches 메소드 종료....]]]]]");
				return match;
			}			
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
}
