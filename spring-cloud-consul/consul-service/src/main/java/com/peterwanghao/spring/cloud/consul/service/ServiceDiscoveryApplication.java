package com.peterwanghao.spring.cloud.consul.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**   
 * @ClassName:  ServiceDiscoveryApplication
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年12月6日 下午2:20:53
 * @version V1.0
 * 
 */
@SpringBootApplication
public class ServiceDiscoveryApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ServiceDiscoveryApplication.class).web(true).run(args);
	}
}