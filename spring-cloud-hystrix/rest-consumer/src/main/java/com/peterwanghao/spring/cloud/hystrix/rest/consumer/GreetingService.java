package com.peterwanghao.spring.cloud.hystrix.rest.consumer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**   
 * @ClassName:  GreetingService
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年8月15日 下午4:40:56
 * @version V1.0
 * 
 */
@Service
public class GreetingService {
	@HystrixCommand(fallbackMethod = "defaultGreeting")
	public String getGreeting(String username) {
		return new RestTemplate().getForObject("http://localhost:9090/greeting/{username}", String.class, username);
	}

	@SuppressWarnings("unused")
	private String defaultGreeting(String username) {
		return "Hello User!";
	}
}
