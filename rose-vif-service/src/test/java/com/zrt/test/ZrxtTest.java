package com.zrt.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Date;

import com.ronglian.ucsdk.model.ClientType;
import com.ronglian.ucsdk.model.FileIndexBean;
import com.ronglian.ucsdk.model.LoginBean;
import com.ronglian.ucsdk.model.MessageBean;
import com.ronglian.ucsdk.model.NodeBean;
import com.ronglian.ucsdk.model.ShareEvent;
import com.ronglian.ucsdk.service.SDKPersonalService;
import com.ronglian.ucsdk.service.SDKSearchService;
import com.ronglian.ucsdk.service.SDKShareEventService;
import com.ronglian.ucsdk.service.SDKUserService;
import com.ronglian.ucsdk.util.SDKConfigUtil;
import com.ronglian.ucsdk.util.SDKHttpUtil;

public class ZrxtTest {

	//管理员账号 122/123456
	public static void main(String[] args) throws Exception {
//		localFileUpload();
		
		//普通用户登录
		SDKUserService userService = new SDKUserService();
		MessageBean<LoginBean> loginBean = userService.login("008865", "123456",ClientType.WEB_APP, true);
		System.out.println(loginBean.getCode());
		if(0 != loginBean.getCode()){
			SDKHttpUtil.close();
			return;
		}
//		MessageBean<LoginBean> loginBean = userService.oaLogin("zmwang", ClientType.WEB_APP, true);
		
		String token = loginBean.getBody().getBean().getToken();
		String userId = loginBean.getBody().getBean().getUserId();
		String userRootNodeId = loginBean.getBody().getBean().getUserRootNodeId();
		System.out.println(userId + "\t" + token + "\t" + userRootNodeId);
		
//		String token = "9a09dcba9a4808cf8a8da3d62aaf4579";
		
//		SDKSearchService s = new SDKSearchService();
//		MessageBean<FileIndexBean> r = s.webSearch(token, "1", 1, 10, "all", true);
		
		SDKPersonalService s = new SDKPersonalService();
		MessageBean<NodeBean> r = s.getSubNodeListByParentNodeIdWithPage(token, 1, 100, "nodeId", false, "all", "", "", "", "", true);
		localFileUpload();
		if(null != r){
			System.out.println(r.toJson());
		}else{
			System.out.println("调用接口失败.");
		}
		
//		copyToVirtualUserAndShare(token);
		
		SDKHttpUtil.close();
	}
	
	//本地文件上传
	private static void localFileUpload() throws Exception{
		//用户登录(以管理员登录)-上传本地文件
		SDKUserService userService = new SDKUserService();
		MessageBean<LoginBean> loginBean = userService.oaLogin(SDKConfigUtil.VIRTUAL_USER, ClientType.WEB_APP, true);
		String token = loginBean.getBody().getBean().getToken();
		String userId = loginBean.getBody().getBean().getUserId();
		String userRootNodeId = loginBean.getBody().getBean().getUserRootNodeId();
		System.out.println(userId + "\t" + token + "\t" + userRootNodeId);
		
		//建立文件夹
		SDKPersonalService personalService = new SDKPersonalService();
		String dirName="zmwang";//以用户的登录账号在虚拟用户下建立文件夹
		MessageBean<NodeBean> mdBean = personalService.mkDir(token, userRootNodeId,dirName,true);
		String dirId = mdBean.getBody().getRows().get(0).getId();
		System.out.println("文件夹Id:"+dirId);
		
		//上传文件
		String fileName = "C:/Users/admin/Desktop/唐僧.jpg";//云盘sdk使用demo说明.docx
		File file = new File(fileName);
		String fileMD5 = null;//使用web端上传时此参数必须传null
		
		String d = new Date().getTime() + "";
		long size = file.length();

		InputStream in = new FileInputStream(file);
		
		String fn = URLEncoder.encode(file.getName(),"UTF-8");System.out.println("ddddddddddddddd:"+fileName);
		
		MessageBean<NodeBean> uploadNodeBean = personalService.uploadFileWebClient(token, dirId, d, fileMD5,fn, size, in);
		
//		MessageBean<NodeBean> uploadNodeBean = personalService.uploadFileOtherClient(token, dirId, fileName);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		String shareId = "";//要分享的id
		
//		if(uploadNodeBean.getCode() == 0){
//			System.out.println(fileName + "上传成功.");
//			shareId = uploadNodeBean.getBody().getBean().getId();
//		}else{
//			System.out.println(fileName + "上传失败:" + uploadNodeBean.getMsg());
//			if(null != uploadNodeBean.getMsg()){
//				if(uploadNodeBean.getMsg().equals("node_name_repeat")){
//					MessageBean<NodeBean> eBean = personalService.getSubNodeListByParentNodeIdWithPage(token, 1, 10, dirId, false,"all",null,file.getName(),null,null,true);
//					String eId = eBean.getBody().getRows().get(0).getId();
//					System.out.println("文件Id:" + eId);
//					shareId = eId;
//				}
//			}
//		}
		
		//链接分享
//		SDKShareEventService share = new SDKShareEventService();
//		MessageBean<ShareEvent> seBean = share.addShare(token, shareId, "", "分享:" + file.getName(), null, "url", "view,download", "", "", "","false",true);
//		ShareEvent se = seBean.getBody().getBean();
//		StringBuilder ret = new StringBuilder(100);
//		ret.append(SDKHttpUtil.getAppUrl()).append("/ucdisk/api/2.0/share/link/download?d=").append(System.currentTimeMillis());
//		ret.append("&shareEventId=").append(se.getId());
//		ret.append("&nodeId=").append(shareId);
//		ret.append("&code=");
//		
//		System.out.println("地址:"+ret);
	}
	
	//用户文件复制到虚拟账号再链接分享
	private static void copyToVirtualUserAndShare(String token) throws Exception{
		SDKPersonalService personalService = new SDKPersonalService();
		//8a8280925e2cfc72015e2d55c9c50002	8a82809e5e0e71ee015e0e7279570000
		MessageBean<ShareEvent> seBean = personalService.oaCopyAndShare(token,"8a8280925e2cfc72015e2d55c9c50002,8a82809e5e0e71ee015e0e7279570000", SDKConfigUtil.VIRTUAL_USER,"分享测试", true,true);
		System.out.println("地址:"+seBean.getBody().getBean().getUrl());
	}

}

