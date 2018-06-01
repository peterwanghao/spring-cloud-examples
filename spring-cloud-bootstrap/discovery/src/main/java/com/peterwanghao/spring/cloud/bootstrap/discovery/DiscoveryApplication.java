package com.peterwanghao.spring.cloud.bootstrap.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**   
 * @ClassName:  DiscoveryApplication
 * @Description:服务注册中心
 * @author: wanghao
 * @date:   2018年4月17日 下午3:16:06
 * @version V1.0
 * 
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryApplication {
	public static void main(String[] args) {
		SpringApplication.run(DiscoveryApplication.class, args);
	}
}
