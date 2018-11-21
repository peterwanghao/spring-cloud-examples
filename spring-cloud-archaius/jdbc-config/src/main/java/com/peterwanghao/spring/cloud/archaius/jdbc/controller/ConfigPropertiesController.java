package com.peterwanghao.spring.cloud.archaius.jdbc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;

/**   
 * @ClassName:  ConfigPropertiesController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年11月20日 下午4:34:28
 * @version V1.0
 * 
 */
@RestController
public class ConfigPropertiesController {

	private DynamicStringProperty propertyOneWithDynamic = DynamicPropertyFactory.getInstance()
			.getStringProperty("springcloud.archaius.properties.one", "not found!");

	private DynamicStringProperty propertyTwoWithDynamic = DynamicPropertyFactory.getInstance()
			.getStringProperty("springcloud.archaius.properties.two", "not found!");

	private DynamicStringProperty propertyThreeWithDynamic = DynamicPropertyFactory.getInstance()
			.getStringProperty("springcloud.archaius.properties.three", "not found!");

	@GetMapping("/properties-from-dynamic")
	public Map<String, String> getPropertiesFromDynamic() {
		Map<String, String> properties = new HashMap<>();
		properties.put(propertyOneWithDynamic.getName(), propertyOneWithDynamic.get());
		properties.put(propertyTwoWithDynamic.getName(), propertyTwoWithDynamic.get());
		properties.put(propertyThreeWithDynamic.getName(), propertyThreeWithDynamic.get());
		return properties;
	}
}
