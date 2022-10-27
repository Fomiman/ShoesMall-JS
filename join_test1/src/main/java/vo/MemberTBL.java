package vo;

import java.sql.Date;

public class MemberTBL {
	//2. 멤버변수 접근제한자 : private
		private int member_code;
		private String member_id;
		private String member_pwd;
		private String member_name;
		private String member_birth;
		private String member_phone;
		private String member_email;
		private String member_gender;
		
		

		//3. 매개변수가 없는 생성자 : 기본생성자
		public MemberTBL() {
			super();
		}



		public MemberTBL(
				int member_code, String member_id, String member_pwd, 
				String member_name, String member_birth,
				String member_phone, String member_email, String member_gender
				) {
			super();
			this.member_code = member_code;
			this.member_id = member_id;
			this.member_pwd = member_pwd;
			this.member_name = member_name;
			this.member_birth = member_birth;
			this.member_phone = member_phone;
			this.member_email = member_email;
			this.member_gender = member_gender;
		}



		public int getMember_code() {
			return member_code;
		}



		public void setMember_code(int member_code) {
			this.member_code = member_code;
		}



		public String getMember_id() {
			return member_id;
		}



		public void setMember_id(String member_id) {
			this.member_id = member_id;
		}



		public String getMember_pwd() {
			return member_pwd;
		}



		public void setMember_pwd(String member_pwd) {
			this.member_pwd = member_pwd;
		}



		public String getMember_name() {
			return member_name;
		}



		public void setMember_name(String member_name) {
			this.member_name = member_name;
		}



		public String getMember_birth() {
			return member_birth;
		}



		public void setMember_birth(String member_birth) {
			this.member_birth = member_birth;
		}



		public String getMember_phone() {
			return member_phone;
		}



		public void setMember_phone(String member_phone) {
			this.member_phone = member_phone;
		}



		public String getMember_email() {
			return member_email;
		}



		public void setMember_email(String member_email) {
			this.member_email = member_email;
		}



		public String getMember_gender() {
			return member_gender;
		}



		public void setMember_gender(String member_gender) {
			this.member_gender = member_gender;
		}



		
		
} // class
