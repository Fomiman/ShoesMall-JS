package vo;

import java.util.Date;

public class User_board {
	private int post_no;
	private int member_code;
	private Date post_date;
	private String post_pwd;
	private String post_subject;
	private String post_text;
	private String post_file;
	
	public User_board() {
		super();
	}

	public User_board(int post_no, int member_code, Date post_date, String post_pwd, String post_subject,
			String post_text, String post_file) {
		super();
		this.post_no = post_no;
		this.member_code = member_code;
		this.post_date = post_date;
		this.post_pwd = post_pwd;
		this.post_subject = post_subject;
		this.post_text = post_text;
		this.post_file = post_file;
	}

	public int getPost_no() {
		return post_no;
	}

	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}

	public int getMember_code() {
		return member_code;
	}

	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}

	public Date getPost_date() {
		return post_date;
	}

	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}

	public String getPost_pwd() {
		return post_pwd;
	}

	public void setPost_pwd(String post_pwd) {
		this.post_pwd = post_pwd;
	}

	public String getPost_subject() {
		return post_subject;
	}

	public void setPost_subject(String post_subject) {
		this.post_subject = post_subject;
	}

	public String getPost_text() {
		return post_text;
	}

	public void setPost_text(String post_text) {
		this.post_text = post_text;
	}

	public String getPost_file() {
		return post_file;
	}

	public void setPost_file(String post_file) {
		this.post_file = post_file;
	}
	
	
	
}
