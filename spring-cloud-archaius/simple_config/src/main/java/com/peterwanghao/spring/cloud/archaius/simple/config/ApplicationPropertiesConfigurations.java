package com.peterwanghao.spring.cloud.archaius.simple.config;

import org.apache.commons.configuration.AbstractConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.config.DynamicConfiguration;
import com.netflix.config.FixedDelayPollingScheduler;
import com.netflix.config.PolledConfigurationSource;
import com.netflix.config.sources.URLConfigurationSource;

/**   
 * @ClassName:  ApplicationPropertiesConfigurations
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年11月7日 下午3:49:58
 * @version V1.0
 * 
 */
@Configuration
public class ApplicationPropertiesConfigurations {
	@Bean
	public AbstractConfiguration addApplicationPropertiesSource() {
		PolledConfigurationSource source = new URLConfigurationSource("classpath:other-config.properties");
		return new DynamicConfiguration(source, new FixedDelayPollingScheduler());
	}
}
