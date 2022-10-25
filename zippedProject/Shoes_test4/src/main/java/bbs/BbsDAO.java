package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BbsDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BbsDAO() {
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
	
	public String getDate() {
		String sql="select now()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			}catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public int getNext() {
		String sql="select member_id from user_board order by member_id desc";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1)+1;
			}
			return 1;//첫번째 게시물인경우
			}catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int write (int post_no, String post_date, String post_pw,String post_subject, String post_id, String post_text) {
		String sql="insert into user_board values(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, post_no);
			pstmt.setString(2, post_id);
			pstmt.setString(3, post_date);
			pstmt.setString(4, post_pw);
			pstmt.setString(5, post_subject);
			pstmt.setString(6, post_text);
			rs=pstmt.executeQuery();
			return pstmt.executeUpdate();
			
			}catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public ArrayList<Bbs> getList(int pageNumber){
		String sql="select * from user_board LIMIT 10";
		ArrayList<Bbs> list = new ArrayList<Bbs>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext() -(pageNumber -1)*10);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Bbs bbs=new Bbs();
				bbs.setPost_no(rs.getInt(1));
				bbs.setPost_id(rs.getString(2));
				bbs.setPost_date(rs.getString(3));
				bbs.setPost_pw(rs.getString(4));
				bbs.setPost_subject(rs.getString(5));
				bbs.setPost_text(rs.getString(6));
				list.add(bbs);
			}
			}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean nextPage(int pageNumber) {
		String sql="select * from user_board LIMIT 10";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext() -(pageNumber -1)*10);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public Bbs getBbs(int post_id ) {
		String sql="select * from user_board where post_id =?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, post_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				Bbs bbs=new Bbs();
				bbs.setPost_no(rs.getInt(1));
				bbs.setPost_id(rs.getString(2));
				bbs.setPost_date(rs.getString(3));
				bbs.setPost_pw(rs.getString(4));
				bbs.setPost_subject(rs.getString(5));
				bbs.setPost_text(rs.getString(6));
				return bbs;
			}
			}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	}
	
	
	
	
	
	
	
	
