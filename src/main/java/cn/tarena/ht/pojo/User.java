package cn.tarena.ht.pojo;

public class User extends BaseEntity{
	private UserInfo userInfo;//封装用户扩展信息
	
	private Dept dept;//封装部门对象，一对一
	private String userId;
	private String username;
	private String password;
	private String state;
//	private String CREATE_BY;
//	private String CREATE_DEPT;
//	private String CREATE_TIME;
//	private String UPDATE_BY;
//	private String UPDATE_TIME;
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "User [userInfo=" + userInfo + ", userId=" + userId + ", dept=" + dept + ", username=" + username
				+ ", password=" + password + ", state=" + state + ", getUserInfo()=" + getUserInfo() + ", getUserId()="
				+ getUserId() + ", getDept()=" + getDept() + ", getUsername()=" + getUsername() + ", getPassword()="
				+ getPassword() + ", getState()=" + getState() + ", getCreateBy()=" + getCreateBy()
				+ ", getCreateDept()=" + getCreateDept() + ", getCreateTime()=" + getCreateTime() + ", getUpdateBy()="
				+ getUpdateBy() + ", getUpdateTime()=" + getUpdateTime() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
