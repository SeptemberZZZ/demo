package cn.tarena.ht.pojo;

public class Module extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String moduleId;
	private Module parentModule;
	private String name;
	private Integer ctype;
	private Integer state;
	private Integer orderNo;
	private String remark;
	
	private Boolean checked;
	
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
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
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
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	
	public String getId(){
		return moduleId;
	}
	
	public String getpId(){
		if(parentModule!=null){
			return parentModule.getModuleId();
		}
		return "";
	}
}
