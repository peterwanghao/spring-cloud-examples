package com.peterwanghao.spring.cloud.consul.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**   
 * @ClassName:  MyProperties
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年12月6日 下午2:28:16
 * @version V1.0
 * 
 */
@RefreshScope
@Configuration
@ConfigurationProperties("my")
public class MyProperties {
	private String prop;

	public String getProp() {
		return prop;
	}

	public void setProp(String prop) {
		this.prop = prop;
	}
}
