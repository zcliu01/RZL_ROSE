package com.zrt.flow.service.process;

import java.util.Map;

/**
 * 
 * @author:fuww
 * @date:2016年12月30日下午4:40:17
 * @description 流程业务查询类
 */
public interface ProcessService {

	//流程发起申请
	Map<String, Object> apply(Map<String, Object> appMap) throws Exception;
    //流程发布
	Map<String, Object> deploy(Map<String, Object> appMap) throws Exception;
	//流程审核
    Map<String, Object> check(Map<String, Object> appMap) throws Exception;
	
  //流程节点信息
    Map<String, Object> actInfo(Map<String, Object> appMap) throws Exception;
	//审批详细页面
	Map<String, Object> queryProcessDetail(Map<String, Object> appMap) throws Exception;
	//流程发送
	Map<String, Object> send(Map<String, Object> appMap) throws Exception;
	//流程草稿保存
	Map<String, Object> draftSave(Map<String, Object> appMap) throws Exception;
	//流程会签
	Map<String, Object> joinSign(Map<String, Object> appMap) throws Exception;
	//流程会签审核
	Map<String, Object> joinSignCheck(Map<String, Object> appMap) throws Exception;
	
	
	//流程阅读
	Map<String, Object> instRead(Map<String, Object> appMap) throws Exception;
	
	//流程加签
   Map<String, Object> signAdd(Map<String, Object> appMap) throws Exception;
   
   //驳回至审核
   Map<String, Object> returnCheck(Map<String, Object> appMap) throws Exception;
   
   //附条件同意
   Map<String, Object> applyCheckWithCon(Map<String, Object> appMap) throws Exception;
   
   //申请流程表单详情
   Map<String, Object> fmDetail(Map<String, Object> appMap) throws Exception;

   //草稿删除draftDelete
   Map<String, Object> draftDelete(Map<String, Object> appMap) throws Exception;
   
   //流程取消
   Map<String, Object> instCancel(Map<String, Object> appMap) throws Exception;
   
   //草稿详情
   Map<String, Object> draftDetail(Map<String, Object> appMap) throws Exception;

   //草稿更新
   Map<String, Object> draftUpdate(Map<String, Object> appMap) throws Exception;

   //草稿提交draftApply
   Map<String, Object> draftApply(Map<String, Object> appMap) throws Exception;
   
   //发起人编辑提交
   Map<String, Object> editSubmit(Map<String, Object> appMap) throws Exception;
   
   //附条件
   Map<String, Object> applyCheckCon(Map<String, Object> appMap) throws Exception;

 //流程进度图
   Map<String, Object> img(Map<String, Object> appMap) throws Exception;
 //催办
   Map<String, Object> remind(Map<String, Object> appMap) throws Exception;
   /**
    * x下一审批节点信息查询
    * @param appMap
    * @return
    * @throws Exception
    */
   Map<String, Object> actNextList(Map<String, Object> appMap) throws Exception;
   
   /**
    * 个人相关流程列表
    * @param appMap
    * @return
    * @throws Exception
    */
   Map<String, Object> selfAboutList(Map<String, Object> appMap) throws Exception;
   
}
