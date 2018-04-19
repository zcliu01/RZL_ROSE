package com.zrt.gateway.commons.dto;

public class EmpWorkMessage {

        //履历信息
	    private String createDateTime;//任职开始时间
	    
	    private String endDateTime;//任职结束时间
	    
	    private String pName;//职位
	    
	    private String orgName;//部门名称
	    
	    private String redeployContent;//工作变更详情

		@Override
		public String toString() {
			return "EmpWorkMessage [createDateTime=" + createDateTime + ", endDateTime=" + endDateTime + ", pName="
					+ pName + ", orgName=" + orgName + ", redeployContent=" + redeployContent + "]";
		}

		public String getCreateDateTime() {
			return createDateTime;
		}

		public void setCreateDateTime(String createDateTime) {
			this.createDateTime = createDateTime;
		}

		public String getEndDateTime() {
			return endDateTime;
		}

		public void setEndDateTime(String endDateTime) {
			this.endDateTime = endDateTime;
		}

		public String getPName() {
			return pName;
		}

		public void setPName(String pName) {
			this.pName = pName;
		}

		public String getOrgName() {
			return orgName;
		}

		public void setOrgName(String orgName) {
			this.orgName = orgName;
		}

		public String getRedeployContent() {
			return redeployContent;
		}

		public void setRedeployContent(String redeployContent) {
			this.redeployContent = redeployContent;
		}
	    
	  
	
}
