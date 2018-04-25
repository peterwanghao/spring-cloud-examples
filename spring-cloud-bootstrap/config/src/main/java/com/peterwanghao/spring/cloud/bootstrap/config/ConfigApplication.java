package com.peterwanghao.spring.cloud.bootstrap.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**   
 * @ClassName:  ConfigApplication
 * @Description:配置中心，将所有配置保存到一个Git仓库
 * @author: wanghao
 * @date:   2018年4月25日 上午10:06:50
 * @version V1.0
 * 
 * @Copyright: 2018 www.viewhigh.com Inc. All rights reserved.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}
}
