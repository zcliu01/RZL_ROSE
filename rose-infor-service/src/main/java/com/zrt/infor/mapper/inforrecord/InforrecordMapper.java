package com.zrt.infor.mapper.inforrecord;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zrt.infor.domain.InforOutbox;

/**
 * Created by msKui on 2017/3/22.
 */
public interface InforrecordMapper {

	/**
	 * 讯息详情
	 * 
	 * @param mapParam
	 * @return
	 */
	Map<String, Object> getParent(@Param("mapParam") Map<String, Object> mapParam);

	List<InforOutbox> inforDetailList(@Param("mapParam") Map<String, Object> mapParam);

	/**
	 * 关注讯息详情
	 * 
	 * @param mapParam
	 * @return
	 * 
	 */
	Map<String, Object> getChild(@Param("mapParam") Map<String, Object> mapParam);

	List<InforOutbox> inforCareDetailList(@Param("mapParam") Map<String, Object> mapParam);

	/**
	 * 撤销讯息
	 * 
	 * @param mapParam
	 * @return
	 */
	List<Map<String, Object>> inforDealStatus(@Param("mapParam") Map<String, Object> mapParam);

	/**
	 * 查询该讯息是否已经关注
	 * 
	 * @param mapParam
	 * @return
	 */
	int getCareFlag(@Param("mapParam") Map<String, Object> mapParam);

	void deleteInforDetail(String infor_no);

}
