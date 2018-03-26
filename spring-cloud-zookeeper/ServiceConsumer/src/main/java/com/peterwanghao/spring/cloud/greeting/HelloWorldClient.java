package com.peterwanghao.spring.cloud.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * @ClassName:  HelloWorldClient
 * @Description:HelloWorld服务客户端，通过Spring Cloud Feign声明式服务调用实现。
 * @author: wanghao
 * @date:   2018年3月23日 下午5:47:19
 * @version V1.0
 * 
 */
@Configuration
@EnableFeignClients
@EnableDiscoveryClient
public class HelloWorldClient {
	@Autowired
	private TheClient theClient;

	@FeignClient(name = "HelloWorld")
	interface TheClient {

		@RequestMapping(path = "/helloworld", method = RequestMethod.GET)
		@ResponseBody
		String HelloWorld();
	}

	public String HelloWorld() {
		return theClient.HelloWorld();
	}
}
