package com.peterwanghao.spring.cloud.consul.properties;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RestController;

/**   
 * @ClassName:  DistributedPropertiesApplication
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年12月6日 下午2:29:21
 * @version V1.0
 * 
 */
@SpringBootApplication
@RestController
public class DistributedPropertiesApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(DistributedPropertiesApplication.class).web(true).run(args);
	}
}
