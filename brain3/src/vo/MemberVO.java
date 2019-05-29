package vo;

public class MemberVO {
private String id;
private String passwd;
private String name;
private String ktid;
private String email;
private int allMatch;
public int getAllMatch() {
	return allMatch;
}
public void setAllMatch(int allMatch) {
	this.allMatch = allMatch;
}
public int getSuccessMatch() {
	return successMatch;
}
public void setSuccessMatch(int successMatch) {
	this.successMatch = successMatch;
}
private int successMatch;
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
	if(name == null) {
		name =" ";
	}
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getKtid() {
	if(ktid == null) {
		ktid =" ";
	}
	return ktid;
}
public void setKtid(String ktid) {
	this.ktid = ktid;
}
public String getEmail() {
	if(email == null) {
		email =" ";
	}
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}
