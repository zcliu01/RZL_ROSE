package com.zrt.flow.service.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("careCancelListener")
public class CareCancelListener implements ExecutionListener {

	private static final long serialVersionUID = 1L;
	@Autowired
	private ExecutionListenerService executionListenerService;


	// ExecutionListener类的实现
	@Override
	public void notify(DelegateExecution execution) throws Exception {
		String eventName = execution.getEventName();
		// start
		if ("start".equals(eventName)) {
			System.out.println("start=========");
		} else if ("end".equals(eventName)) {
			System.out.println("end=========");
		} else if ("take".equals(eventName)) {
			// 当走到连线的时候取下一节点审批会签审批
			executionListenerService.takeCareCancelExecution(execution);
			System.out.println("take=========");
		}

	}

}
