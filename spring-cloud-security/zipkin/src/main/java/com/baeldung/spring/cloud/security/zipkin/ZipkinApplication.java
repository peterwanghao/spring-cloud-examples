package com.baeldung.spring.cloud.security.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

/**   
 * @ClassName:  ZipkinApplication
 * @Description:服务跟踪
 * @author: wanghao
 * @date:   2018年5月4日 上午9:58:15
 * @version V1.0
 * 
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class ZipkinApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZipkinApplication.class, args);
	}
}
