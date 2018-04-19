package com.zrt.infor.service.inforrecord;

import com.zrt.mybatis.domain.PlatInforAccessory;
import com.zrt.mybatis.domain.PlatInforConcern;
import com.zrt.mybatis.domain.PlatInforRecord;
import com.zrt.mybatis.domain.PlatInforRelevance;

import java.util.List;
import java.util.Map;

/**
 * Created by msKui on 2017/3/21.
 */
public interface InforRecordService {
	/**
	 * 新增讯息
	 *
	 * @param platInforRecord
	 * @return
	 */
	int saveInforRecord(PlatInforRecord platInforRecord) throws Exception;

	/**
	 * 新增讯息
	 *
	 * @param platInforRecord
	 * @return
	 */
	int saveInforRecord(PlatInforRecord platInforRecord, List<PlatInforRelevance> relevanceList,
			List<PlatInforAccessory> accessoryList) throws Exception;

	// 新建讯息
	int saveInfor(Map<String, Object> appMap, String str) throws Exception;

	// 修改个人资料发送讯息
	void sendUpdateInfor(Map<String, Object> map) throws Exception;

	void insertInfor(Map<String, Object> map) throws Exception;
}
