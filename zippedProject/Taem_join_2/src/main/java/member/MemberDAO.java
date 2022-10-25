package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

public class MemberDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MemberDAO() {
		try {
			String dbURL ="jdbc:mysql://localhost:3306/testDB";
			String dbID ="java";
			String dbPassword ="java";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int login (String member_id, String member_pw) {
		String SQL = "SELECT member_pw from member member_id=?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, member_id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(member_pw)) {
					return 1;//로그인성공
				}
				else {
					return 0; //비민번호 불일
				}
			}
			return -1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -2;
	}
	public int join(Member member) {
		String SQL ="INSERT INTO member value(?,?,?,?,?,?,?)";
			try {
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, member.getMember_id());
				pstmt.setString(2, member.getMember_pw());
				pstmt.setString(3, member.getMember_name());
				pstmt.setString(4, member.getMember_birth());
				pstmt.setString(5, member.getMember_phone());
				pstmt.setString(6, member.getMember_email());
				pstmt.setString(7, member.getMember_gender());
				return pstmt.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
			return -1;
	}

}
