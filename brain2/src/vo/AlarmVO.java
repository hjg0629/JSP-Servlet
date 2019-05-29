package vo;

import java.sql.Timestamp;

public class AlarmVO {
	int seqNo;
	String joinman;
	String createman;
	int kind;
	Timestamp finishtime;
	int flag;
	int matchseqNo;
	
	
	public int getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
	public String getJoinman() {
		return joinman;
	}
	public void setJoinman(String joinman) {
		this.joinman = joinman;
	}
	public String getCreateman() {
		return createman;
	}
	public void setCreateman(String createman) {
		this.createman = createman;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public Timestamp getFinishtime() {
		return finishtime;
	}
	public void setFinishtime(Timestamp finishtime) {
		this.finishtime = finishtime;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getMatchseqNo() {
		return matchseqNo;
	}
	public void setMatchseqNo(int matchseqNo) {
		this.matchseqNo = matchseqNo;
	}
	
}
