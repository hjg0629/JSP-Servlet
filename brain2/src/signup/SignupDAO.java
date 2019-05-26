package signup;
import java.sql.*;
import javax.servlet.*;
public class SignupDAO {
private Connection conn = null;
private PreparedStatement pstmt = null;
private ResultSet rs = null;
private static SignupDAO signupdao = new SignupDAO();
public static SignupDAO getInstatnce() {
	return signupdao;
}
}
