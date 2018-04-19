package com.zrt.gateway.web.singleLogin;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.gateway.api.ApiConstant;
import com.zrt.gateway.commons.date.DateUtil;
import com.zrt.gateway.commons.utils.MD5;
import com.zrt.gateway.commons.utils.ResultMap;
import com.zrt.gateway.web.base.BaseController;

@RestController
@RequestMapping(value = "/v1.0/singleLogin", produces = { "application/json;charset=UTF-8" })
public class SingleLoginController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(SingleLoginController.class);

	@Value("${api.xwh.url}")
	private String xwhURL;
	@Value("${api.cas.url}")
	private String casURL;
	@Value("${api.tcmp.url}")
	private String tcmpURL;
	@Value("${api.ta.url}")
	private String taURL;

	/**
	 * OA跳转登录信委会系统、tcmp、ta
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getSysURL", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> getSysURL(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的SingleLoginController中getSysURL方法");

		ResultMap resultMap = new ResultMap();
		Map<String, Object> dataMap = new HashMap<String, Object>();

		String secret = "30ba9cf5bcb19efc8ajuy44d6232d1936";
		Date date = DateUtil.getNowDate();
		if (null != date) {
			long ts = date.getTime();
			String code = MD5.encode(emp_id + ts + secret);
			String code1 = MD5.encode("ZROA|" + emp_id + "|" + ts + "|ZROA");

			dataMap.put("xwhUrl", xwhURL + "empno=" + emp_id + "&ts=" + ts + "&code=" + code);
			dataMap.put("tcmpUrl", casURL + "service=" + tcmpURL + "uid=" + emp_id + "&code=" + code1 + "&oatime=" + ts
					+ "&otype=ZROA");
			dataMap.put("taUrl",
					casURL + "service=" + taURL + "uid=" + emp_id + "&code=" + code1 + "&oatime=" + ts + "&otype=ZROA");
		}

		resultMap.success().sucmsg("请求成功!");
		resultMap.data(dataMap);

		return response(resultMap.map());
	}

	/**
	 * OA跳转登录信委会系统、tcmp、ta
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getSysURL1", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> getSysURL1(@RequestBody Map<String, Object> requestMap) throws Exception {
		log.info("Server端的SingleLoginController中getSysURL方法");

		ResultMap resultMap = new ResultMap();
		Map<String, Object> dataMap = new HashMap<String, Object>();

		String secret = "30ba9cf5bcb19efc8ajuy44d6232d1936";
		long ts = DateUtil.getNowDate().getTime();
		String emp_id = "000001";
		String code = MD5.encode(emp_id + ts + secret);
		String code1 = MD5.encode("ZROA|" + emp_id + "|" + ts + "|ZROA");

		dataMap.put("xwhUrl",
				"http://192.168.80.205:8013/account/thirdlogin?empno=" + emp_id + "&ts=" + ts + "&code=" + code);
		dataMap.put("tcmpUrl", "http://192.168.80.104:7110/cas/login?service=http://192.168.80.31:7001/tcmp?uid="
				+ emp_id + "&code=" + code1 + "&oatime=" + ts + "&otype=ZROA");
		dataMap.put("taUrl", "http://192.168.80.104:7110/cas/login?service=http://192.168.80.42:7001/trustWeb/?uid="
				+ emp_id + "&code=" + code1 + "&oatime=" + ts + "&otype=ZROA");

		resultMap.success().sucmsg("请求成功!");
		resultMap.data(dataMap);

		return response(resultMap.map());
	}

}
