package com.peterwanghao.spring.cloud.sleuth;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.sleuth.instrument.async.LazyTraceExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**   
 * @ClassName:  ThreadConfig
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年4月11日 下午2:37:32
 * @version V1.0
 * 
 */
@Configuration
@EnableAutoConfiguration
@EnableAsync
public class ThreadConfig extends AsyncConfigurerSupport{
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

        System.out.println("111111111111111111");
        return new LazyTraceExecutor(beanFactory, threadPoolTaskExecutor);
    }
}
