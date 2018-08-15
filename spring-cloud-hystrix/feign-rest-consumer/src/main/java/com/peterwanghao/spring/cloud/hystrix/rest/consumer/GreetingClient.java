package com.peterwanghao.spring.cloud.hystrix.rest.consumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**   
 * @ClassName:  GreetingClient
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年8月15日 下午5:03:25
 * @version V1.0
 * 
 */
@FeignClient(name = "rest-producer", url = "http://localhost:9090", fallback = GreetingClientFallback.class)
public interface GreetingClient {
	@RequestMapping("/greeting/{username}")
	String greeting(@PathVariable("username") String username);
}
