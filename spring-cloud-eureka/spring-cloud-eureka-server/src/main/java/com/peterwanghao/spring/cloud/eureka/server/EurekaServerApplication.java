package com.peterwanghao.spring.cloud.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**   
 * @ClassName:  EurekaServerApplication
 * @Description:微服务框架Spring Cloud Netflix Eureka 实现的服务注册中心
 * @author: wanghao
 * @date:   2018年3月14日 下午3:38:29
 * @version V1.0
 * 
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
	 public static void main(String[] args) {
	        SpringApplication.run(EurekaServerApplication.class, args);
	    }
	 
}
