package com.peterwanghao.spring.cloud.ribbon.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**   
 * @ClassName:  ServerLocationApp
 * @Description:使用Spring Cloud Ribbon实现的客户端负载均衡
 * @author: wanghao
 * @date:   2018年3月28日 下午2:08:36
 * @version V1.0
 * 
 */
@SpringBootApplication
@RestController
@RibbonClient(name = "ping-a-server", configuration = RibbonConfiguration.class)
public class ServerLocationApp {

	@LoadBalanced
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/server-location")
	public String serverLocation() {
		String servLoc = this.restTemplate.getForObject("http://ping-server/locate", String.class);
		return servLoc;
	}

	public static void main(String[] args) {
		SpringApplication.run(ServerLocationApp.class, args);
	}
}
