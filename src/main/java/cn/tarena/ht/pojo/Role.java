package cn.tarena.ht.pojo;

public class Role extends BaseEntity{
	private String roleId;//角色信息
	private String name;//角色名称
	private String remarks;//备注
	private Integer orderNo;//序号
	
	private Boolean checked;
	
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public String getRoleId() {
		return roleId;
	}
	//为了满足ztree数的要求，添加该方法
	public String getId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	
}
