package com.zrt.gateway.api.client.vif;

public interface VifConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String VIF_INSTANCE = "vif";

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


}
