package com.zrt.vm.mapper.mtmanage;

import java.util.List;
import java.util.Map;

import com.zrt.vm.domain.VmBusRecordDomain;

public interface VmCustomMapper {

	/**
	 * web端进行中会议列表
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> ongoingMeetingList(Map<String, Object> map);

	/**
	 * web端历史会议列表
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> historicalMeetingList(Map<String, Object> map);

	/**
	 * web端我的会议室会议列表
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> myMeetingList(Map<String, Object> map);

	List<VmBusRecordDomain> myAppMeetingList(Map<String, Object> map);

	Map<String, Object> myAppMeetingCount(Map<String, Object> map);

	List<Map<String, Object>> singleVmGroup(Map<String, Object> map);

}