package com.peterwanghao.spring.cloud.consul.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**   
 * @ClassName:  DistributedPropertiesController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年12月6日 下午2:30:13
 * @version V1.0
 * 
 */
@RestController
public class DistributedPropertiesController {
	@Value("${my.prop}")
	String value;

	@Autowired
	private MyProperties properties;

	@GetMapping("/getConfigFromValue")
	public String getConfigFromValue() {
		return value;
	}

	@GetMapping("/getConfigFromProperty")
	public String getConfigFromProperty() {
		return properties.getProp();
	}
}
