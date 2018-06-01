package com.peterwanghao.spring.cloud.ribbon.client;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**   
 * @ClassName:  TestConfig
 * @Description:服务提供者，提供一个定位服务
 * @author: wanghao
 * @date:   2018年3月28日 下午2:21:25
 * @version V1.0
 * 
 */
@Configuration
@EnableAutoConfiguration
@RestController
public class TestServiceProvider {

	@RequestMapping(value = "/locate")
	public String locationDetails() {
		return "Beijing";
	}
}
