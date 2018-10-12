package com.peterwanghao.spring.cloud.task;

import java.util.logging.Logger;

import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.repository.TaskExecution;

/**   
 * @ClassName:  TaskListener
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年10月12日 下午1:50:47
 * @version V1.0
 * 
 */
public class TaskListener implements TaskExecutionListener {

	private final static Logger LOGGER = Logger.getLogger(TaskListener.class.getName());

	@Override
	public void onTaskEnd(TaskExecution arg0) {
		// TODO Auto-generated method stub
		LOGGER.info("End of Task");
	}

	@Override
	public void onTaskFailed(TaskExecution arg0, Throwable arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTaskStartup(TaskExecution arg0) {
		// TODO Auto-generated method stub
		LOGGER.info("Task Startup");
	}
}
