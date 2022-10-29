package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.ManagerTBL;
import vo.ManagerTBL;

public class ManagerDAO {
	// 멤버변수(전역변수 : 전체 메서드에서 사용 가능)
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	/***
	 * 싱글톤 패턴 : ManagerDAO객체 단 1개만 생성************************** 이유? 외부 클래스에서 "처음 생성된
	 * ManagerDAO객체를 공유해서 사용하도록 하기 위해"
	 */

	// 1.생성자는 무조건 private
	private ManagerDAO() {
	}

	private static ManagerDAO userDAO;

	// static이유? 객체를 생성하기 전에 이미 메모리에 올라간 getInstance()메서드를 통해서만 ManagerDAO객체를 1개만
	// 만들도록 하기 위해
	public static ManagerDAO getInstance() {
		if (userDAO == null) {// ManagerDAO객체가 없으면
			userDAO = new ManagerDAO();// 객체 생성
		}

		return userDAO;// 기존 ManagerDAO객체의 주소 리턴
	}

	/************************************************************/

	public void setConnection(Connection con) {// Connection객체를 받아 DB 연결
		this.con = con;
	}

	/*
	 * 로그인 폼에서 입력한 id와 pw가 담긴 ManagerTBL객체로 회원인지 조회 후 그 id를 반환 (단, '비밀번호를 암호화'하였다면
	 * 암호화된 비밀번호가 담긴 ManagerTBL객체)
	 */
	public String selectLoginId(ManagerTBL manager) {
		String loginId = null;

		// 암호화X - 사용자가 입력한 id와 비번을 가진 회원의 id를 조회
		String sql = "select manager_id from managerTBL where manager_id=? and manager_pwd=?";

		// 암호화O
		// String sql="select u_id, u_password from user_table where u_id=? and
		// u_password=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, manager.getManager_id());
			pstmt.setString(2, manager.getManager_pwd());
			rs = pstmt.executeQuery();

			// 암호화O
			if (rs.next()) {
				loginId = rs.getString("manager_id");// 방법-2

			}

		} catch (Exception e) {
			System.out.println("[ManagerDAO] selectLoginId 에러:" + e);// e:예외종류+예외메세지
		} finally {
			close(rs);
			close(pstmt);
		}
		return loginId;// 회원가입이 되어있으면 id를 리턴, 그렇지 않으면 null

	}// selectLoginId()

	// user_table안의 회원정보를 u_id로 조회하여 반환
		public ManagerTBL selectManagerInfo(String member_id) {
			ManagerTBL mangerInfo = null;
			// 사용자가 입력한 id 회원정보를 조회
			String sql = "select * from managerTBL where manager_id=?";

			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, member_id);
				rs = pstmt.executeQuery();

				if (rs.next()) {// 해당 id에 대한 정보가 있으면
					// 기본값으로 채워진 ManagerBean객체에 조회한 회원정보값으로 셋팅
					mangerInfo = new ManagerTBL();

					mangerInfo.setManager_id(rs.getString("manager_id"));
					mangerInfo.setManager_pwd(rs.getString("manager_pwd"));
					mangerInfo.setManager_email(rs.getString("manager_email"));
				}
			} catch (Exception e) {
				System.out.println("[ManagerDAO] selectManagerInfo 에러:" + e);// e:예외종류+예외메세지
			} finally {
				close(rs);
				close(pstmt);
			}

			return mangerInfo;
		}

	
	public int insertManager(ManagerTBL manager) {
		int insertManagerCount = 0;
		
		String sql2 = "select manager_id from managerTBL";
		// manager_code 세팅
		try {
			pstmt = con.prepareStatement(sql2);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if(manager.getManager_id().equals(rs.getString("manager_id"))) {
					
				}
			}

		} catch (Exception e) {
			System.out.println("[ManagerDAO] manager_id 불러오기 에러:" + e);
		} finally {
			System.out.println("manager.getManager_id() : " + manager.getManager_id());
			close(rs);
			close(pstmt);
		}

		// ----------------------------------------------------------------
		String sql = "insert into managerTBL(manager_id, manager_pwd,manager_email) values(?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, manager.getManager_id());
			pstmt.setString(2, manager.getManager_pwd());
			pstmt.setString(3, manager.getManager_email());

			insertManagerCount = pstmt.executeUpdate();// 업데이트를 성공하면 1을 리턴받음

		} catch (Exception e) {
			System.out.println("[ManagerDAO] insertManager 에러:" + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return insertManagerCount;
	}
}
