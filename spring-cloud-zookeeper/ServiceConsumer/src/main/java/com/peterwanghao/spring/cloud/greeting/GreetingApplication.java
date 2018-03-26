package com.peterwanghao.spring.cloud.greeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**   
 * @ClassName:  GreetingApplication
 * @Description:服务消费者
 * @author: wanghao
 * @date:   2018年3月23日 下午5:45:09
 * @version V1.0
 * 
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GreetingApplication {
	public static void main(String[] args) {
		SpringApplication.run(GreetingApplication.class, args);
	}
}
