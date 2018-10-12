package com.peterwanghao.spring.cloud.task;

import javax.sql.DataSource;

import org.springframework.cloud.task.configuration.DefaultTaskConfigurer;

/**   
 * @ClassName:  HelloWorldTaskConfigurer
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年10月12日 下午1:45:05
 * @version V1.0
 * 
 */
public class HelloWorldTaskConfigurer extends DefaultTaskConfigurer {

	public HelloWorldTaskConfigurer(DataSource dataSource) {
		super(dataSource);
	}
}
