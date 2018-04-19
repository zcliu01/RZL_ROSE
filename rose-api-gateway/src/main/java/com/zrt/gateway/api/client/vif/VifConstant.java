package com.zrt.gateway.api.client.vif;

public interface VifConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String VIF_INSTANCE = "vif12";

	/** 上传文件 */
	String UPLOAD_SINGLE_FILE = "/v1.0/filemanager/uploadSingleFile";
	/** 上传文件并分享 */
	String UPLOAD_AND_SHARE = "/v1.0/filemanager/uploadAndShare";
	/** 云盘登陆 */
	String LOGIN = "/v1.0/filemanager/login";
	/** 查询云盘文件 */
	String FILE_LIST = "/v1.0/filemanager/fileList";
	/** 删除云盘文件 */
	String DELETE_FILE = "/v1.0/filemanager/deleteFile";

	/** 下载云盘文件 */
	String DOWNLOAD_FILE = "/v1.0/filemanager/downloadFile";

	String COPY_FILE = "/v1.0/filemanager/copyFile";
	
	
	/** 批量下载的分享 */
	String SHARE = "/v1.0/filemanager/share";
	
	
	/** 首页获取tcmp待办任务条数 */
	String INDEX_COUNT = "/v1.0/tcmp/indexCount";
	
	
	
	/** TCMP推送代办流程到OA */
	String TCMP_WAITDEAL = "/v1.0/oaToTcmp/waitDeal";
	
	/** TCMP推送已办任务到OA*/
	String TCMP_DEALCOMPLETE = "/v1.0/oaToTcmp/dealComplete";
	
	/** TCMP推送结束流程到OA */
	String TCMP_FLOWEND = "/v1.0/oaToTcmp/flowEnd";


}
