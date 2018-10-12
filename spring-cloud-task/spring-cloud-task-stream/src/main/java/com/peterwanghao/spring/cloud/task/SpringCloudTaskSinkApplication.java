package com.peterwanghao.spring.cloud.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

/**   
 * @ClassName:  SpringCloudTaskSinkApplication
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年10月12日 下午2:45:54
 * @version V1.0
 * 
 */
@SpringBootApplication
@EnableTaskLauncher
public class SpringCloudTaskSinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTaskSinkApplication.class, args);
	}

}
