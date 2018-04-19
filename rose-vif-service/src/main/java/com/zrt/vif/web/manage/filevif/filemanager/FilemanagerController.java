package com.zrt.vif.web.manage.filevif.filemanager;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.ronglian.ucsdk.model.ClientType;
import com.ronglian.ucsdk.model.LoginBean;
import com.ronglian.ucsdk.model.MessageBean;
import com.ronglian.ucsdk.model.NodeBean;
import com.ronglian.ucsdk.model.ShareEvent;
import com.ronglian.ucsdk.service.SDKPersonalService;
import com.ronglian.ucsdk.service.SDKShareEventService;
import com.ronglian.ucsdk.service.SDKUserService;
import com.ronglian.ucsdk.util.SDKConfigUtil;
import com.ronglian.ucsdk.util.SDKHttpUtil;
import com.zrt.commons.cons.Constants;
import com.zrt.commons.date.DateUtil;
import com.zrt.commons.sign.Base64;
import com.zrt.vif.service.redis.RedisService;

/**
 * Created by dwliu on 2017/9/27.
 */
@RestController
@RequestMapping(value = "/v1.0/filemanager")
public class FilemanagerController {
    private static final Logger log = LoggerFactory.getLogger(FilemanagerController.class);

    @Autowired
    private RedisService redisService;

    /**
     * 上传文件
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/uploadSingleFile", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> uploadSingleFile(@RequestBody Map<String, Object> appMap) throws Exception {
        log.info("FileController中uploadSingleFile方法");
        Map<String, Object> resultMap = new HashMap<String, Object>();
        byte[] fileByte = Base64.decode((String) appMap.get("file_upload"));
        //文件名称
        String fileName = (String) appMap.get("file_name");
        long totalbytes = fileByte.length;
        Map<String, Object> redisInfo = redisService.getInfo(Constants.UCDISK_VIR_LOGIN_INFO, SDKConfigUtil.VIRTUAL_USER);
//        Map<String, Object> redisInfo = redisService.getInfo(Constants.UCDISK_WEB_LOGIN_INFO, (String) appMap.get("emp_id"));
        String token = (String) redisInfo.get("token");
        String userRootNodeId = (String) redisInfo.get("userRootNodeId");
        //建立文件夹
        String d = DateUtil.getCurrentDateTime();
        String dd = d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8);
        String ddd = d.substring(8, 10)+"-"+d.substring(10, 12)+"-"+d.substring(12, 14);
        SDKPersonalService personalService = new SDKPersonalService();
//        String dirName = "shareDir";//以用户的登录账号在虚拟用户下建立文件夹
        String dirName = (String) appMap.get("emp_id")+"/"+dd+"/"+ddd;//以用户的登录账号在虚拟用户下建立文件夹
        MessageBean<NodeBean> mdBean = personalService.mkDir(token, userRootNodeId, dirName, true);
        String dirId = "";
        if (mdBean.getBody().getRows().size() > 0) {
            dirId = mdBean.getBody().getRows().get(2).getId();//文件夹ID
        }
        String result;
        String filename = URLEncoder.encode(fileName, "UTF-8");
        //上传文件
        //InputStream input = new ByteArrayInputStream(fileByte);
        ByteArrayInputStream  input = new ByteArrayInputStream(fileByte);
        MessageBean<NodeBean> uploadNodeBean;
        if (filename.contains(".")) {
            uploadNodeBean = personalService.uploadFileWebClient(token, dirId, d, null, filename.substring(0, filename.lastIndexOf("."))  + filename.substring(filename.lastIndexOf(".")), totalbytes, input);
        } else {
            uploadNodeBean = personalService.uploadFileWebClient(token, dirId, d, null, filename, totalbytes, input);
        }
        
        
        Map<String, Object> dataMap = new HashMap<>();
        if (uploadNodeBean.getCode() == 0) {
            result = filename + "上传成功.";
            resultMap.put("result", true);
            String shareId = uploadNodeBean.getBody().getBean().getId();
//            MessageBean<ShareEvent> seBean = personalService.oaCopyAndShare(token,shareId, SDKConfigUtil.VIRTUAL_USER,"分享测试", true,true);
            SDKShareEventService share = new SDKShareEventService();
            MessageBean<ShareEvent> seBean = share.addShare(token, shareId, "", "分享:" + fileName, null, "url", "view,download", "", "", "", "false", true);
            dataMap.put("fileUrl", seBean.getBody().getBean().getUrl());
            dataMap.put("nodeId", shareId+"&"+seBean.getBody().getBean().getId());
            //关闭后不能重复上传文件
            dataMap.put("adminToken",token);
            dataMap.put("filename",fileName);
            resultMap.put("data", dataMap);
        } else {
            result = filename + "上传失败:" + uploadNodeBean.getMsg();
            resultMap.put("result", false);
            resultMap.put("errmsg", result);
        }
        return resultMap;
    }


    /**
     * 上传文件并分享
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/uploadAndShare", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> uploadAndShare(@RequestBody Map<String, Object> appMap) throws Exception {
        log.info("FileController中uploadAndShare方法");
        Map<String, Object> resultMap = new HashedMap();
        byte[] fileByte = Base64.decode((String) appMap.get("file_upload"));
        //文件名称
        String fileName = (String) appMap.get("file_name");
        long totalbytes = fileByte.length;
        Map<String, Object> redisInfo = redisService.getInfo(Constants.UCDISK_VIR_LOGIN_INFO, SDKConfigUtil.VIRTUAL_USER);
        String token = (String) redisInfo.get("token");
        String userRootNodeId = (String) redisInfo.get("userRootNodeId");

        //建立文件夹
        SDKPersonalService personalService = new SDKPersonalService();
        String dirName = "shareDir";//以用户的登录账号在虚拟用户下建立文件夹

        MessageBean<NodeBean> mdBean = personalService.mkDir(token, userRootNodeId, dirName, true);
        String dirId = mdBean.getBody().getRows().get(0).getId();//文件夹ID
        String result;
        //上传文件
        String filename = URLDecoder.decode(fileName, "UTF-8");
        InputStream input = new ByteArrayInputStream(fileByte);
        String d = DateUtil.getCurrentDateTime();
        MessageBean<NodeBean> uploadNodeBean;
        if (filename.contains(".")) {
            uploadNodeBean = personalService.uploadFileWebClient(token, dirId, d, null, filename.substring(0, filename.lastIndexOf(".")) , totalbytes, input);
        } else {
            uploadNodeBean = personalService.uploadFileWebClient(token, dirId, d, null, filename , totalbytes, input);
        }
        Map<String, Object> dataMap = new HashMap<>();
        if (uploadNodeBean.getCode() == 0) {
            result = filename + "上传成功.";
            String shareId = uploadNodeBean.getBody().getBean().getId();
            resultMap.put("result", true);
            dataMap.put("fileUrl", SDKHttpUtil.getAppUrl() + "/ucdisk/api/2.0/file/download?nodeId=" + shareId + "&d=" + System.currentTimeMillis());
            dataMap.put("nodeId", shareId);

            //链接分享
            SDKShareEventService share = new SDKShareEventService();
            MessageBean<ShareEvent> seBean = share.addShare(token, shareId, "", "分享:" + filename, null, "url", "view,download", "", "", "", "false", true);
            System.out.println("地址:" + seBean.getBody().getBean().getUrl());
            ShareEvent se = seBean.getBody().getBean();
            StringBuilder ret = new StringBuilder(100);
            ret.append(SDKHttpUtil.getAppUrl()).append("/ucdisk/api/2.0/share/link/download?d=").append(System.currentTimeMillis());
            ret.append("&shareEventId=").append(se.getId());
            ret.append("&nodeId=").append(shareId);
            ret.append("&code=");
            dataMap.put("shareUrl", ret);
//            SDKHttpUtil.close();
            resultMap.put("data", dataMap);
        } else {
            result = filename + "上传失败:" + uploadNodeBean.getMsg();
            resultMap.put("result", false);
            resultMap.put("errmsg", result);
        }
        log.info(result);
        return resultMap;
    }


    /**
     * 云盘登陆
     *
     * @param appMap
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> login(@RequestBody Map<String, Object> appMap) throws Exception {
        Map<String, Object> resultMap = new HashedMap();
        SDKUserService userService = new SDKUserService();
        try {
        	 log.info("----ucdisk login begin--");
            MessageBean<LoginBean> emp_loginBean = userService.oaLogin((String) appMap.get("emp_id"), ClientType.WEB_APP, true);
            log.info("----emp_loginBean--"+emp_loginBean.getBody().getBean().getToken());
            //先判断虚拟账号是否登录过，如果登录过就不登录了，防止踢掉原有的token
            Map<String, Object> redisInfo = redisService.getInfo(Constants.UCDISK_VIR_LOGIN_INFO, SDKConfigUtil.VIRTUAL_USER);
          //虚拟账号token
            String vir_token=null;
          //虚拟账号根节点
            String vir_root_node_id=null;
            if(redisInfo!=null && !redisInfo.isEmpty()){
            	//虚拟账号token
                vir_token=(String)redisInfo.get("token");
                //虚拟账号根节点
                vir_root_node_id=(String)redisInfo.get("userRootNodeId");
            }else{
                MessageBean<LoginBean> virtual_loginBean = userService.oaLogin(SDKConfigUtil.VIRTUAL_USER, ClientType.WEB_APP, true);
                vir_token=virtual_loginBean.getBody().getBean().getToken();
                vir_root_node_id=virtual_loginBean.getBody().getBean().getUserRootNodeId();
                //把虚拟账号的信息放到缓存中
                Map<String, Object> redisMap=new HashMap<String, Object>();
                redisMap.put("token", vir_token);
                redisMap.put("userRootNodeId", vir_root_node_id);
                redisService.setInfo(Constants.UCDISK_VIR_LOGIN_INFO, SDKConfigUtil.VIRTUAL_USER, redisMap,110,TimeUnit.MINUTES);
            }
            

            resultMap.put("result", true);
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("token", vir_token);
            dataMap.put("emp_token", emp_loginBean.getBody().getBean().getToken());
            dataMap.put("userRootNodeId", vir_root_node_id);
            dataMap.put("emp_userRootNodeId", emp_loginBean.getBody().getBean().getUserRootNodeId());
            resultMap.put("data", dataMap);
        } catch (Exception e) {
        	log.error("---------ucdisk login error------"+e);
            resultMap.put("result", false);
            resultMap.put("errmsg", e.getMessage());
        }
        return resultMap;
    }


    /**
     * 查询云盘文件
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/searchFile", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> searchFile(@RequestBody Map<String, Object> appMap, @CookieValue String emp_id) throws Exception {
        log.info("FileController中searchFile方法");
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String pageNumber = "1";
        String pageSize = "10";
        if (null != appMap.get("pageNumber")) {
            pageNumber = (String) appMap.get("pageNumber");
        }
        if (null != appMap.get("pageSize")) {
            pageSize = (String) appMap.get("pageSize");
        }
        String keyword = (String) appMap.get("file_name");
//        Map<String, Object> redisInfo = redisService.getInfo(Constants.UCDISK_WEB_LOGIN_INFO, (String) appMap.get("emp_id"));
        Map<String, Object> redisInfo = redisService.getInfo(Constants.UCDISK_VIR_LOGIN_INFO, SDKConfigUtil.VIRTUAL_USER);
        String token = (String) redisInfo.get("token");
        RestTemplate template = new RestTemplate();
        String forObject = template.postForObject(SDKHttpUtil.getAppUrl() + "/ucdisk/api/2.0/solr/websearch?searchType=all&pageNumber="
                + pageNumber + "&pageSize=" + pageSize + "&token=" + token + "&keyword=" + keyword, null, String.class);
        Map<String, Object> map = (Map<String, Object>) JSON.parse(forObject);
        String result = (String) map.get("body");
        resultMap.put("result", result);
        return resultMap;
    }

    /**
     * 查询云盘文件(在个人文档中获取某个节点下的节点列表)
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/fileList", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> fileList(@RequestBody Map<String, Object> appMap) throws Exception {
        log.info("FileController中fileList方法");
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String pageNumber = "1";
        String pageSize = "10";
        if (null != appMap.get("pageNumber")) {
            pageNumber =  appMap.get("pageNumber").toString();
        }
        if (null != appMap.get("pageSize")) {
            pageSize = appMap.get("pageSize").toString();
        }
        String keyword = (String) appMap.get("file_name");
        if (null==keyword) {
			keyword="";
		}
        Map<String, Object> redisInfo = redisService.getInfo(Constants.UCDISK_WEB_LOGIN_INFO, (String) appMap.get("emp_id"));
        String token = (String) redisInfo.get("emp_token");
        String userRootNodeId;
        if (null == appMap.get("nodeId") || appMap.get("nodeId").equals("")) {
            userRootNodeId = (String) redisInfo.get("emp_userRootNodeId");
        } else {
            userRootNodeId = (String) appMap.get("nodeId");
        }
      //  RestTemplate template = new RestTemplate();
        Map<String, Object> listMap = new HashMap<String, Object>();
        SDKPersonalService s = new SDKPersonalService();
        try {
            /*String forObject = template.postForObject(SDKHttpUtil.getAppUrl() + "/ucdisk/api/2.0/node/list?type=all&subonly=true&pageNumber="
                    + pageNumber + "&pageSize=" + pageSize + "&token=" + token + "&keyword=" + keyword + "&nodeId=" + userRootNodeId, null, String.class);*/
        	MessageBean<NodeBean> r = s.getSubNodeListByParentNodeIdWithPage(token, Integer.parseInt(pageNumber), Integer.parseInt(pageSize),userRootNodeId , true, "all", "", keyword, "", "", true);
        //Map<String, Object> map = (Map<String, Object>) JSON.parse(forObject);
          Map<String, Object> map = (Map<String, Object>) JSON.parse(r.toJson());
            Map<String, Object> bodyMap = (Map<String, Object>) map.get("body");
            List<Map<String, Object>> rowsMap = (List<Map<String, Object>>) bodyMap.get("rows");
           for (Map<String, Object> temp : rowsMap) {
        	   temp.put("fileUrl", SDKHttpUtil.getAppUrl() + "/ucdisk/api/2.0/file/download?pos=0&token=" + token + "&nodeId=" + temp.get("id"));
        	if (!((String)temp.get("parentId")).isEmpty()) {
        		temp.put("parent_org_id", (String)temp.get("parentId"));
			}else {
				temp.put("parent_org_id", "-1");
			}
		}
            resultMap.put("result", true);
            resultMap.put("count", bodyMap.get("total"));
            listMap.put("list", rowsMap);
           resultMap.put("data", bodyMap.get("rows"));
          // resultMap.put("data", listMap);
        } catch (RestClientException e) {
            resultMap.put("result", false);
            resultMap.put("errmsg", e.getMessage());
        }
        return resultMap;
    }

    /**
     * 删除云盘文件
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/deleteFile", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> deleteFile(@RequestBody Map<String, Object> appMap) throws Exception {
        log.info("FileController中deleteFile方法");
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String nodeId = (String) appMap.get("nodeId");
//        Map<String, Object> redisInfo = redisService.getInfo(Constants.UCDISK_WEB_LOGIN_INFO, (String) appMap.get("emp_id"));
        Map<String, Object> redisInfo = redisService.getInfo(Constants.UCDISK_VIR_LOGIN_INFO, SDKConfigUtil.VIRTUAL_USER);
        String token = (String) redisInfo.get("token");
        RestTemplate template = new RestTemplate();
        try {
            template.postForObject(SDKHttpUtil.getAppUrl() + "/ucdisk/api/2.0/node/delete?token=" + token + "&nodeId=" + nodeId, null, String.class);
            resultMap.put("result", true);
        } catch (RestClientException e) {
            resultMap.put("result", false);
            resultMap.put("errmsg", e.getMessage());
        }
        return resultMap;
    }

    /**
     * 删除云盘文件
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/downloadFile", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> downloadFile(@RequestBody Map<String, Object> appMap) throws Exception {
        log.info("FileController中downloadFile方法");
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String nodeId = (String) appMap.get("nodeId");
//        Map<String, Object> redisInfo = redisService.getInfo(Constants.UCDISK_WEB_LOGIN_INFO, (String) appMap.get("emp_id"));
        Map<String, Object> redisInfo = redisService.getInfo(Constants.UCDISK_VIR_LOGIN_INFO, SDKConfigUtil.VIRTUAL_USER);
        String token = (String) redisInfo.get("token");
        RestTemplate template = new RestTemplate();
        try {
            Map<String, Object> dataMap = new HashMap<>();
            byte[] forObject = template.getForObject(SDKHttpUtil.getAppUrl() + "/ucdisk/api/2.0/file/download?pos=0&token=" + token + "&nodeId=" + nodeId, byte[].class);
            dataMap.put("fileStream", forObject);
            resultMap.put("data", dataMap);
            resultMap.put("result", true);
        } catch (RestClientException e) {
            resultMap.put("result", false);
            resultMap.put("errmsg", e.getMessage());
        }
        return resultMap;
    }

    /**
     * 拷贝私有云盘文件到公共区域
     *
     * @return
     * @throws Exception
     */
 /*   @RequestMapping(value = "/copyFile", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> copyFile(@RequestBody Map<String, Object> appMap) throws Exception {
        log.info("FileController中copyFile方法");
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String nodeId = (String) appMap.get("nodeId");
//        Map<String, Object> redisInfo = redisService.getInfo(Constants.UCDISK_WEB_LOGIN_INFO, (String) appMap.get("emp_id"));
        Map<String, Object> redisInfo = redisService.getInfo(Constants.UCDISK_VIR_LOGIN_INFO, SDKConfigUtil.VIRTUAL_USER);
        String token = (String) redisInfo.get("token");
        try {
            SDKPersonalService personalService = new SDKPersonalService();
            personalService.oaCopyAndShare(token,nodeId, SDKConfigUtil.VIRTUAL_USER,"分享测试", true,true);
            resultMap.put("result", true);
        } catch (RestClientException e) {
            resultMap.put("result", false);
            resultMap.put("errmsg", e.getMessage());
        }
        return resultMap;
    }*/
    @RequestMapping(value = "/copyFile", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> copyFile(@RequestBody Map<String, Object> appMap) throws Exception {
    	log.info("FileController中copyFile方法");
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	List<Map<String, Object>> nodeIdList = (List<Map<String, Object>>) appMap.get("nodeIdList");
    	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    	for (Map<String, Object> map : nodeIdList) {
    		Map<String, Object> tempMap = new HashMap<String, Object>();
    		String nodeId = (String) map.get("nodeId");
    		Map<String, Object> redisInfo = redisService.getInfo(Constants.UCDISK_WEB_LOGIN_INFO, (String) appMap.get("emp_id"));
//            Map<String, Object> redisInfo = redisService.getInfo(Constants.UCDISK_WEB_LOGIN_INFO, SDKConfigUtil.VIRTUAL_USER);
    		String token = (String) redisInfo.get("emp_token");
    		try {
    			SDKPersonalService personalService = new SDKPersonalService();
    			MessageBean<ShareEvent> share = personalService.oaCopyAndShare(token,nodeId, SDKConfigUtil.VIRTUAL_USER,"分享测试", true,true);
    			String url = share.getBody().getBean().getUrl();
    			tempMap.put("name", map.get("name"));
    			tempMap.put("nodeId", nodeId);
    			tempMap.put("nodeId", nodeId+"&"+share.getBody().getBean().getId());
    			tempMap.put("fileUrl",url);
    			list.add(tempMap);
    		} catch (RestClientException e) {
    			resultMap.put("result", false);
    			resultMap.put("errmsg", e.getMessage());
    		}
    		resultMap.put("result", true);
    		resultMap.put("data", list);
		}
    	return resultMap;
    }
}
