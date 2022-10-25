package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.Cookie;

import com.mysql.cj.x.protobuf.MysqlxSql.StmtExecute;

import util.SHA256;
import vo.MemberTBL;

public class UserDAO {
	//멤버변수(전역변수 : 전체 메서드에서 사용 가능)
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	/*** 싱글톤 패턴 : UserDAO객체 단 1개만 생성**************************
	 * 이유? 외부 클래스에서 "처음 생성된 UserDAO객체를 공유해서 사용하도록 하기 위해" 
	 */
	 
	//1.생성자는 무조건 private
	private UserDAO(){}
	
	private static UserDAO userDAO;
	//static이유? 객체를 생성하기 전에 이미 메모리에 올라간 getInstance()메서드를 통해서만 UserDAO객체를 1개만 만들도록 하기 위해
	public static UserDAO getInstance(){
		if(userDAO == null) {//UserDAO객체가 없으면
			userDAO = new UserDAO();//객체 생성
		}
		
		return userDAO;//기존 UserDAO객체의 주소 리턴
	}
	/************************************************************/
	
	public void setConnection(Connection con){//Connection객체를 받아 DB 연결
		this.con=con;
	}	
	
	/* 로그인 폼에서 입력한 id와 pw가 담긴 UserBean객체로 회원인지 조회 후 그 id를 반환
	 * (단, '비밀번호를 암호화'하였다면 암호화된 비밀번호가 담긴 UserBean객체)
	 */	
	public String selectLoginId(MemberTBL member){
		String loginId = null;
		
		//암호화X - 사용자가 입력한 id와 비번을 가진 회원의 id를 조회
		String sql="select member_id from memberTBL where member_id=? and member_pwd=?";
		
		//암호화O
		//String sql="select u_id, u_password from user_table where u_id=? and u_password=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMember_id());
			pstmt.setString(2, member.getMember_pwd());
			rs = pstmt.executeQuery();
			
			//암호화O
			if(rs.next()) {
				loginId = rs.getString("member_id");//방법-2
			}
			
			
		} catch (Exception e) {			
			System.out.println("[UserDAO] selectLoginId 에러:"+ e);//e:예외종류+예외메세지
		} finally {
			close(rs);
			close(pstmt);
		}
		return loginId;//회원가입이 되어있으면 id를 리턴, 그렇지 않으면 null
		
	}//selectLoginId()
	
	//user_table안의 회원정보를 u_id로 조회하여 반환
		public MemberTBL selectUserInfo(String member_id) {
			MemberTBL userInfo = null;
			//사용자가 입력한 id 회원정보를 조회		
			String sql="select * from memberTBL where member_id=?";		

			try {
				pstmt = con.prepareStatement(sql);	
				pstmt.setString(1, member_id);		
				rs = pstmt.executeQuery();
				
				if(rs.next()) {//해당 id에 대한 정보가 있으면
					//기본값으로 채워진 UserBean객체에 조회한 회원정보값으로 셋팅
					userInfo = new MemberTBL();
					
					userInfo.setMember_id((rs.getString("member_id")));
					userInfo.setMember_name((rs.getString("member_name")));
					userInfo.setMember_birth((rs.getString("member_birth")));
					userInfo.setMember_phone((rs.getString("member_phone")));
					userInfo.setMember_email((rs.getString("member_email")));
				}
			} catch (Exception e) {			
				System.out.println("[UserDAO] selectUserInfo 에러:"+ e);//e:예외종류+예외메세지
			} finally {
				close(rs);
				close(pstmt);
			}			
			
			return userInfo;
		}
		public int insertUser(MemberTBL member) {
			int insertUserCount = 0;
			
			String sql2 = "select ifnull(max(member_code),0)+1 as member_code from memberTBL";
			//member_code 세팅
			int member_code = 0 ;
			try {
				rs = pstmt.executeQuery(sql2);
				
				if(rs.next()) {
					member_code = rs.getInt(1);
				}
				
			} catch (Exception e) {			
				System.out.println("[UserDAO] member_code 불러오기 에러:"+ e);
			} finally {
				close(rs);
				close(pstmt);
			}	
			
			
			//----------------------------------------------------------------
			String sql = "insert into memberTBL(member_code, member_id,member_pwd,member_name,member_birth,member_phone,member_email,member_gender) values(?,?,?,?,?,?,?,?)";
			
			try {
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, member_code);				
				pstmt.setString(2, member.getMember_id());				
				pstmt.setString(3, member.getMember_pwd());			
				pstmt.setString(4, member.getMember_name());				
				pstmt.setString(5, member.getMember_birth());				
				pstmt.setString(6, member.getMember_phone());				
				pstmt.setString(7, member.getMember_email());				
				pstmt.setString(8, member.getMember_gender());				
				
				insertUserCount = pstmt.executeUpdate();//업데이트를 성공하면 1을 리턴받음			
				
			} catch (Exception e) {			
				System.out.println("[UserDAO] insertUser 에러:"+ e);
			} finally {
				close(rs);
				close(pstmt);
			}	
			return insertUserCount;
		}

}//class








