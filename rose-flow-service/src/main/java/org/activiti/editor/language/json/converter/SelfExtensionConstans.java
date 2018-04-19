package org.activiti.editor.language.json.converter;

/**
 * 扩展属性值
 * @author wwfu
 *
 */
public class SelfExtensionConstans {
	/**
	 * 扩展属性**/
	public static String EXTENSION_ELEMENT_OPERATIONS="selfProperties";
     /**是否提醒**/
	public static String USER_TASK_ISREMIND="isremind";
	 /**提醒方式(0:IM,1:邮件,2:内部讯息) **/
	public static String USER_TASK_REMINDTYPE="remindtype";
	 /**提醒周期**/
	public static String USER_TASK_REMINDCYCLE="remindcycle";
	 /**流程规则**/
	public static String USER_TASK_FBRULE="fbrule";
	 /**是否提前审批**/
	public static String USER_TASK_ISADVANCE="isadvance";
	 /**
	  * 讯息接收人**/
	public static String USER_TASK_RECEIVERIDS="receiverids";
	 /**是否通知流程所有人**/
	public static String USER_TASK_ISNOTIFY="isnotify";
	 /**通知方式(0:IM,1:邮件,2:内部讯息)**/
	public static String USER_TASK_NOTIFYTYPE="notifytype";
	/***主分管(0:发起人主管,1:发起人分管,2:前一审批人主管,3:前一审批人分管)**/
	public static String USER_TASK_UPMANAGE="upmanage";
	/***是否支持指定审批人0：否，1：是**/
	public static String USER_TASK_ISASSIGNEE="isassignee";
	
	
	
	/**
	 * 自定义规则
	 */
	public static String FB_EXPRESSION="fbexpression";
	
}
