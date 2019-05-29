package vo;
import java.sql.Timestamp;
import java.util.*;
public class MatchVO {
	private int seqNo;
	private Timestamp seqDate;
	private int flag1;
	private String flag2;
	private String title;
	private String stime;
	private String etime;
	private String contents;
	private String addr;
	private int teamflag;
	private int needman;
	private int nowman;
	private String writer;

	public int getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
	public Timestamp getSeqDate() {
		return seqDate;
	}
	public void setSeqDate(Timestamp seqDate) {
		this.seqDate = seqDate;
	}
	public int getFlag1() {
		return flag1;
	}
	public void setFlag1(int flag1) {
		this.flag1 = flag1;
	}
	public String getFlag2() {
		return flag2;
	}
	public void setFlag2(String flag2) {
		this.flag2 = flag2;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getEtime() {
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getTeamflag() {
		return teamflag;
	}
	public void setTeamflag(int teamflag) {
		this.teamflag = teamflag;
	}
	public int getNeedman() {
		return needman;
	}
	public void setNeedman(int needman) {
		this.needman = needman;
	}
	public int getNowman() {
		return nowman;
	}
	public void setNowman(int nowman) {
		this.nowman = nowman;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
}
