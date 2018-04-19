package com.zrt.flow.web.manage.process;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;
import com.zrt.flow.service.process.ProcessService;

@RestController
@RequestMapping("/v1.0/flow")
public class ProcessController {
	private static final Logger log = LoggerFactory.getLogger(ProcessController.class);

	@Resource(name="processServiceImp")
	private ProcessService processService;
	/**
	 * 流程发起
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/apply", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> apply(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的ProcessController中apply方法");
		ResultMap resultMap=new ResultMap();
		try {
			 Map<String, Object> resData=processService.apply(appMap);
			resultMap.success().sucmsg("该申请已发起");
			return resultMap.map();
		}catch(AppException e){
			log.error(" error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}catch(Exception e){
			log.error(" error", e);
			return resultMap.failure().errmsg("流程发起失败!").map();
		}
	}
    
    
    /**
     * 流程发布
     */
    @RequestMapping(value="/deploy", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> deploy(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中deploy方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			processService.deploy(appMap);
   			resultMap.success().sucmsg("流程发布成功");
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("流程发布失败!").map();
   		}
   	}
    
    /**
     * 流程审核
     */
    @RequestMapping(value="/applyCheck", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> check(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中deploy方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			processService.check(appMap);
   			resultMap.success().sucmsg("审核成功");
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("流程审核失败!").map();
   		}
   	}
    
    /**
     * 流程节点信息
     */
    @RequestMapping(value="/actInfo", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> actInfo(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中actInfo方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			processService.actInfo(appMap);
   			resultMap.success().sucmsg("审核成功");
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("流程审核失败!").map();
   		}
   	}
    
    /**
     * 流程草稿保存
     */
    @RequestMapping(value="/draftSave", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> draftSave(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中sendraftSaved方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			processService.draftSave(appMap);
   			resultMap.success().sucmsg("流程草稿保存成功");
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("流程草稿保存失败!").map();
   		}
   	}
    
    /**
     * 流程草稿发送
     */
    @RequestMapping(value="/send", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> send(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中send方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			processService.send(appMap);
   			resultMap.success().sucmsg("流程草稿发送成功");
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("流程发送失败!").map();
   		}
   	}
    
    
    /**
     * 流程会签审核
     */
    @RequestMapping(value="/joinSignCheck", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> joinSignCheck(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中joinSign方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			processService.joinSignCheck(appMap);
   			resultMap.success().sucmsg("会签成功");
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("会签失败!").map();
   		}
   	}
    
    /**
     * 流程会签
     */
    @RequestMapping(value="/joinSign", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> joinSign(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中joinSign方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			processService.joinSign(appMap);
   			resultMap.success().sucmsg("会签成功");
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("会签失败!").map();
   		}
   	}
    
    /**
     * 流程阅读
     */
    @RequestMapping(value="/instRead", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> instRead(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中instRead方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			processService.instRead(appMap);
   			resultMap.success().sucmsg("阅读成功");
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("阅读失败!").map();
   		}
   	}
    
    /**
     * 流程加签审核
     */
    @RequestMapping(value="/signAdd", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> signAdd(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中signAdd方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			processService.signAdd(appMap);
   			resultMap.success().sucmsg("加签成功");
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("加签失败!").map();
   		}
   	}
    
    
    /**
     * 流程9.5.5驳回至审批
     */
    @RequestMapping(value="/returnCheck", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> returnCheck(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中returnCheck方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			processService.returnCheck(appMap);
   			resultMap.success().sucmsg("驳回至成功");
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("驳回至失败!").map();
   		}
   	}
    
    /**
     * 流程9.5.5驳回至审批
     */
    @RequestMapping(value="/applyCheckWithCon", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> applyCheckWithCon(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中applyCheckWithCon方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			processService.applyCheckWithCon(appMap);
   			resultMap.success().sucmsg("附条件同意成功");
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("附条件同意失败!").map();
   		}
   	}
    
    /**
     * 流程模版表单信息
     */
    @RequestMapping(value="/fmDetail", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> fmDetail(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中applyCheckWithCon方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			Map<String, Object> resData=processService.fmDetail(appMap);
   			resultMap.success().data(resData);
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("表单信息失败!").map();
   		}
   	}
    
    
    /**
     * 流程草稿删除
     */
    @RequestMapping(value="/draftDelete", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> draftDelete(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中draftDelete方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			processService.draftDelete(appMap);
   			resultMap.success().sucmsg("流程草稿删除成功");
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("流程草稿删除失败!").map();
   		}
   	}
    
    
    /**
     * 流程取消
     */
    @RequestMapping(value="/instCancel", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> instCancel(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中instCancel方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			processService.instCancel(appMap);
   			resultMap.success().sucmsg("流程撤销成功");
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("流程撤销失败!").map();
   		}
   	}
    
    /**
     * 流程草稿详情
     */
    @RequestMapping(value="/draftDetail", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> draftDetail(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中draftDetail方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			Map<String, Object> resMap=processService.draftDetail(appMap);
   			resultMap.success().data(resMap);
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("流程草稿详情查询失败!").map();
   		}
   	}
    
    /**
     * 流程草稿更新
     */
    @RequestMapping(value="/draftUpdate", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> draftUpdate(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中draftUpdate方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			processService.draftUpdate(appMap);
   			resultMap.success().sucmsg("流程草稿更新成功");
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("流程草稿更新失败!").map();
   		}
   	}
    
    /**
     * 流程草稿提交
     */
    @RequestMapping(value="/draftApply", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> draftApply(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中draftApply方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			processService.draftApply(appMap);
   			resultMap.success().sucmsg("流程草稿提交成功");
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("流程草稿提交失败!").map();
   		}
   	}
    
    
    /**
     * 节点查询
     */
    @RequestMapping(value="/actInfoList", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> actInfoList(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中actInfoList方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			Map<String, Object> resMap=processService.actInfo(appMap);
   			resultMap.success().data(resMap.get("data"));
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("驳回节点查询失败!").map();
   		}
   	}
    
    /**
     * 节点查询
     */
    @RequestMapping(value="/editSubmit", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> editSubmit(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中editSubmit方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			processService.editSubmit(appMap);
   			resultMap.success().sucmsg("审核成功");
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("流程提交失败!").map();
   		}
   	}
    
    /**
     * 附条件操作
     */
    @RequestMapping(value="/applyCheckCon", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> applyCheckCon(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中applyCheckCon方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			processService.applyCheckCon(appMap);
   			resultMap.success().sucmsg("附条件成功");
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("流程附条件失败!").map();
   		}
   	}
    
    /**
     * 流程进度图
     */
    @RequestMapping(value="/img", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> img(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中img方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			Map<String, Object> resMap=processService.img(appMap);
   			resultMap.success().data(resMap);
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("流程进度图查询失败!").map();
   		}
   	}
    
    
    /**
     * 催办
     */
    @RequestMapping(value="/remind", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> remind(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中remind方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			Map<String, Object> resMap=processService.remind(appMap);
   			resultMap.success().data(resMap);
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("催办失败!").map();
   		}
   	}
    
    /**
     * 下一节点信息
     */
    @RequestMapping(value="/actNextList", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> actNextList(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中actNextList方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			Map<String, Object> resMap=processService.actNextList(appMap);
   			resultMap.success().data(resMap);
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("下一审批节点查询失败!").map();
   		}
   	}
    
    
    /**
     * 个人相关流程列表
     */
    @RequestMapping(value="/selfAboutList", method = RequestMethod.POST, headers = "Accept=application/json")
   	public Map<String, Object> selfAboutList(@RequestBody Map<String, Object> appMap) throws Exception{
   		log.info("Server端的ProcessController中selfAboutList方法");
   		ResultMap resultMap=new ResultMap();
   		try {
   			Map<String, Object> resMap=processService.selfAboutList(appMap);
   			resultMap.data(resMap.get("data"));
   			resultMap.success().map().put("count", resMap.get("count"));
   			return resultMap.map();
   		}catch(AppException e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg(e.getMessage()).map();
   		}catch(Exception e){
   			log.error(" error", e);
   			return resultMap.failure().errmsg("个人相关流程列表查询失败!").map();
   		}
   	}
}
