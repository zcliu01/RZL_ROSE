package com.zrt.gateway.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zrt.gateway.api.client.sec.ISecUserClient;
import com.zrt.gateway.commons.context.Constant;
import com.zrt.gateway.commons.context.ResponseWrapperUtil;
import com.zrt.gateway.commons.context.ResultMap;


@WebFilter(urlPatterns = "/*", filterName = "unionAuthFilter", initParams = {
		@WebInitParam(name = "EXCLUDED_PAGES", value = "") })
public class UnionAuthenticationFilter implements Filter {
	private Logger logger = LoggerFactory.getLogger(UnionAuthenticationFilter.class);

	@Autowired
	private ISecUserClient secUserClient;

	private String appId = "apigateway";

	@Value("${api.excluded.pages}")
	private String excludedPages;
	private String[] excludedPageArray;


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String requestUri = req.getRequestURI();
		String httpMethod = req.getMethod();
		
		
		Enumeration headerNames = req.getHeaderNames();
	    while (headerNames.hasMoreElements()) {
	        String key = (String) headerNames.nextElement();
	        String value = req.getHeader(key);
	        logger.info("key="+key+", value="+value);
	    }
		
		boolean isExcludedPage = true;
		for (String page : excludedPageArray) {// 遍历例外url数组
			// 判断当前URL是否与例外页面相同
			if (req.getServletPath().equals(page)
					|| Pattern.compile(page).matcher(req.getServletPath().trim()).matches()) {
				isExcludedPage = true;
				break;
			}
		}
		if (isExcludedPage) {// 在过滤url之外
			chain.doFilter(request, response);
		} else {// 不在过滤url之外
			String token = null;
			Cookie[] coos = req.getCookies();
			if (coos != null && coos.length > 0) {
				for (Cookie coo : coos) {
					String name = coo.getName();
					if (name.equals("token")) {
						token = coo.getValue();
					}
				}
			}

			ResultMap resultMap = new ResultMap();

			if (coos == null) {
				logger.info("token is null");
				resultMap.failure();
				ResponseWrapperUtil.wrapper(HttpServletResponse.SC_OK, false, res, resultMap, "非法登录!");
				return;
			}
				 logger.info("appId==========================" + appId);
				 logger.info("token==========================" +token);
				 logger.info("uri============================" + requestUri);
				 logger.info("httpMethod=====================" + httpMethod);

				Map<String, Object> map = new HashMap<String, Object>();
				map.put("appId", appId);
				map.put("resourceUri", requestUri);
				map.put("method", httpMethod);
				Map<String, Object> resMap = secUserClient.loginCheck(map);
			if (resMap.containsKey("result") && (Boolean)resMap.get("result")) {
				sendCookies(req, res);
				chain.doFilter(req, res);
			} else {
				resultMap.failure();
				ResponseWrapperUtil.wrapper(HttpServletResponse.SC_OK, false, res, resultMap, "无效请求！");
				return;
			}
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ServletContext context = filterConfig.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
		//excludedPages = filterConfig.getInitParameter("EXCLUDED_PAGES");
		if (null != excludedPages && excludedPages.length() != 0) { // 例外页面不为空
			excludedPageArray = excludedPages.split(String.valueOf(';'));
		}
	}

	@Override
	public void destroy() {
		this.excludedPages = null;
		this.excludedPageArray = null;
	}

	private void sendCookies(HttpServletRequest req, HttpServletResponse res) {
		Cookie[] c = req.getCookies();
		if (c != null && c.length > 0) {
			for (int i = 0; i < c.length; i++) {
				c[i].setPath("/");
				c[i].setMaxAge(Constant.COOKIE_TIME);
				res.addCookie(c[i]);
			}
		}

	}

}
