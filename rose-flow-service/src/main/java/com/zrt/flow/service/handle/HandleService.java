package com.zrt.flow.service.handle;

import java.util.Map;

/**
 * 签报类服务接口
 * 
 * @author wwfu
 *
 */
public interface HandleService {

	/**
	 * 签报了发起
	 * 
	 * @return
	 */
	Map<String, Object> handleApply(Map<String, Object> appMap) throws Exception;

	/**
	 * 签报审核
	 */
	Map<String, Object> handleCheck(Map<String, Object> appMap) throws Exception;

	/**
	 * 签报详情
	 */
	Map<String, Object> detail(Map<String, Object> appMap) throws Exception;

	/**
	 * 办结
	 */
	Map<String, Object> handleEnd(Map<String, Object> appMap) throws Exception;

	/**
	 * 草稿保存
	 */
	Map<String, Object> draftSave(Map<String, Object> appMap) throws Exception;

	/**
	 * 草稿更新
	 */
	Map<String, Object> draftUpdate(Map<String, Object> appMap) throws Exception;

	/**
	 * 草稿提交
	 */
	Map<String, Object> draftApply(Map<String, Object> appMap) throws Exception;

	/**
	 * 草稿发送
	 */
	Map<String, Object> send(Map<String, Object> appMap) throws Exception;

	/**
	 * 签报详情查询
	 */
	Map<String, Object> draftDetail(Map<String, Object> appMap) throws Exception;

	/**
	 * 流程信息
	 * 
	 * @param appMap
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> instInfor(Map<String, Object> appMap) throws Exception;

	/**
	 * 是否已签报
	 * 
	 * @param appMap
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> isHandle(Map<String, Object> appMap) throws Exception;

}
