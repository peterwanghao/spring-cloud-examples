package com.peterwanghao.spring.cloud.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**   
 * @ClassName:  HelloWorldApplication
 * @Description:服务提供者
 * @author: wanghao
 * @date:   2018年3月23日 下午5:37:59
 * @version V1.0
 * 
 */
@SpringBootApplication
@EnableDiscoveryClient
public class HelloWorldApplication {
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}
}
