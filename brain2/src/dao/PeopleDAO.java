package dao;

import java.sql.*;
import java.util.ArrayList;

import vo.Myconn; 
import vo.PeopleVO;

public class PeopleDAO {	
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	public static java.sql.Timestamp getDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}
	public static int Insert(PeopleVO vo){
		try {			
			System.out.println("[[[[[PeopleDAO의  Insert 메소드 실행....]]]]]");

			conn = Myconn.getConn();
			String sql = "insert into people(joinman,matchseqNo,flag) values(?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getJoinman());
			pstmt.setInt(2, vo.getMatchseqNo());
			pstmt.setInt(3, vo.getFlag());
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("PeopleDAO : Insert 성공");
				return 1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("PeopleDAO : Insert 실패");
		return 0;
	}
	
	public static int getNext() {
		String SQL="select seqNo from people order by seqNo desc";
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
	
	public static ArrayList<PeopleVO> getList(int pageNumber,String id){
		System.out.println("[[[[[PeopleVO의 getList 메소드 실행....]]]]]");
		ArrayList<PeopleVO> list = new ArrayList<PeopleVO>();
		try {
			Connection conn=Myconn.getConn(); 
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			String SQL="select * from people where seqNo < ? and joinman = ? order by seqNo desc LIMIT 10";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,getNext()-(pageNumber-1)*10);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery(); 
			while(rs.next()) {
				PeopleVO vo =new PeopleVO();
				vo.setJoinman(rs.getString(1));
				vo.setMatchseqNo(rs.getInt(2));
				vo.setFlag(rs.getInt(3));
				list.add(vo);
			}			
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		System.out.println("[[[[[PeopleDAO의 getList 메소드 종....]]]]]");
		return list;
	}
	
	public static boolean nextPage(int pageNumber) {
		try {
			Connection conn=Myconn.getConn();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			int pagenumber=1;
			
			String SQL="select * from people where seqNo < ? AND seqNo > 0";
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
	
	public PeopleVO getPeople(int seqNo) {
		System.out.println("[[[[[PeopleDAO의 getMatches 메소드 실행....]]]]]");
		try {
			Connection conn=Myconn.getConn();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			String SQL="select * from people where seqNo = ?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,seqNo);
			rs = pstmt.executeQuery(); 
			while(rs.next()) {
				PeopleVO vo =new PeopleVO();
				vo.setJoinman(rs.getString(1));
				vo.setMatchseqNo(rs.getInt(2));
				vo.setFlag(rs.getInt(3));
				System.out.println("[[[[[PeopleDAO의 getMatches 메소드 종료....]]]]]");
				return vo;
			}			
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
}
