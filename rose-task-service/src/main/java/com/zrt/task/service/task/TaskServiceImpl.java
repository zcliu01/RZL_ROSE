package com.zrt.task.service.task;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.zrt.commons.AppException;
import com.zrt.commons.Constant;
import com.zrt.commons.PageInit;
import com.zrt.commons.date.DateUtil;
import com.zrt.mybatis.domain.Task;
import com.zrt.mybatis.domain.TaskAttach;
import com.zrt.mybatis.domain.TaskEcexutor;
import com.zrt.mybatis.domain.TaskExample;
import com.zrt.mybatis.domain.TaskExample.Criteria;
import com.zrt.mybatis.domain.TaskRelevance;
import com.zrt.mybatis.mapper.TaskAttachMapper;
import com.zrt.mybatis.mapper.TaskEcexutorMapper;
import com.zrt.mybatis.mapper.TaskMapper;
import com.zrt.mybatis.mapper.TaskRelevanceMapper;
import com.zrt.task.mapper.task.QueryTaskMapper;
import com.zrt.task.mapper.task.UpdateMapper;
import com.zrt.task.service.contacts.ContactsService;
import com.zrt.task.service.infor.InforService;
import com.zrt.task.service.serial.SerialService;
import com.zrt.task.service.vmvif.VmvifService;

@Service("taskServiceImpl")
@SuppressWarnings("unchecked")
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskMapper taskMaper;
	@Autowired
	private TaskAttachMapper taskAttachMapper;
	@Autowired
	private TaskEcexutorMapper taskEcexutorMapper;
	@Autowired
	private TaskRelevanceMapper taskRelevanceMapper;
	@Autowired
	private QueryTaskMapper queryTaskMapper;
	@Autowired
	private UpdateMapper updateMapper;
	// 获取UUID
	@Autowired
	private SerialService serialService;

	@Autowired
	private ContactsService contactsService;

	@Autowired
	private InforService inforService;
	@Autowired
	private VmvifService vmvifService;

	@Value("${im.appId}")
	private String imAppId;

	// 查看任务详情的方法
	public Map<String, Object> searchInfoMethod(Map<String, Object> map) throws Exception {
		Task task = taskMaper.selectByPrimaryKey((String) map.get("task_id"));
		Map<String, Object> taskMap = new HashMap<String, Object>();
		taskMap.put("task_id", task.getTaskId());
		taskMap.put("parent_task_id", task.getParentTaskId());
		taskMap.put("task_name", task.getTaskName());
		taskMap.put("task_start_time", task.getTaskStartTime());
		taskMap.put("task_end_time", task.getTaskEndTime());
		taskMap.put("task_owner", task.getTaskOwner());
		taskMap.put("task_state", task.getTaskState());
		taskMap.put("sendim", task.getSendim());
		taskMap.put("sendInfo", task.getSendinfo());
		taskMap.put("task_remark", task.getTaskRemark());
		List<Map<String, Object>> attach = queryTaskMapper.attach(map);
		List<Map<String, Object>> executor = queryTaskMapper.executor(map);
		List<Map<String, Object>> relevance = queryTaskMapper.relevance(map);
		for (Map<String, Object> map2 : executor) {
			// 将任务创建人的id放入到map中
			if (map2.get("emp_id").toString().equals(map.get("emp_id"))){
				if ("0".equals(map2.get("is_read"))) {
					updateMapper.updateIsRead(map2);
					Map<String, Object> busDomainMap = new HashMap<>();
					Map<String, Object> tempMap = new HashMap<>();
					busDomainMap.put("bus_id", map.get("task_id"));
					tempMap.put("bus_domain", JSONObject.parseObject(JSON.toJSONString(busDomainMap)).toString());
					tempMap.put("recever_id", map.get("emp_id"));
					tempMap.put("bus_id", map.get("task_id"));
					inforService.flowInforRead(tempMap);
				}
			}
			map2.put("search", map2.get("emp_id"));
			Map<String, Object> empSearch = contactsService.commonEmpSearch(map2);
			// 将员工信息返回
			List<Map<String, Object>> empSearchList = (List<Map<String, Object>>) empSearch.get("data");
			if (null != empSearchList) {
				map2.put("emp_head_photo", empSearchList.get(0).get("emp_head_photo"));
				map2.put("emp_name", empSearchList.get(0).get("emp_name"));
				map2.put("org_name", empSearchList.get(0).get("org_name_owner"));
			}
		}
		Map<String, Object> endMap = new HashMap<String, Object>();
		if ("******".equals(task.getParentTaskId())) {
			endMap.put("host", "主任务");
		}
		endMap.put("task", taskMap);
		endMap.put("taskattach", attach);
		endMap.put("task_executor", executor);
		endMap.put("rel", relevance);
		return endMap;
	}

	/**
	 * 新建任务
	 * 
	 */
	@Override
	@Transactional(rollbackFor = {Throwable.class}, propagation = Propagation.REQUIRED)
	public int add(Map<String, Object> map) throws Exception {
		List<Map<String, Object>> taskAttachList = (List<Map<String, Object>>) map.get("taskattach");
		List<Map<String, Object>> task_executorList = (List<Map<String, Object>>) map.get("task_executor");
		List<Map<String, Object>> rel = (List<Map<String, Object>>) map.get("rel");
		if (null == task_executorList || task_executorList.size() == 0) {
			return 5;
		}
		Map<String, Object> taskMap = (Map<String, Object>) map.get("task");
		Task task = new Task();
		// 开始添加任务列表
		String taskName = (String) taskMap.get("task_name");
		if (StringUtil.isEmpty(taskName)) {
			return 2;
		}
		String begin = (String) taskMap.get("task_start_time");
		if (StringUtil.isEmpty(begin)) {
			return 3;
		}
		String end = (String) taskMap.get("task_end_time");
		if (StringUtil.isEmpty(end)) {
			return 4;
		}
		if (begin.length() == 10) {
			begin = begin.replaceAll("-", "") + "000000";
			end = end.replaceAll("-", "") + "235959";
			if (Long.parseLong(begin)>= Long.parseLong(end)) {
				throw new AppException("任务结束时间填写有误,结束时间必须大于开始时间");
			}
		} else {
			begin = begin.replaceAll("-", "").replace(" ", "").replace(":", "") + "00";
			end = end.replaceAll("-", "").replace(" ", "").replace(":", "") + "59";
			if (Long.parseLong(begin)>= Long.parseLong(end)) {
				throw new AppException("任务结束时间填写有误,结束时间必须大于开始时间");
			}
		}
		task.setTaskStartTime(begin);
		task.setTaskEndTime(end);
		String sendim = taskMap.get("sendim").toString();
		String sendInfo = taskMap.get("sendInfo").toString();
		String empId = (String) map.get("emp_id");
		String taskRemark = (String) taskMap.get("task_remark");
		map.put("search", empId);
		Map<String, Object> searchTask = contactsService.commonEmpSearch(map);
		List<Map<String, Object>> searchTaskList = (List<Map<String, Object>>) searchTask.get("data");
		String taskOwnerName = (String) searchTaskList.get(0).get("emp_name");
		String taskId = serialService.getUUID();
		task.setTaskId(taskId);
		task.setTaskOwnerName(taskOwnerName);
		task.setSendim(sendim);
		task.setSendinfo(sendInfo);
		task.setTaskOwner(empId);
		task.setTaskName(taskName);
		task.setTaskRemark(taskRemark);
		task.setTaskState("1");
		task.setCreateDateTime(DateUtil.getCurrentDateTime());
		String parentTaskId = (String) taskMap.get("parent_task_id");
		task.setParentTaskId(parentTaskId);
		if (StringUtil.isEmpty(parentTaskId)) {
			task.setParentTaskId("******");
		} else {
			task.setParentTaskId(parentTaskId);
		}
		taskMaper.insert(task);
		// 附件可以为空,进行判断 ,然后遍历添加
		if ( null!= taskAttachList&&taskAttachList.size()>0) {
			int testCount = 0 ;
			TaskAttach taskAttach = new TaskAttach();
			taskAttach.setTaskId(task.getTaskId());
			taskAttach.setCreateDateTime(DateUtil.getCurrentDateTime());
			for (Map<String, Object> taskAttachMap : taskAttachList) {
				taskAttach.setTenantId(testCount+"");
				taskAttach.setTaskAttackId(serialService.getUUID());
				taskAttach.setNodeId((String)taskAttachMap.get("node_id"));
				taskAttach.setAttachName((String) taskAttachMap.get("attach_name"));
				taskAttach.setAttachId((String) taskAttachMap.get("attach_id"));
				taskAttach.setAttachType((String) taskAttachMap.get("attach_type"));
				taskAttach.setTaskAttachUrl((String) taskAttachMap.get("task_attach_url"));
				taskAttach.setRemark((String) taskAttachMap.get("remark"));
				taskAttachMapper.insert(taskAttach);
				testCount++ ;
			}
		}
		if (rel !=null&&rel.size()>0) {
			TaskRelevance taskRelevance = new TaskRelevance();
			taskRelevance.setTaskId(taskId);
			taskRelevance.setCreateDateTime(DateUtil.getCurrentDateTime());
			taskRelevance.setRelStatus("1");
			for (Map<String, Object> relMap : rel) {
				taskRelevance.setRelTaskId(serialService.getUUID());
				taskRelevance.setRelId((String)relMap.get("rel_id"));
				taskRelevance.setRelName((String)relMap.get("rel_name"));
				taskRelevance.setRelType((String)relMap.get("rel_type"));
				taskRelevanceMapper.insert(taskRelevance);
				
			}
		}
		// 内部消息推送人的id拼接
		StringBuffer executorId = new StringBuffer();
		// Im推送人的id的集合
		List<String> executorList = new ArrayList<String>();
		// 遍历执行人
		TaskEcexutor taskEcexutor = new TaskEcexutor();
		taskEcexutor.setTaskId(task.getTaskId());
		taskEcexutor.setBackPercent("0%");
		taskEcexutor.setTaskExecutorState("1");
		taskEcexutor.setIsRead("0");
		taskEcexutor.setCreateDateTime(DateUtil.getCurrentDateTime());
		for (Map<String, Object> task_executor : task_executorList) {
			taskEcexutor.setTaskEmpId(serialService.getUUID());
			taskEcexutor.setEmpId((String) task_executor.get("emp_id"));
			String empName = (String) task_executor.get("emp_name");
			task_executor.put("search", (String) task_executor.get("emp_id"));
			Map<String, Object> empSearch = contactsService.commonEmpSearch(task_executor);
			List<Map<String, Object>> taskEcexutorMap = (List<Map<String, Object>>) empSearch.get("data");
			if (StringUtil.isEmpty(empName)) {
				empName = (String) taskEcexutorMap.get(0).get("emp_name");
			}
			taskEcexutor.setEmpName(empName);
			// 将emp_id放到集合和StringBuffer里 为后续做准备
			executorId.append((String) task_executor.get("emp_id") + ";");
			executorList.add((String) task_executor.get("emp_id"));
			taskEcexutorMapper.insert(taskEcexutor);
		}
		// 判断,如果可以发送IM讯息和内部讯息
		if ("1".equals(sendInfo)) {
			Map<String, Object> infoMap = new HashMap<String, Object>();
			Map<String, Object> infoMsgMap = new HashMap<String, Object>();
			infoMsgMap.put("bus_id", taskId);
			JSONObject busDomain = JSONObject.parseObject(JSON.toJSONString(infoMsgMap));
			infoMap.put("title", taskName);
			infoMap.put("content", taskRemark);
			infoMap.put("sender_id", empId);
			infoMap.put("category", "dayInfor");
			infoMap.put("bus_type", "TK01");
			infoMap.put("bus_id", taskId);
			infoMap.put("bus_domain", busDomain.toString());
			infoMap.put("receiver_ids", executorId.toString());
			inforService.sendUpdateInfor(infoMap);
		}
		if ("1".equals(sendim)) {
			Map<String, Object> imMap = new HashMap<String, Object>();
			Map<String, Object> msgMap = new HashMap<String, Object>();
			msgMap.put("title", taskName);
			msgMap.put("content", taskRemark);
			msgMap.put("status", "0");
			msgMap.put("category", "dayInfor");
			msgMap.put("bus_id", taskId);
			JSONObject msgDomain = JSONObject.parseObject(JSON.toJSONString(msgMap));
			imMap.put("pushType", "1");
			imMap.put("appId", imAppId);
			imMap.put("sender", "zrt_system");
			imMap.put("msgType", "1");
			imMap.put("msgDomain", "customtype=" + Constant.CUSTOMTYPE + "," + msgDomain);
			imMap.put("msgContent", "您有一条新的任务消息,请及时查看");
			imMap.put("receiver", executorList);
			vmvifService.pushMsg(imMap);
		}
		return 1;
	}

	/**
	 * 任务分配
	 * 
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int callChild(Map<String, Object> map) throws Exception {
		return 	add(map);
	}

	/**
	 * 任务列表查询
	 * 
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> search(Map<String, Object> map) throws Exception {
		if ("4".equals((String) map.get("task_state"))) {
			map.put("now_time", DateUtil.getCurrentDateTime());
		}
		String start_time_start = (String) map.get("start_time_start");
		String start_time_end = (String) map.get("start_time_end");
		String end_time_start = (String) map.get("end_time_start");
		String end_time_end = (String) map.get("end_time_end");
		if (StringUtil.isNotEmpty(start_time_start)) {
			start_time_start = start_time_start.replaceAll("-", "");
			map.put("start_time_start", start_time_start);
		}
		if (StringUtil.isNotEmpty(start_time_end)) {
			start_time_end = start_time_end.replaceAll("-", "");
			map.put("start_time_end", start_time_end + "235959");
		}
		if (StringUtil.isNotEmpty(end_time_start)) {
			end_time_start = end_time_start.replaceAll("-", "");
			map.put("end_time_start", end_time_start);
		}
		if (StringUtil.isNotEmpty(end_time_end)) {
			end_time_end = end_time_end.replaceAll("-", "");
			map.put("end_time_end", end_time_end + "235959");
		}
		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString())).setReasonable(false);
		// 获取当前日期
		long nd = 1000 * 24 * 60 * 60;
		long nh = 1000 * 60 * 60;
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMddhhmmss");
		String nowDate = DateUtil.getCurrentDateTime();
		long surplusTime = 0;
		// 查询所有的任务
		List<Map<String, Object>> searchTask = new ArrayList<Map<String, Object>>();
		if (StringUtil.isEmpty((String) map.get("task_executor_state"))) {
			if (StringUtil.isNotEmpty((String) map.get("taskexecutor"))
					|| StringUtil.isNotEmpty((String) map.get("task_owner"))) {
				searchTask = queryTaskMapper.searchTask(map);
			} else {
				searchTask = queryTaskMapper.webSearchTask(map);
			}

		} else {
			searchTask = queryTaskMapper.searchTaskByState(map);
		}
		// 遍历
		for (Map<String, Object> map2 : searchTask) {
			Map<String, Object> tempMap = new HashMap<String, Object>();
			// 获取结束时间的字符串
			String endTime = (String) map2.get("task_end_time");
			try {
				surplusTime = date.parse(endTime).getTime() - date.parse(nowDate).getTime();
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (surplusTime > 0) {
				// 计算差多少天
				long day = surplusTime / nd;
				// 计算差多少小时
				long hour = surplusTime % nd / nh;
				String resultTime = day + "天" + hour + "小时";
				tempMap.put("surplusTime", resultTime);
			} else {
				tempMap.put("surplusTime", "已超时");
			}
			// 把每个任务的id放到map里,为后续通过任务id查找任务附件和任务执行人做准备
			List<Map<String, Object>> searchAttach = queryTaskMapper.attach(map2);
			List<Map<String, Object>> searchExecutor = queryTaskMapper.executor(map2);
			tempMap.put("task_name", map2.get("task_name"));
			tempMap.put("task_end_time", map2.get("task_end_time"));
			tempMap.put("task_state", map2.get("task_state"));
			tempMap.put("task_id", map2.get("task_id"));
			tempMap.put("parent_task_id", map2.get("task_id"));
			tempMap.put("update_date_time", map2.get("update_date_time"));
			tempMap.put("task_start_time", map2.get("task_start_time"));
			// 将任务创建人的id放入到map中
			tempMap.put("search", map2.get("task_owner"));
			Map<String, Object> empSearch = contactsService.commonEmpSearch(tempMap);
			// 将员工信息返回
			List<Map<String, Object>> empSearchList = (List<Map<String, Object>>) empSearch.get("data");
			if (null != empSearchList) {
				tempMap.put("emp_head_photo", empSearchList.get(0).get("emp_head_photo"));
				tempMap.put("emp_name", empSearchList.get(0).get("emp_name"));
				tempMap.put("org_name", empSearchList.get(0).get("org_name_owner"));
			}

			// 计算任务的完成额度
			Map<String, Object> maxNumber = queryTaskMapper.maxMunber(tempMap);
			if ((long) maxNumber.get("COUNT(parent_task_id)") > 0) {
				// 百分比
				Map<String, Object> minNumber = queryTaskMapper.minNumber(tempMap);
				// 获取格式化类实例
				NumberFormat format = NumberFormat.getPercentInstance();
				// 设置小数位
				format.setMinimumFractionDigits(0);
				// 计算百分比
				long min = (long) minNumber.get("COUNT(parent_task_id)");
				long max = (long) maxNumber.get("COUNT(parent_task_id)");
				tempMap.put("percentage", format.format(min / max));
			} else {
				if ("3".equals(map2.get("task_state"))) {
					tempMap.put("percentage", "100%");
				} else {
					tempMap.put("percentage", "0%");
				}
			}
			map2.put("task", tempMap);
			map2.put("taskattach", searchAttach);
			map2.put("task_executor", searchExecutor);
		}
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(searchTask);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", searchTask);
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}

	// web端任务列表查询
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> webSearch(Map<String, Object> map) throws Exception {
		if (StringUtil.isNotEmpty((String) map.get("task_category"))) {
			if ("1".equals(map.get("task_category"))) {
				map.put("taskexecutor", map.get("emp_id"));
			} else {
				map.put("task_owner", map.get("emp_id"));
			}
		}else {
			map.put("executor_id", map.get("emp_id"));
		}
		if ("4".equals((String) map.get("task_state"))) {
			map.put("now_time", DateUtil.getCurrentDateTime());
		}
		String start_time_start = (String) map.get("start_time_start");
		String start_time_end = (String) map.get("start_time_end");
		String end_time_start = (String) map.get("end_time_start");
		String end_time_end = (String) map.get("end_time_end");
		if (StringUtil.isNotEmpty(start_time_start)) {
			start_time_start = start_time_start.replaceAll("-", "");
			map.put("start_time_start", start_time_start);
		}
		if (StringUtil.isNotEmpty(start_time_end)) {
			start_time_end = start_time_end.replaceAll("-", "");
			map.put("start_time_end", start_time_end + "235959");
		}
		if (StringUtil.isNotEmpty(end_time_start)) {
			end_time_start = end_time_start.replaceAll("-", "");
			map.put("end_time_start", end_time_start);
		}
		if (StringUtil.isNotEmpty(end_time_end)) {
			end_time_end = end_time_end.replaceAll("-", "");
			map.put("end_time_end", end_time_end + "235959");
		}
		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString())).setReasonable(false);
		// 获取当前日期
		long nd = 1000 * 24 * 60 * 60;
		long nh = 1000 * 60 * 60;
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMddhhmmss");
		String nowDate = DateUtil.getCurrentDateTime();
		long surplusTime = 0;
		// 查询所有的任务

		List<Map<String, Object>> searchTask = new ArrayList<Map<String, Object>>();
		if (StringUtil.isEmpty((String) map.get("task_executor_state"))) {
			if (StringUtil.isNotEmpty((String) map.get("taskexecutor"))
					|| StringUtil.isNotEmpty((String) map.get("task_owner"))) {
				searchTask = queryTaskMapper.searchTask(map);
			} else {
				searchTask = queryTaskMapper.webSearchTask(map);
			}
		} else {
			searchTask = queryTaskMapper.searchTaskByState(map);
		}
		// 遍历
		for (Map<String, Object> map2 : searchTask) {
			Map<String, Object> tempMap = new HashMap<String, Object>();
			// 获取结束时间的字符串
			String startTime = (String) map2.get("task_start_time");
			String endTime = (String) map2.get("task_end_time");
			String taskState = (String) map2.get("task_state");
			String updateTime = (String) map2.get("update_date_time");
			if ("3".equals(taskState)) {
				tempMap.put("update_date_time", updateTime.substring(0, 4) + "-" + updateTime.substring(4, 6) + "-"
						+ updateTime.substring(6, 8));
			} else {
				tempMap.put("update_date_time", null);
			}
			try {
				surplusTime = date.parse(endTime).getTime() - date.parse(nowDate).getTime();
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (surplusTime > 0) {
				// 计算差多少天
				long day = surplusTime / nd;
				// 计算差多少小时
				long hour = surplusTime % nd / nh;
				String resultTime = day + "天" + hour + "小时";
				tempMap.put("surplusTime", resultTime);
			} else {
				tempMap.put("surplusTime", "已超时");
			}
			// 把每个任务的id放到map里,为后续通过任务id查找任务附件和任务执行人做准备
			List<Map<String, Object>> searchAttach = queryTaskMapper.attach(map2);
			List<Map<String, Object>> searchExecutor = queryTaskMapper.executor(map2);
			tempMap.put("taskOwnerName", map2.get("task_owner_name"));
			tempMap.put("task_name", map2.get("task_name"));
			tempMap.put("task_start_time",
					startTime.substring(0, 4) + "-" + startTime.substring(4, 6) + "-" + startTime.substring(6, 8));
			tempMap.put("task_end_time",
					endTime.substring(0, 4) + "-" + endTime.substring(4, 6) + "-" + endTime.substring(6, 8));
			tempMap.put("task_state", map2.get("task_state"));
			tempMap.put("task_id", map2.get("task_id"));
			tempMap.put("parent_task_id", map2.get("parent_task_id"));
			map2.put("emp_name", map2.get("task_owner_name"));
			// 将任务创建人的id放入到map中
			tempMap.put("search", map2.get("task_owner"));
			tempMap.put("update_date_time", map2.get("update_date_time"));
			Map<String, Object> empSearch = contactsService.commonEmpSearch(tempMap);
			// 将员工信息返回
			List<Map<String, Object>> empSearchList = (List<Map<String, Object>>) empSearch.get("data");
			if (null != empSearchList) {
				tempMap.put("emp_head_photo", empSearchList.get(0).get("emp_head_photo"));
				tempMap.put("org_name", empSearchList.get(0).get("org_name_owner"));
			}

			// 计算任务的完成额度
			tempMap.put("emp_id", map.get("emp_id"));
			Map<String, Object> maxNumber = queryTaskMapper.maxMunber(tempMap);
			if ((long) maxNumber.get("COUNT(parent_task_id)") > 0) {
				// 百分比
				Map<String, Object> minNumber = queryTaskMapper.minNumber(tempMap);
				// 获取格式化类实例
				NumberFormat format = NumberFormat.getPercentInstance();
				// 设置小数位
				format.setMinimumFractionDigits(0);
				// 计算百分比
				long min = (long) minNumber.get("COUNT(parent_task_id)");
				long max = (long) maxNumber.get("COUNT(parent_task_id)");
				tempMap.put("percentage", format.format(min / max));
			} else {
				if ("3".equals(map2.get("task_state"))) {
					tempMap.put("percentage", "100%");
				} else {
					tempMap.put("percentage", "0%");
				}
			}
			map2.put("task", tempMap);
			map2.put("taskattach", searchAttach);
			map2.put("task_executor", searchExecutor);
		}
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(searchTask);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", searchTask);
		resMap.put("count", pageInfo.getTotal());

		return resMap;
	}

	/**
	 * 
	 * 查看任务详情
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public Map<String, Object> searchInfo(Map<String, Object> map) throws Exception {
		Map<String, Object> searchInfoMap = searchInfoMethod(map);
		Map<String, Object> result = (Map<String, Object>) searchInfoMap.get("task");
		map.put("search", result.get("task_owner"));
		Map<String, Object> empSearch = contactsService.commonEmpSearch(map);
		List<Map<String, Object>> empSearchList = (List<Map<String, Object>>) empSearch.get("data");
		if (null != empSearchList) {
			result.put("emp_head_photo", empSearchList.get(0).get("emp_head_photo"));
			result.put("emp_name", empSearchList.get(0).get("emp_name"));
			result.put("org_name", empSearchList.get(0).get("org_name_owner"));
		}
		List<Map<String, Object>> subtask = new ArrayList<Map<String, Object>>();
		map.put("parent_task_id", map.get("task_id"));
		map.put("task_owner", map.get("emp_id"));
		List<Map<String, Object>> searchTask = queryTaskMapper.searchTaskByOwner(map);
		for (Map<String, Object> map2 : searchTask) {
			Map<String, Object> searchInfoMethod = searchInfoMethod(map2);
			Map<String, Object> searchInfoSub = (Map<String, Object>) searchInfoMethod.get("task");
			// 计算任务的完成额度
			Map<String, Object> maxNo = queryTaskMapper.maxMunber(searchInfoSub);
			if ((long) maxNo.get("COUNT(parent_task_id)") > 0) {
				// 百分比
				Map<String, Object> minNo = queryTaskMapper.minNumber(searchInfoSub);
				// 获取格式化类实例
				NumberFormat format = NumberFormat.getPercentInstance();
				// 设置小数位
				format.setMinimumFractionDigits(0);
				// 计算百分比
				double min = (long) minNo.get("COUNT(parent_task_id)");
				double max = (long) maxNo.get("COUNT(parent_task_id)");
				searchInfoSub.put("percentage", format.format(min / max));
				searchInfoMethod.put("task", searchInfoSub);
			} else {
				if ("3".equals(searchInfoSub.get("task_state"))) {
					searchInfoSub.put("percentage", "100%");
				} else {
					searchInfoSub.put("percentage", "0%");
				}
			}
			subtask.add(searchInfoMethod);
		}
		// 计算任务的完成额度
		Map<String, Object> maxNumber = queryTaskMapper.maxMunber(result);
		if ((long) maxNumber.get("COUNT(parent_task_id)") > 0) {
			// 百分比
			Map<String, Object> minNumber = queryTaskMapper.minNumber(result);
			// 获取格式化类实例
			NumberFormat format = NumberFormat.getPercentInstance();
			// 设置小数位
			format.setMinimumFractionDigits(0);
			// 计算百分比
			double min = (long) minNumber.get("COUNT(parent_task_id)");
			double max = (long) maxNumber.get("COUNT(parent_task_id)");

			result.put("percentage", format.format(min / max));
		} else {
			if ("3".equals(result.get("task_state"))) {
				result.put("percentage", "100%");
			} else {
				result.put("percentage", "0%");
			}
		}
		result.put("subtask", subtask);
		searchInfoMap.put("task", result);
		return searchInfoMap;

	}

	/**
	 * 
	 * 任务终止
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int stop(Map<String, Object> map) throws Exception {
		String taskId = (String) map.get("task_id");
		// 通过任务id获取该任务的对象
		Task task = taskMaper.selectByPrimaryKey(taskId);
		// 进行比对,如果该任务是已终止或者已完成的状态则不能再对其进行修改
		if ("2".equals(task.getTaskState())) {
			return 2;
		}
		if ("3".equals(task.getTaskState())) {
			return 3;
		}
		String sendim = (String)map.get("sendim");
		String sendInfo = (String) map.get("sendInfo");
		// 内部消息推送人的id拼接
		StringBuffer executorId = new StringBuffer();
		// Im推送人的id的集合
		List<String> executorList = new ArrayList<String>();
		List<Map<String, Object>> executor = queryTaskMapper.executor(map);
		for (Map<String, Object> tempMap : executor) {
			executorId.append((String) tempMap.get("emp_id") + ";");
			executorList.add((String) tempMap.get("emp_id"));
		}
		// 判断,如果可以发送IM讯息和内部讯息
		if ("1".equals(sendInfo)) {
			Map<String, Object> infoMap = new HashMap<String, Object>();
			Map<String, Object> infoMsgMap = new HashMap<String, Object>();
			infoMsgMap.put("bus_id", taskId);
			JSONObject busDomain = JSONObject.parseObject(JSON.toJSONString(infoMsgMap));
			infoMap.put("title", task.getTaskName());
			infoMap.put("content", map.get("content"));
			infoMap.put("sender_id", map.get("emp_id"));
			infoMap.put("category", "dayInfor");
			infoMap.put("bus_type", "TK02");
			infoMap.put("bus_id", taskId);
			infoMap.put("bus_domain", busDomain.toString());
			infoMap.put("receiver_ids", executorId.append(task.getTaskOwner()+";").toString());
			inforService.sendUpdateInfor(infoMap);
		}
		if ("1".equals(sendim)) {
			executorList.add(task.getTaskOwner());
			Map<String, Object> imMap = new HashMap<String, Object>();
			Map<String, Object> msgMap = new HashMap<String, Object>();
			msgMap.put("title", task.getTaskName());
			msgMap.put("content", "您有一条新的任务消息,请及时查看");
			msgMap.put("status", "0");
			msgMap.put("category", "dayInfor");
			msgMap.put("bus_type", "TK02");
			msgMap.put("bus_id", taskId);
			JSONObject msgDomain = JSONObject.parseObject(JSON.toJSONString(msgMap));
			imMap.put("pushType", "1");
			imMap.put("appId", imAppId);
			imMap.put("sender", "zrt_system");
			imMap.put("msgType", "1");
			imMap.put("msgDomain", "customtype=" + Constant.CUSTOMTYPE + "," + msgDomain);
			imMap.put("msgContent", "您有一条新的任务消息,请及时查看");
			imMap.put("receiver",executorList );
			
			vmvifService.pushMsg(imMap);
		}
		String dateTime = DateUtil.getCurrentDateTime();
		task.setTaskState((String) map.get("task_state"));
		task.setUpdateDateTime(dateTime);
		taskMaper.updateByPrimaryKey(task);
		Map<String, Object> updateMap = new HashMap<String, Object>();
		updateMap.put("task_id", taskId);
		updateMap.put("update_date_time", dateTime);
		updateMap.put("task_state", (String) map.get("task_state"));
		updateMapper.updateState(updateMap);
		updateMapper.updateExecutorState(updateMap);
		// *********************************************************************************
		TaskExample taskExample = new TaskExample();
		Criteria criteria = taskExample.createCriteria();
		Map<String, Object> taskIdMap = new HashMap<String, Object>();
		taskIdMap.put("parent_task_id", taskId);
		List<Map<String, Object>> searchTask = queryTaskMapper.searchTaskByOwner(taskIdMap);
		if (null != searchTask) {
			List<String> taskIdList = new ArrayList<String>();
			for (Map<String, Object> map2 : searchTask) {
				String id = (String) map2.get("task_id");
				taskIdList.add(id);
			}

			while (taskIdList.size() > 0) {
				criteria.andParentTaskIdIn(taskIdList);
				List<Task> example = taskMaper.selectByExample(taskExample);
				if (null != example && example.size() > 0) {
					for (Task task2 : example) {
						String taskId2 = task2.getTaskId();
						updateMap.put("task_id", taskId2);
						updateMapper.updateState(updateMap);
						updateMapper.updateExecutorState(updateMap);
						List<Map<String, Object>> list = queryTaskMapper.executor(updateMap);
						executorId = new StringBuffer();
						executorList.clear();
						for (Map<String, Object> tempMap : list) {
							executorId.append((String) tempMap.get("emp_id") + ";");
							executorList.add((String) tempMap.get("emp_id"));
						}
						// 判断,如果可以发送IM讯息和内部讯息
						if ("1".equals(sendInfo)) {
							Map<String, Object> infoMap = new HashMap<String, Object>();
							Map<String, Object> infoMsgMap = new HashMap<String, Object>();
							infoMsgMap.put("bus_id", taskId);
							JSONObject busDomain = JSONObject.parseObject(JSON.toJSONString(infoMsgMap));
							infoMap.put("title",task.getTaskName());
							infoMap.put("content", map.get("content"));
							infoMap.put("sender_id", map.get("emp_id"));
							infoMap.put("category", "dayInfor");
							infoMap.put("bus_type", "TK02");
							infoMap.put("bus_id", taskId);
							infoMap.put("bus_domain", busDomain.toString());
							infoMap.put("receiver_ids", executorId.append(task.getTaskOwner()+";").toString());
							inforService.sendUpdateInfor(infoMap);
						}
						if ("1".equals(sendim)) {
							executorList.add(task.getTaskOwner());
							Map<String, Object> imMap = new HashMap<String, Object>();
							Map<String, Object> msgMap = new HashMap<String, Object>();
							msgMap.put("title", task.getTaskName());
							msgMap.put("content", map.get("content"));
							msgMap.put("status", "0");
							msgMap.put("category", "dayInfor");
							msgMap.put("bus_type", "TK02");
							msgMap.put("bus_id", taskId);
							JSONObject msgDomain = JSONObject.parseObject(JSON.toJSONString(msgMap));
							imMap.put("pushType", "1");
							imMap.put("appId", imAppId);
							imMap.put("sender","zrt_system");
							imMap.put("msgType", "1");
							imMap.put("msgDomain", "customtype=" + Constant.CUSTOMTYPE + "," + msgDomain);
							imMap.put("msgContent","您有一条新的任务消息,请及时查看");
							imMap.put("receiver", executorList);
							vmvifService.pushMsg(imMap);
						}
						taskIdList.clear();
						taskIdList.add(taskId2);
					}
				} else {
					taskIdList.clear();
				}
			}
		}
		return 1;
	}

	/**
	 * 
	 * 任务反馈
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int backInfo(Map<String, Object> map) throws Exception {
		TaskEcexutor taskEcexutor = taskEcexutorMapper.selectByPrimaryKey((String) map.get("task_emp_id"));
		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("task_id", map.get("task_emp_id"));
		//先执行删除和反馈有关的附件及关联信息
		updateMapper.updateRelevance(tempMap);
		updateMapper.deleteAttach(tempMap);
		List<Map<String, Object>> taskAttachList = (List<Map<String, Object>>) map.get("taskattach");
		List<Map<String, Object>> rel = (List<Map<String, Object>>) map.get("rel");
		if (null != taskAttachList&&taskAttachList.size()>0) {
			int testCount = 0 ;
			TaskAttach taskAttach = new TaskAttach();
			taskAttach.setTaskId((String) map.get("task_emp_id"));
			taskAttach.setCreateDateTime(DateUtil.getCurrentDateTime());
			for (Map<String, Object> taskAttachMap : taskAttachList) {
				taskAttach.setTenantId(testCount+"");
				taskAttach.setTaskAttackId(serialService.getUUID());
				taskAttach.setNodeId((String)taskAttachMap.get("node_id"));
				taskAttach.setAttachName((String) taskAttachMap.get("attach_name"));
				taskAttach.setAttachId((String) taskAttachMap.get("attach_id"));
				taskAttach.setAttachType((String) taskAttachMap.get("attach_type"));
				taskAttach.setTaskAttachUrl((String) taskAttachMap.get("task_attach_url"));
				taskAttach.setRemark((String) taskAttachMap.get("remark"));
				taskAttachMapper.insert(taskAttach);
				testCount++ ;
			}
		}
		if (null != rel &&rel.size()>0) {
			TaskRelevance taskRelevance = new TaskRelevance();
			taskRelevance.setCreateDateTime(DateUtil.getCurrentDateTime());
			taskRelevance.setTaskId((String) map.get("task_emp_id"));
			taskRelevance.setRelStatus("1");
			for (Map<String, Object> relMap : rel) {
				taskRelevance.setRelTaskId(serialService.getUUID());
				taskRelevance.setRelId((String)relMap.get("rel_id"));
				taskRelevance.setRelName((String)relMap.get("rel_name"));
				taskRelevance.setRelType((String)relMap.get("rel_type"));
				taskRelevanceMapper.insert(taskRelevance);
			}
		}
		String time = DateUtil.getCurrentDateTime();
		String backPercent = (String) map.get("back_percent");
		try {
			backPercent = backPercent.replace("%", "");
			double parseDouble = Double.parseDouble(backPercent);
			if (parseDouble > 100 || parseDouble < 0) {
				return -1;
			}
			taskEcexutor.setBackPercent(backPercent + "%");
		} catch (Exception e) {
			return -1;
		}
		taskEcexutor.setBackTime(time);
		taskEcexutor.setUpdateDateTime(time);
		taskEcexutor.setBackRemark((String) map.get("back_remark"));
		taskEcexutorMapper.updateByPrimaryKey(taskEcexutor);
		return 1;
	}

	/**
	 * 待办任务查询
	 * 
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> todoSearch(Map<String, Object> map) throws Exception {
		map.put("task_executor_state", "1");
		Map<String, Object> resMap = search(map);
		return resMap;
	}

	/**
	 * 修改任务
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int change(Map<String, Object> map) throws Exception {
		List<String> executorList = new ArrayList<String>();
		List<Map<String, Object>> taskAttachList = (List<Map<String, Object>>) map.get("taskattach");
		List<Map<String, Object>> task_executorList = (List<Map<String, Object>>) map.get("task_executor");
		List<Map<String, Object>> rel = (List<Map<String, Object>>) map.get("rel");
		if (null == task_executorList || task_executorList.size() == 0) {
			return 5;
		}
		Map<String, Object> taskMap = (Map<String, Object>) map.get("task");
		String taskId = (String) taskMap.get("task_id");
		Task task = taskMaper.selectByPrimaryKey(taskId);
		if (StringUtil.isEmpty((String) taskMap.get("task_name"))) {
			return 6;
		}
		task.setTaskName((String) taskMap.get("task_name"));
		task.setSendim((String) taskMap.get("sendim"));
		task.setUpdateDateTime(DateUtil.getCurrentDateTime());
		task.setSendinfo((String) taskMap.get("sendInfo"));
		task.setTaskRemark((String) taskMap.get("task_remark"));
		String begin = (String) taskMap.get("task_start_time");
		if (StringUtil.isEmpty(begin)) {
			return 3;
		}
		String end = (String) taskMap.get("task_end_time");
		if (StringUtil.isEmpty(end)) {
			return 4;
		}
		if (begin.length() == 10) {
			begin = begin.replace("-", "") + "000000";
			end = end.replace("-", "") + "000000";
		} else {
			begin = begin.replace("-", "").replace(" ", "").replace(":", "") + "00";
			end = end.replace("-", "").replace(" ", "").replace(":", "") + "00";
		}
		task.setTaskStartTime(begin);
		task.setTaskEndTime(end);
		List<Map<String, Object>> executorMap = queryTaskMapper.executor(taskMap);
		List<String> executor = new ArrayList<String>();
		for (Map<String, Object> tempMap : executorMap) {
			String executorEmpId = (String) tempMap.get("emp_id");
			executor.add(executorEmpId);
		}
		StringBuffer executors = new StringBuffer();
		TaskEcexutor taskEcexutor = new TaskEcexutor();
		for (Map<String, Object> tempMap : task_executorList) {
			executors.append(tempMap.get("emp_id")+";");
			executorList.add((String) tempMap.get("emp_id"));
			if (!executor.contains(tempMap.get("emp_id"))) {
				taskEcexutor.setTaskEmpId(serialService.getUUID());
				taskEcexutor.setTaskId(taskId);
				taskEcexutor.setBackPercent("0%");
				taskEcexutor.setTaskExecutorState("1");
				taskEcexutor.setCreateDateTime(DateUtil.getCurrentDateTime());
				taskEcexutor.setEmpId((String) tempMap.get("emp_id"));
				taskEcexutor.setEmpName((String) tempMap.get("emp_name"));
				taskEcexutor.setIsRead("0");
				taskEcexutorMapper.insert(taskEcexutor);
			}
		}
		List<String> deleteExecutor = new ArrayList<String>();
		for (String string : executor) {
			if (!executorList.contains(string)) {
				deleteExecutor.add(string);
				Map<String, Object> tempMap = new HashMap<String, Object>();
				tempMap.put("executorId", string);
				tempMap.put("task_id", taskId);
				updateMapper.deleteExecutorById(tempMap);
			}
		}
		if (deleteExecutor.size()>0) {
			Map<String, Object> imMap = new HashMap<String, Object>();
			Map<String, Object> msgMap = new HashMap<String, Object>();
			msgMap.put("title", task.getTaskName());
			msgMap.put("content", "你所负责的任务 ["+task.getTaskName()+"] 已被取消");
			msgMap.put("status", "0");
			msgMap.put("category", "dayInfor");
			msgMap.put("bus_type", "TK03");
			JSONObject msgDomain = JSONObject.parseObject(JSON.toJSONString(msgMap));
			imMap.put("pushType", "1");
			imMap.put("appId", imAppId);
			imMap.put("sender","zrt_system");
			imMap.put("msgType", "1");
			imMap.put("msgDomain","customtype="+Constant.CUSTOMTYPE+","+msgDomain);
			imMap.put("msgContent", "你所负责的任务 ["+task.getTaskName()+"] 已被取消");
			imMap.put("receiver", deleteExecutor);
			vmvifService.pushMsg(imMap);
		}
		taskMaper.updateByPrimaryKey(task);
		updateMapper.deleteAttach(taskMap);
		updateMapper.deleteRelevance(taskMap);
		// 附件可以为空,进行判断 ,然后遍历添加
		if (null != taskAttachList&&taskAttachList.size()>0) {
			int testCount = 0 ; 
			TaskAttach taskAttach = new TaskAttach();
			for (Map<String, Object> taskAttachMap : taskAttachList) {
				taskAttach.setTenantId(testCount+"");
				taskAttach.setTaskId(task.getTaskId());
				taskAttach.setTaskAttackId(serialService.getUUID());
				taskAttach.setCreateDateTime(DateUtil.getCurrentDateTime());
				taskAttach.setNodeId((String)taskAttachMap.get("node_id"));
				taskAttach.setAttachName((String) taskAttachMap.get("attach_name"));
				taskAttach.setAttachId((String) taskAttachMap.get("attach_id"));
				taskAttach.setAttachType((String) taskAttachMap.get("attach_type"));
				taskAttach.setTaskAttachUrl((String) taskAttachMap.get("task_attach_url"));
				taskAttach.setRemark((String) taskAttachMap.get("remark"));
				taskAttachMapper.insert(taskAttach);
				testCount++ ;
			}
		}
		if (null != rel &&rel.size()>0) {
			TaskRelevance taskRelevance = new TaskRelevance();
			taskRelevance.setCreateDateTime(DateUtil.getCurrentDateTime());
			taskRelevance.setTaskId(task.getTaskId());
			taskRelevance.setRelStatus("1");
			for (Map<String, Object> relMap : rel) {
				taskRelevance.setRelTaskId(serialService.getUUID());
				taskRelevance.setRelId((String)relMap.get("rel_id"));
				taskRelevance.setRelName((String)relMap.get("rel_name"));
				taskRelevance.setRelType((String)relMap.get("rel_type"));
				taskRelevanceMapper.insert(taskRelevance);
			}
		}
		if ("1".equals(task.getSendinfo())) {
			Map<String, Object> infoMap = new HashMap<String, Object>();
			Map<String, Object> infoMsgMap = new HashMap<String, Object>();
			infoMsgMap.put("bus_id", taskId);
			JSONObject busDomain = JSONObject.parseObject(JSON.toJSONString(infoMsgMap));
			infoMap.put("title", task.getTaskName());
			infoMap.put("content",task.getTaskRemark());
			infoMap.put("sender_id", map.get("emp_id"));
			infoMap.put("category", "dayInfor");
			infoMap.put("bus_type", "TK03");
			infoMap.put("bus_id",taskId);
			infoMap.put("receiver_ids", executors.toString());
			infoMap.put("bus_domain", busDomain.toString());
			inforService.sendUpdateInfor(infoMap);
		}
		if ("1".equals(task.getSendim())) {
			Map<String, Object> imMap = new HashMap<String, Object>();
			Map<String, Object> msgMap = new HashMap<String, Object>();
			msgMap.put("title", task.getTaskName());
			msgMap.put("content", task.getTaskRemark());
			msgMap.put("status", "0");
			msgMap.put("category", "dayInfor");
			msgMap.put("bus_type", "TK03");
			msgMap.put("bus_id", taskId);
			JSONObject msgDomain = JSONObject.parseObject(JSON.toJSONString(msgMap));
			imMap.put("pushType", "1");
			imMap.put("appId", imAppId);
			imMap.put("sender","zrt_system");
			imMap.put("msgType", "1");
			imMap.put("msgDomain","customtype="+Constant.CUSTOMTYPE+","+msgDomain);
			imMap.put("msgContent", "您有一条新的任务消息,请及时查看");
			imMap.put("receiver", executorList);
			vmvifService.pushMsg(imMap);
		}
		return 1;
	}

	/**
	 * 删除任务
	 */
	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public int delete(Map<String, Object> map) throws Exception {
		// 发送讯息
		Map<String, Object> imMap = new HashMap<String, Object>();
		Map<String, Object> msgMap = new HashMap<String, Object>();

		// Im推送人的id的集合
		List<String> executorList = new ArrayList<String>();

		String taskId = (String) map.get("task_id");
		Task task = taskMaper.selectByPrimaryKey(taskId);
		// 删除任务
		taskMaper.deleteByPrimaryKey(taskId);
		List<Map<String, Object>> executor = queryTaskMapper.executor(map);
		for (Map<String, Object> executorMap : executor) {
			String executorId = (String) executorMap.get("emp_id");
			executorList.add(executorId + ";");
		}
		msgMap.put("title", task.getTaskName());
		msgMap.put("content", map.get("content"));
		msgMap.put("status", "0");
		msgMap.put("category", "dayInfor");
		msgMap.put("bus_type", "TK02");
		msgMap.put("bus_id", taskId);
		JSONObject msgDomain = JSONObject.parseObject(JSON.toJSONString(msgMap));
		imMap.put("pushType", "1");
		imMap.put("appId", imAppId);
		imMap.put("sender","zrt_system");
		imMap.put("msgType", "1");
		imMap.put("msgDomain","customtype="+Constant.CUSTOMTYPE+","+msgDomain);
		imMap.put("msgContent", "您有一条新的任务消息,请及时查看");
		imMap.put("receiver", executorList);
		vmvifService.pushMsg(imMap);
		updateMapper.deleteExecutor(map);
		updateMapper.deleteAttach(map);

		// 删除下级任务
		TaskExample taskExample = new TaskExample();
		Criteria criteria = taskExample.createCriteria();
		Map<String, Object> taskIdMap = new HashMap<String, Object>();
		taskIdMap.put("parent_task_id", taskId);
		List<Map<String, Object>> searchTask = queryTaskMapper.searchTaskByOwner(taskIdMap);
		if (null != searchTask) {
			List<String> taskIdList = new ArrayList<String>();
			for (Map<String, Object> map2 : searchTask) {
				String id = (String) map2.get("task_id");
				taskIdList.add(id);
			}
			while (taskIdList.size() > 0) {
				executorList.clear();
				criteria.andParentTaskIdIn(taskIdList);
				List<Task> example = taskMaper.selectByExample(taskExample);
				taskMaper.deleteByExample(taskExample);
				if (null != example && example.size() > 0) {
					taskIdList.clear();
					for (Task task2 : example) {
						String taskId2 = task2.getTaskId();
						taskIdMap.put("task_id", taskId2);
						List<Map<String, Object>> list = queryTaskMapper.executor(taskIdMap);
						updateMapper.deleteAttach(taskIdMap);
						updateMapper.deleteExecutor(taskIdMap);
						updateMapper.deleteTask(taskIdMap);
						for (Map<String, Object> tempMap : list) {
							executorList.add((String) tempMap.get("emp_id") + ";");
						}
						taskIdList.add(taskId2);
						msgMap.put("title", task.getTaskName());
						msgMap.put("content", map.get("content"));
						msgMap.put("status", "0");
						msgMap.put("category", "dayInfor");
						msgMap.put("bus_id", taskId);
						msgMap.put("bus_type", "TK02");
						msgDomain = JSONObject.parseObject(JSON.toJSONString(msgMap));
						imMap.put("pushType", "1");
						imMap.put("appId", imAppId);
						imMap.put("sender","zrt_system");
						imMap.put("msgType", "1");
						imMap.put("msgDomain","customtype="+Constant.CUSTOMTYPE+","+msgDomain);
						imMap.put("msgContent","您有一条新的任务消息,请及时查看");
						imMap.put("receiver", executorList);
						vmvifService.pushMsg(imMap);
						updateMapper.deleteExecutor(map);
						updateMapper.deleteAttach(map);
						executorList.clear();
					}
				} else {
					taskIdList.clear();
				}
			}
		}
		return 1;
	}

}
