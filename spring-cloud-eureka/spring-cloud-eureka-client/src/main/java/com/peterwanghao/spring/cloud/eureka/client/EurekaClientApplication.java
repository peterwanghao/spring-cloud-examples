package com.peterwanghao.spring.cloud.eureka.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

/**   
 * @ClassName:  EurekaClientApplication
 * @Description:<p>打招呼服务实现。一个服务提供者。</p>
 *              <p>微服务框架Spring Cloud Netflix Eureka 实现的客户端，
 *              作为一个微服务应用向服务注册中心发布自己。</p>
 * @author: wanghao
 * @date:   2018年3月14日 下午4:01:07
 * @version V1.0
 * 
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication implements GreetingController {

	@Autowired
	@Lazy
	private EurekaClient eurekaClient;

	@Value("${spring.application.name}")
	private String appName;

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

	/**
	 * <p>Title: greeting</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.peterwanghao.spring.cloud.eureka.client.GreetingController#greeting()
	 */
	@Override
	public String greeting() {
		return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName());
	}

}
