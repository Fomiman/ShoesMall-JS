package vo;

public class MangerTBL {
	private String manager_id;
	private String manger_pwd;
	private String manger_email;
	public MangerTBL() {
		super();
	}
	public MangerTBL(String manager_id, String manger_pwd, String manger_email) {
		super();
		this.manager_id = manager_id;
		this.manger_pwd = manger_pwd;
		this.manger_email = manger_email;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getManger_pwd() {
		return manger_pwd;
	}
	public void setManger_pwd(String manger_pwd) {
		this.manger_pwd = manger_pwd;
	}
	public String getManger_email() {
		return manger_email;
	}
	public void setManger_email(String manger_email) {
		this.manger_email = manger_email;
	}
	
	
}
