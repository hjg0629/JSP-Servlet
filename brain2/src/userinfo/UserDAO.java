package userinfo;

public class UserDAO {
	private String id;
	private String passwd;
	private String name;
	private String ktid;
	private String email;
	private String allMatch;
	private String successMatch;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKtid() {
		return ktid;
	}
	public void setKtid(String ktid) {
		this.ktid = ktid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAllMatch() {
		return allMatch;
	}
	public void setAllMatch(String allMatch) {
		this.allMatch = allMatch;
	}
	public String getSuccessMatch() {
		return successMatch;
	}
	public void setSuccessMatch(String successMatch) {
		this.successMatch = successMatch;
	}
	
}
