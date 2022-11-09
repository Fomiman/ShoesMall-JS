package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import vo.MemberTBL;

/**
 * [커넥션 풀 = Connection Pool] 교재 445P~ 고
 * Connection Potion 객체를 미리 생성하여 Pool에 저장
 * 필요할 때마다 이 Pool에 접근하여 Connection 객체를 사용한 후 다시 반환
 * 객체를 재생성하지 않기 때문에 프로그램 효율과 성능 증가
 */

public class ShoppingDAO {
	/*********************************************************************/
	// 1. 멤버변수(=feild) private
	/*********************************************************************/

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	private String sql = "";

	/*********************************************************************/
	// 2. 생성자 : 기본생성자 - 멤버변수에 기본값(수:0/0.0, boolean:false, 클래스타입:null)을 주어 객체 생성
	/*********************************************************************/

	/*********************************************************************/
	// 3. 메서드
	/*********************************************************************/
	public static Connection getConnection() throws Exception {
		/*------- 첫번째 방법 ----------*/
		// 1. 오라클 드라이버 로딩
		// Class.forName("oracle.jdbc.OracleDriver");
		// 2.Connection
		// Connection con =
		// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
		// "1234");
		// return con;

		/*********************************************************************/

		/*------- 두번째 방법 : 커넥션 풀 생성 ----------*/
		Connection con = null;

		try { //InitialContext에 마우스 올려보면 나오는 throws NamingException 처리
			Context init = new InitialContext(); // javax.naming
			
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}//getcon
	
	//1. 사용 회원번호와 가입일(=오늘날짜) 조회 : insert.jsp
	public MemberTBL getMaxCustnoJoindate(){
		MemberTBL beans = null;
		
		
		try {
			//1. DB 연결
			con = getConnection(); // con:멤버변수
			
			//2. sql
			sql ="select NVL(max(custno),0)+1 as custno,";
			sql+= " to_char(sysdate, 'yyyy-mm-dd') as joindate";
			sql+= " from member_tbl_02";
			
			//3. 실행
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			//4. 결과처리
			if(rs.next()) {
				beans = new MemberTBL();// 기본값으로 채워진 객체
				beans.setCustno(rs.getString("custno")); // 조회된 회원번호
				beans.setJoindate(rs.getString("joindate")); //조회된 날짜로 값 변경
			}else {
				System.out.println("sql문 결과 없음");
			}
			
		} catch (Exception e) {
			
			System.out.println("getMaxCustnoJoindate()에서 예외발생 : "+e);
			
		}finally {
			
			//5. 연결해제
			try{
				if(con != null) con.close();
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}//try ~ catch
		
		
		
		return beans;
	}//getMaxCustnoJoindate()
	
	
	//2.회원등록
	public int insertMember(MemberTBL beans){ //
		int result = 0 ;
		
		try {
			//1. DB 연결
			con = getConnection(); // con:멤버변수
			
			//2. sql
			sql="insert into member_tbl_02 values ( ?, ?, ?, ?, ?, ?, ?)";
			
			//3. 실행
			ps = con.prepareStatement(sql);
			ps.setString(1, beans.getCustno());
			ps.setString(2, beans.getCustname());
			ps.setString(3, beans.getPhone());
			ps.setString(4, beans.getAddress());
			ps.setString(5, beans.getJoindate());
			ps.setString(6, beans.getGrade().toUpperCase());
			ps.setString(7, beans.getCity());
			
			//4. 결과처리
			
			result = ps.executeUpdate(); //executeUpdate는 영향을 받는 row수를 int로 리턴 실패시 0리턴
			
		} catch (Exception e) {
			
			System.out.println("insertMember()에서 예외발생 : "+e);
			
		}finally {
			
			//5. 연결해제
			try{
				if(con != null) con.close();
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}//try ~ catch
		
		
		return result;
	}//insertMember
	
	
	//3. 회원전체조회 - selectmemberlist.jsp
	public ArrayList<MemberTBL> getMembers(){
		ArrayList<MemberTBL> memberList = new ArrayList<MemberTBL>();//기본값 null로 채워짐
		//반복분 안에 있으면 계속 새로 만들어지기 때문에 여기서 만들고 아래에서 사용

		try {
			//1. DB 연결
			con = getConnection(); // con:멤버변수
			
			//2. sql
			sql ="select CUSTNO,custname,PHONE,ADDRESS,JOINDATE,\r\n"
					+ " decode(GRADE, 'A', 'VIP', 'B', '일반', 'C', '직원') as grade,\r\n"
					+ " CITY from member_tbl_02 order by CUSTNO asc";
			
			//3. 실행
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			//4. 결과처리
			while(rs.next()) {
				
				MemberTBL beans = new MemberTBL(); // 기본값으로 채워진 beans 객체
				
				beans.setCustno(rs.getString("custno")); 
				beans.setCustname(rs.getString("custname"));
				beans.setPhone(rs.getString("phone"));
				beans.setAddress(rs.getString("address"));
				beans.setJoindate(rs.getString("joindate"));
				beans.setGrade(rs.getString("grade"));
				beans.setCity(rs.getString("city"));
				
				memberList.add(beans);
			}
			
		} catch (Exception e) {
			
			System.out.println("getMembers()에서 예외발생 : "+e);
			
		}finally {
			
			//5. 연결해제
			try{
				if(con != null) con.close();
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}//try ~ catch
		
		return memberList;
	}//getMembers
	
	//3-2. 회원매출조회 : selectmembersales.jsp
	public ArrayList<SalesBeans> getMembers2() {
		ArrayList<SalesBeans> List = new ArrayList<SalesBeans>();//기본값 null로 채워짐
		
		
		try {
			//1. DB 연결
			con = getConnection(); // con:멤버변수
			
			//2. sql
			sql = "";
			sql += " select custno , custname,";
			sql += " decode(GRADE, 'A', 'VIP', 'B', '일반', 'C', '직원') as grade, ";
			sql += " sum(price) as totalPrice";
			sql += " from member_tbl_02 join MONEY_TBL_02";
			sql += " using(custno)";
			sql += " group by custno, custname, grade";
			sql += " order by 4 desc";
			
			//3. 실행
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			//4. 결과처리
			while(rs.next()) {
				SalesBeans beans = new SalesBeans();// 기본값으로 채워진 객체
				beans.setCustno(rs.getString("custno")); // 조회된 회원번호
				beans.setCustname(rs.getString("custname")); //조회된 날짜로 값 변경
				beans.setGrade(rs.getString("grade")); //조회된 날짜로 값 변경
				beans.setTotalPrice(rs.getString("totalPrice")); //조회된 날짜로 값 변경
			
				List.add(beans);
			}
			
		} catch (Exception e) {
			
			System.out.println("getMembers2()에서 예외발생 : "+e);
			
		}finally {
			
			//5. 연결해제
			try{
				if(con != null) con.close();
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}//try ~ catch
		
		
		
		return List;
	}//getMembers2
	
	//4. 회원조회 : 회원번호를 매개값으로 받아 조회한 회원객체를 리턴
	public MemberTBL selectMember(String custno) {
		
		MemberTBL beans = null;
		
		try {
			//1. DB 연결
			con = getConnection(); // con:멤버변수
			
			//2. sql
			sql="select custno, custname, phone,address,\r\n"
					+ " TO_CHAR(joindate, 'yyyy-mm-dd') as joindate,\r\n"
					+ " grade,\r\n"
					+ " city\r\n"
					+ " from member_tbl_02\r\n"
					+ " where custno = "+custno;
			
			//3. 실행
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			//4. 결과처리
			if(rs.next()) {
				beans = new MemberTBL();
				
				beans.setCustno(rs.getString("custno"));
				beans.setCustname(rs.getString("custname"));
				beans.setPhone(rs.getString("phone"));
				beans.setAddress(rs.getString("address"));
				beans.setJoindate(rs.getString("joindate"));
				beans.setGrade(rs.getString("grade").toUpperCase());
				beans.setCity(rs.getString("city"));
			}else {
				System.out.println("selectMember() 결과없음");
			}
			
		} catch (Exception e) {
			
			System.out.println("selectMember()에서 예외발생 : "+e);
			
		}finally {
			
			//5. 연결해제
			try{
				if(con != null) con.close();
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}//try ~ catch
		
		return beans;
	}//selectMember
	
	
	//5. 회원수정 : updateDeletePro.jsp
	public int updateMember(MemberTBL beans){ 
		int result = 0 ;
		
		try {
			//1. DB 연결
			con = getConnection(); // con:멤버변수
			
			//2. sql
			sql="update member_tbl_02 ";
			sql+=" set custno=?, custname=?, phone=?, address=?, joindate=?, grade=?, city=? where custno="+beans.getCustno();
			
			//3. 실행
			ps = con.prepareStatement(sql);
			ps.setString(1, beans.getCustno());
			ps.setString(2, beans.getCustname());
			ps.setString(3, beans.getPhone());
			ps.setString(4, beans.getAddress());
			ps.setString(5, beans.getJoindate());
			ps.setString(6, beans.getGrade());
			ps.setString(7, beans.getCity());
			//ps.setString(8, beans.getCustno());
			
			//4. 결과처리
			
			result = ps.executeUpdate(); //executeUpdate는 영향을 받는 row수를 int로 리턴 실패시 0리턴
			
		} catch (Exception e) {
			
			System.out.println("updateMember()에서 예외발생 : "+e);
			
		}finally {
			
			//5. 연결해제
			try{
				if(con != null) con.close();
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}//try ~ catch
		
		
		return result;
	}//updateMember
	
	//6. 회원삭제 : : updateDeletePro.jsp
	public int deleteMember(String custno){ 
		int result = 0 ;
		
		try {
			//1. DB 연결
			con = getConnection(); // con:멤버변수
			
			//2. sql
			sql="delete from MEMBER_TBL_02 where custno = "+custno ;
			
			//3. 실행
			ps = con.prepareStatement(sql);
			
			//4. 결과처리
			
			result = ps.executeUpdate(); //executeUpdate는 영향을 받는 row수를 int로 리턴 실패시 0리턴
			
		} catch (Exception e) {
			
			System.out.println("deleteMember()에서 예외발생 : "+e);
			
		}finally {
			
			//5. 연결해제
			try{
				if(con != null) con.close();
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}//try ~ catch
		
		
		return result;
	}//deleteMember
	
	
	
}
