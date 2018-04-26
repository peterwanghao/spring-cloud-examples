package com.peterwanghao.spring.cloud.bootstrap.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**   
 * @ClassName:  GatewayApplication
 * @Description:微服务网关
 * @author: wanghao
 * @date:   2018年4月25日 下午1:11:59
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
