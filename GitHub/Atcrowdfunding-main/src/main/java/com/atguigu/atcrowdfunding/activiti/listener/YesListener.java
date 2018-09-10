package com.atguigu.atcrowdfunding.activiti.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

//娴佺▼鐩戝惉鍣�
public class YesListener implements ExecutionListener {
@Override
	public void notify(DelegateExecution execution) throws Exception {
		System.out.println("审批通过...");
	}

}
