package com.zrt.commons.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zrt.commons.date.DateUtil;
import com.zrt.commons.sign.Base64;
import com.zrt.commons.sign.MD5;
import com.zrt.configuration.ImConfig;
public class HttpUtils {
	static int HTTP_OK = 200;
	private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);
  
    private static String ACCOUNT_SID=null;
    private static String ACCOUNT_TOKEN=null;
    private static String APPID=null;
    //
//    private static String BASE_URL="http://10.177.8.201:8881/2013-12-26";
    private static String BASE_URL=null;
    
    public HttpUtils(ImConfig imConfig){
    	ACCOUNT_SID=imConfig.getAccountSid();
    	ACCOUNT_TOKEN=imConfig.getAccountToken();
    	BASE_URL=imConfig.getBaseUrl();
    	APPID=imConfig.getAppId();
    }
    public static String getSig(String timeStamp) {
		log.info("sig，原值=>" + ACCOUNT_SID + ACCOUNT_TOKEN + timeStamp);
		String sig = MD5.encode(ACCOUNT_SID + ACCOUNT_TOKEN + timeStamp).toUpperCase();
		log.info("sig，MD5=>" + sig);
		return sig;
	}
	public static String getAuthorization(String timeStamp) {
		String encode="UTF-8";
		String authorization = null;
		try {
			authorization = new String(Base64.encodeToString((ACCOUNT_SID+ ":" + timeStamp).getBytes(encode)));
		} catch (Exception e) {
			log.error("生成rest authorization 错误",e.toString());
			e.printStackTrace();
		}
		log.info("authorization" + authorization);
		return authorization;
	}
	
	
	/***
	 * 直接推送消息
	 * @param jsonData
	 * @param accountType
	 * @param func
	 * @param funcdes
	 * @return
	 */
	public static String postRestJsonData(String jsonData) {
		
		return postRestJsonData(jsonData,"Accounts", "IM", "PushMsg");
	}
	
	
	/*** 方法: postRestJsonData <br>
	 * 描述: 调用rest请求，json方式  <br>
	 * 作者: wwfu <br>
	 * 时间: 2017-8-17 下午5:30:03
	 *
	 * 
	 * @param jsonData
	 * @param accountType
	 * @param func 参数func和funcdes根据接口填写；
	 * @param funcdes
	 * @return
	 */
	
	
	public static String postRestJsonData(String jsonData,String accountType,String func,String funcdes) {
		String timeStamp=DateUtil.getCurrentDateTime();
		String sig= getSig(timeStamp);
		String url=BASE_URL+"/"+accountType+"/"+ACCOUNT_SID+"/"+func+"/"+funcdes+"?sig="+sig;
		log.info("请求postRestJsonData地址:" + url);
		log.info("请求postRestJsonData内容:" + jsonData);
		String result = "";
		CloseableHttpClient client = null;
		InputStream inputStream = null;
		InputStreamReader iReader = null;
		String encode = "UTF-8";
		try {
			log.info("请求Authorization原值:" + ACCOUNT_SID + ":" + timeStamp);
			String Authorization = getAuthorization(timeStamp);
			log.info("请求Authorization base64值:" +Authorization);
			if (isHttpsUrl(url)) {
				client = registerSSL(getHost(url), "TLS", 8883, "https");
			} else {
				client = HttpClients.createDefault();
			}
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).build();
			HttpPost post = new HttpPost(url);
			post.setConfig(requestConfig);
			post.setHeader("Accept", "application/json");
			post.setHeader("Content-Type", "application/json;charset=" + encode);
			post.setHeader("Authorization", Authorization);
			//post.setHeader("Content-Length",jsonData.toString().length());
			HttpEntity httpEntity = new ByteArrayEntity(jsonData.getBytes("UTF-8"));
			post.setEntity(httpEntity);

			HttpResponse response = client.execute(post);
			HttpEntity entity = response.getEntity();

			StringBuffer sb = new StringBuffer();
			inputStream = entity.getContent();
			iReader = new InputStreamReader(inputStream, encode);
			BufferedReader reader = new BufferedReader(iReader);
			String line = null;

			while ((line = reader.readLine()) != null) {
				sb.append(line + "\r\n");
			}
			iReader.close();
			inputStream.close();
			result = sb.toString();
			log.info("rest返回json结果 :" + result);
		} catch (Exception e) {
			log.error("HttpClient请求rest地址json错误," + e.getMessage());
			e.printStackTrace();
		} finally {
			if(null!=iReader){
				try {
					iReader.close();
				} catch (IOException e) {
					iReader = null;
					e.printStackTrace();
				}
			}
			
			if(null!=inputStream){
				try {
					inputStream.close();
				} catch (IOException e) {
					inputStream = null;
					e.printStackTrace();
				}
			}
			
			if (client != null ) {
				try {
					client.close();
				} catch (IOException e) {
					client=null;
					e.printStackTrace();
				} 
            }
		}
		return result;
	}
	
	private static boolean isHttpsUrl(String url) {
		return (null != url) && (url.length() > 7) && url.substring(0, 8).equalsIgnoreCase("https://");
	}
	
	public static String getHost(String url) {
		int index = url.indexOf("//");
		String host = url.substring(index + 2);
		index = host.indexOf("/");
		if (index > 0) {
			host = host.substring(0, index);
		}
		log.debug("host:"+host);
		return host;
	}
	

	
	static CloseableHttpClient registerSSL(String hostname, String protocol, int port, String scheme)
			throws NoSuchAlgorithmException, KeyManagementException {
//		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建SSL上下文实例
		SSLContext ctx = SSLContext.getInstance(protocol);
		// 服务端证书验证
		X509TrustManager tm = new X509TrustManager() {
			public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
					throws java.security.cert.CertificateException {				
			}
			public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
					throws java.security.cert.CertificateException {
				if (chain == null || chain.length == 0)
					throw new IllegalArgumentException("null or zero-length certificate chain");
				if (authType == null || authType.length() == 0)
					throw new IllegalArgumentException("null or zero-length authentication type");

				boolean br = false;
				Principal principal = null;
				for (java.security.cert.X509Certificate x509Certificate : chain) {
					principal = x509Certificate.getSubjectX500Principal();
					log.debug("服务器证书信息：" + principal.getName());
					if (principal != null) {
						br = true;
						return;
					}
				}
				if (!br) {
					log.error("服务端证书验证失败！");
				}
			}
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return new java.security.cert.X509Certificate[0];
			}
		};

		// 初始化SSL上下文
		ctx.init(null, new TrustManager[] { tm }, new java.security.SecureRandom());
//		// 创建SSL连接
//		SSLSocketFactory socketFactory = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
//		Scheme sch = new Scheme(scheme, port, socketFactory);
//		// 注册SSL连接
//		httpclient.getConnectionManager().getSchemeRegistry().register(sch);
//		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(ctx,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(ctx,new String[] {"TLSv1","TLSv1.1","TLSv1.2","SSLv3" },null,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
//		String property = Constants.getProperty("https_supportedProtocols", "TLSv1,TLSv1.1,TLSv1.2,SSLv3");
//		String[] split = property.split(",");
//		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(ctx,split,null,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		return HttpClients.custom().setSSLSocketFactory(sslsf).build();
	}
    /** 
     * 测试方法 
     * @param args 
     */
	/**
    public static void main(String[] args) throws Exception {  
    	//String jsonData="{\"pushType\":\"1\",\"appId\":'"+APPID+"',\"sender\":\"2f960dea-4388-11e7-b66c-3c970e5c\",\"receiver\":[\"2f960ecb-4388-11e7-b66c-3c970e5c\",\"2f960953-4388-11e7-b66c-3c970e5c\"],\"msgType\":\"1\",\"msgContent\":\"hello\"}";
        Map<String, Object> reqMap=new HashMap<String, Object>();
        Map<String, Object> msgDomain=new HashMap<String, Object>();
        ObjectMapper mapper=new ObjectMapper();
        msgDomain.put("record_id", "1122333");
        msgDomain.put("roomUrl", "api.byshang.cn");
        msgDomain.put("roomId", "84zzeEZlad");
        msgDomain.put("tel", "fae77966-4f42-11e7-ac31-3c970e5c");
        msgDomain.put("nickname", "胡歌");
        msgDomain.put("vidyoMsgType", "0");
        msgDomain.put("syncDeviceName", "Android");
        msgDomain.put("CO_ROOM_ID", "-1");
        msgDomain.put("CO_ROOM_PASSWORD", "123456");
        msgDomain.put("CO_ROOM_SERVER", "123456");
        msgDomain.put("member", "2f960ecb-4388-11e7-b66c-3c970e5c,2f960953-4388-11e7-b66c-3c970e5c,fae77966-4f42-11e7-ac31-3c970e5c");
        msgDomain.put("muteState", "0,0");

        reqMap.put("pushType", "1");
        reqMap.put("appId", APPID);
        reqMap.put("sender", "fae77966-4f42-11e7-ac31-3c970e5c");
        reqMap.put("receiver", new String[]{"2f960ecb-4388-11e7-b66c-3c970e5c","2f960953-4388-11e7-b66c-3c970e5c","fae77966-4f42-11e7-ac31-3c970e5c"});
        reqMap.put("msgType", "1");//消息类型，1：文本消息，2：语音消息，3：视频消息，4：图片消息，5：位置消息，6：文件
        reqMap.put("msgContent", "1tet11");//文本内容，最大长度2048字节，文本和附件二选一，不能都为空
       reqMap.put("msgDomain", "customtype=200,"+mapper.writeValueAsString(msgDomain));//扩展字段，最大长度2048字符
        //reqMap.put("msgDomain", "kuozhan");//扩展字段，最大长度2048字符
        reqMap.put("msgFileName", "");
        reqMap.put("msgFileUrl", "");
    	
        String jsonData= mapper.writeValueAsString(reqMap);
        System.out.println();
    	postRestJsonData(jsonData);
    }  **/
}
