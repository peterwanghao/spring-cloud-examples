package com.peterwanghao.spring.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**   
 * @ClassName:  ConfigServer
 * @Description:微服务框架Spring Cloud Config 实现的配置中心
 * @author: wanghao
 * @date:   2018年3月20日 下午1:43:17
 * @version V1.0
 * 
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer {
	public static void main(String[] args) {
		SpringApplication.run(ConfigServer.class, args);
	}
}
