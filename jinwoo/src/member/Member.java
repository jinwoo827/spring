package member;

import java.sql.Date;

public class Member {
	private String userId;
	private String userPwd;
	private String userName;
	private String userMsg;
	private Date userDate;
	private int userType;
	
	
	public Member(){}


	public Member(String userId, String userPwd, String userName, String userMsg, Date userDate, int userType) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userMsg = userMsg;
		this.userDate = userDate;
		this.userType = userType;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPwd() {
		return userPwd;
	}


	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserMsg() {
		return userMsg;
	}


	public void setUserMsg(String userMsg) {
		this.userMsg = userMsg;
	}


	public Date getUserDate() {
		return userDate;
	}


	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}


	public int getUserType() {
		return userType;
	}


	public void setUserType(int userType) {
		this.userType = userType;
	}


	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", userMsg=" + userMsg
				+ ", userDate=" + userDate + ", userType=" + userType + "]";
	}
	
	

	

}
