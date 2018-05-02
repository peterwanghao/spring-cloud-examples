package com.peterwanghao.spring.cloud.security.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**   
 * @ClassName:  DiscoveryApplication
 * @Description:服务注册中心
 * @author: wanghao
 * @date:   2018年5月2日 上午10:10:05
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
