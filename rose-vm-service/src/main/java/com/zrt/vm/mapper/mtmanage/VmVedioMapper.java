package com.zrt.vm.mapper.mtmanage;

import java.util.List;
import java.util.Map;

public interface VmVedioMapper {

	/**
	 * 查询vedio可创建视频房间用户信息
	 * 
	 * @return
	 */
	List<Map<String, Object>> getVedioUserList();

	Map<String, Object> getVidvoRoomCount(Map<String, Object> map);

	/**
	 * 查询会议参与人
	 * 
	 * @return
	 */
	List<Map<String, Object>> getRevEmpIds(Map<String, Object> map);

	/**
	 * 查询会议实时参与人
	 * 
	 * @return
	 */
	List<Map<String, Object>> getParRevEmpIds(Map<String, Object> map);

}