package cn.tarena.ht.pojo;

public class Module extends BaseEntity{
	private String moduleId;//模块id
	private Module parentModule;//上级模块信息
	private String name;//模块名称6
	private Integer ctype;//模块类型
	private Integer state;//状态1启用，0停用
	private Integer  orderNo;//排序号
	private String remark;//备注
	private Boolean checked;
	
	/*
	 * 为了ztree效果展现添加该方法
	 * */
	public String getId() {
		return moduleId;
	}
		
	public String getpId() {
		//有些模块没有上级模块
		if(parentModule==null){
			return "";
		}else{			
			return parentModule.getModuleId();
		}
	}
	
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public Module getParentModule() {
		return parentModule;
	}
	public void setParentModule(Module parentModule) {
		this.parentModule = parentModule;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCtype() {
		return ctype;
	}
	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	
	
}
