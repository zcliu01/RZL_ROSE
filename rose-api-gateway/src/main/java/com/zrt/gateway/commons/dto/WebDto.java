package com.zrt.gateway.commons.dto;


public class WebDto {

	//员工编号
	private String empCode;
	
	//姓名
	private String empName;
	
	//部门
	private  String  orgName;
	
	//岗位 
	private  String pName;
	
	//入职时间
	private  String   entryTime;
	
	//首次入职时间
	private  String  createDateTime;
	
	//工作地点
	private  String  empWorkAddress;
	
	//邮箱
	private  String  empEmail;
	
	//性别
	private  String  empSex;
	
    public WebDto(String empCode, String empName, String orgName, String pName, String entryTime, String createDateTime,
			String empWorkAddress, String empEmail, String empSex) {
		super();
		this.empCode = empCode;
		this.empName = empName;
		this.orgName = orgName;
		this.pName = pName;
		this.entryTime = entryTime;
		this.createDateTime = createDateTime;
		this.empWorkAddress = empWorkAddress;
		this.empEmail = empEmail;
		this.empSex = empSex;
	}

	public WebDto() {}

  
    @Override
	public String toString() {
		return "WebDto [empCode=" + empCode + ", empName=" + empName + ", orgName=" + orgName + ", pName=" + pName
				+ ", entryTime=" + entryTime + ", createDateTime=" + createDateTime + ", empWorkAddress="
				+ empWorkAddress + ", empEmail=" + empEmail + ", empSex=" + empSex + "]";
	}
    
    
	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	 
	
	public String getPName() {
		return pName;
	}

	public void setPName(String pName) {
		this.pName = pName;
	}

	
	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}

	
	public String getEmpWorkAddress() {
		return empWorkAddress;
	}

	public void setEmpWorkAddress(String empWorkAddress) {
		this.empWorkAddress = empWorkAddress;
	}

	
	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	

	public String getEmpSex() {
		return empSex;
	}

	public void setEmpSex(String empSex) {
		if("F".equals(empSex)){
			this.empSex = "女";
		}else if("M".equals(empSex)){
			this.empSex = "男";
		}
		
	}

	
   
}