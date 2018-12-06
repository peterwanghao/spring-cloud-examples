package com.peterwanghao.spring.cloud.consul.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**   
 * @ClassName:  DiscoveryClientApplication
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年12月6日 下午2:24:36
 * @version V1.0
 * 
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DiscoveryClientApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(DiscoveryClientApplication.class).web(true).run(args);
	}
}
