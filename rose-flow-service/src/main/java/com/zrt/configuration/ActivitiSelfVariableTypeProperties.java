package com.zrt.configuration;

import java.io.Serializable;


/**
 * 自定义数据类型
 * @author wwfu
 *
 */
public class ActivitiSelfVariableTypeProperties implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//上一节点id
	private String sourceRef;
	
	public ActivitiSelfVariableTypeProperties(String sourceRef){
		this.sourceRef=sourceRef;
	}

	public String getSourceRef() {
		return sourceRef;
	}

	public void setSourceRef(String sourceRef) {
		this.sourceRef = sourceRef;
	}
	
	
	
	
	
	
}
