package com.peterwanghao.spring.cloud.task;

import static org.mockito.Mockito.mock;

import org.springframework.cloud.deployer.spi.task.TaskLauncher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**   
 * @ClassName:  TaskSinkConfiguration
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年10月12日 下午2:53:53
 * @version V1.0
 * 
 */
@Configuration
public class TaskSinkConfiguration {

	@Bean
	public TaskLauncher taskLauncher() {
		return mock(TaskLauncher.class);
	}

}
