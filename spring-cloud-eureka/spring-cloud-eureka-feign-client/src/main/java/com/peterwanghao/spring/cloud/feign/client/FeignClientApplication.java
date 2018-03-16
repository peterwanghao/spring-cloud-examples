package com.peterwanghao.spring.cloud.feign.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
 * @ClassName:  FeignClientApplication
 * @Description:<p>打招呼服务客户端实现，一个服务消费者。</p>
 *              <p>微服务框架Spring Cloud Netflix Eureka 实现的客户端，
 *              通过声明式服务调用发现和消费服务。</p>
 * @author: wanghao
 * @date:   2018年3月14日 下午4:27:07
 * @version V1.0
 * 
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@Controller
public class FeignClientApplication {
	@Autowired
	private GreetingClient greetingClient;

	public static void main(String[] args) {
		SpringApplication.run(FeignClientApplication.class, args);
	}

	@RequestMapping("/get-greeting")
	public String greeting(Model model) {
		model.addAttribute("greeting", greetingClient.greeting());
		return "greeting-view";
	}
}
