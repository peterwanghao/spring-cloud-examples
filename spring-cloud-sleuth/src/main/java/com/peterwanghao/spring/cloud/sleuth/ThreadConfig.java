package com.peterwanghao.spring.cloud.sleuth;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.instrument.async.LazyTraceExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**   
 * @ClassName:  ThreadConfig
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年4月11日 下午2:37:32
 * @version V1.0
 * 
 */
@Configuration
@EnableAsync
@EnableScheduling
public class ThreadConfig extends AsyncConfigurerSupport implements SchedulingConfigurer {
	@Autowired
	private BeanFactory beanFactory;

	@Bean
	public Executor executor() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(1);
		threadPoolTaskExecutor.setMaxPoolSize(1);
		threadPoolTaskExecutor.initialize();

		return new LazyTraceExecutor(beanFactory, threadPoolTaskExecutor);
	}

	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(7);
		threadPoolTaskExecutor.setMaxPoolSize(42);
		threadPoolTaskExecutor.setQueueCapacity(11);
		threadPoolTaskExecutor.setThreadNamePrefix("MyExecutor-");
		threadPoolTaskExecutor.initialize();

		return new LazyTraceExecutor(beanFactory, threadPoolTaskExecutor);
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
		scheduledTaskRegistrar.setScheduler(schedulingExecutor());
	}

	@Bean(destroyMethod = "shutdown")
	public Executor schedulingExecutor() {
		return Executors.newScheduledThreadPool(1);
	}
}
