package com.zrt.contacts.service.empsearchwindow;

import java.util.List;
import java.util.Map;

import com.zrt.commons.AppException;

/**
 * Created by msKui on 2017/3/8.
 */
public interface EmpSearchWindowService {
	/**
	 * 联系人综合展示模块，树，相当于一个路由，对不同rootId返回不同的组织机构。
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> treeRoute(Map<String, Object> map) throws Exception;

	/**
	 * 联系人综合展示模块，树，相当于一个路由，对不同rootId和treeId返回不同的联系人。
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> treeEmpRoute(Map<String, Object> map) throws Exception;

	/**
	 * 查询常用联系人，树
	 * 
	 * @param mapParam
	 * @return
	 */
	List<Map<String, Object>> friendEmpTree(Map<String, Object> mapParam) throws Exception;

	/**
	 * 通用的联系人搜索功能
	 * 
	 * @param map
	 * @return
	 * @throws AppException
	 */
	List<Map<String, Object>> commonEmpSearch(Map<String, Object> map) throws AppException;

	/**
	 * 讯息收件人按职级排序
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> infoReceiverOrderByRank(Map<String, Object> map) throws AppException;

	/**
	 * IM组织通讯录同步
	 * 
	 * @param map
	 * @return
	 */
	Map<String, Object> contactsImList(Map<String, Object> map) throws AppException;
	
	/**
	 * 参会人员信息
	 * 
	 * @param map
	 * @return
	 */
	Map<String, Object> meetEmpInfo(Map<String, Object> map) throws AppException;
	/**
	 * 根据部门查员工
	 * 
	 * @param map
	 * @return
	 */
	Map<String, Object> selectByOrg(Map<String, Object> map) throws AppException;
	
	/**
	 * 查询员工所在的所有部门，主，兼
	 * @param map
	 * @return
	 * @throws AppException
	 */
	Map<String, Object> empOrgInfo(Map<String, Object> map) throws AppException;
}
