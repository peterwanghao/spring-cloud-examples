package com.peterwanghao.spring.cloud.security.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**   
 * @ClassName:  ConfigApplication
 * @Description:配置中心，将所有配置保存到一个Git仓库
 * @author: wanghao
 * @date:   2018年5月2日 上午9:57:15
 * @version V1.0
 * 
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}
}
