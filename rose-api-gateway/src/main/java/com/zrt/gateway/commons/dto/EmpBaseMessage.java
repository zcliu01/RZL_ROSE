package com.zrt.gateway.commons.dto;

public class EmpBaseMessage {

	//基本信息
	
	    private String empCode;

	    private String empName;
	    
	    private String upEmpName;//直接上级名称
	    
	    private String empBirthday;
	    
	    private String empSex;

	    private String empPhone;

	    private String empMobilePhone;

	    private String empFax;

	    private String empEmail;

	    private String empPostcode;//邮编

	    private String empAddress;

	    private String empWorkAddress;

	    private String createDateTime;//首次入职时间

	    private String entryTime;//入职时间

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

		public String getUpEmpName() {
			return upEmpName;
		}

		public void setUpEmpName(String upEmpName) {
			this.upEmpName = upEmpName;
		}

		public String getEmpBirthday() {
			return empBirthday;
		}

		public void setEmpBirthday(String empBirthday) {
			this.empBirthday = empBirthday;
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

		public String getEmpPhone() {
			return empPhone;
		}

		public void setEmpPhone(String empPhone) {
			this.empPhone = empPhone;
		}

		public String getEmpMobilePhone() {
			return empMobilePhone;
		}

		public void setEmpMobilePhone(String empMobilePhone) {
			this.empMobilePhone = empMobilePhone;
		}

		public String getEmpFax() {
			return empFax;
		}

		public void setEmpFax(String empFax) {
			this.empFax = empFax;
		}

		public String getEmpEmail() {
			return empEmail;
		}

		public void setEmpEmail(String empEmail) {
			this.empEmail = empEmail;
		}

		public String getEmpPostcode() {
			return empPostcode;
		}

		public void setEmpPostcode(String empPostcode) {
			this.empPostcode = empPostcode;
		}

		public String getEmpAddress() {
			return empAddress;
		}

		public void setEmpAddress(String empAddress) {
			this.empAddress = empAddress;
		}

		public String getEmpWorkAddress() {
			return empWorkAddress;
		}

		public void setEmpWorkAddress(String empWorkAddress) {
			this.empWorkAddress = empWorkAddress;
		}

		public String getCreateDateTime() {
			return createDateTime;
		}

		public void setCreateDateTime(String createDateTime) {
			this.createDateTime = createDateTime;
		}

		public String getEntryTime() {
			return entryTime;
		}

		public void setEntryTime(String entryTime) {
			this.entryTime = entryTime;
		}


	
}
