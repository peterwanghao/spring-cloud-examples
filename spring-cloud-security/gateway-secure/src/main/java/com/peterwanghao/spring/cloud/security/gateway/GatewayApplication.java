package com.peterwanghao.spring.cloud.security.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**   
 * @ClassName:  GatewayApplication
 * @Description:微服务网关
 * @author: wanghao
 * @date:   2018年5月2日 上午10:18:43
 * @version V1.0
 * 
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class GatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
