package com.peterwanghao.spring.cloud.archaius.jdbc.config;

import javax.sql.DataSource;

import org.apache.commons.configuration.AbstractConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.config.DynamicConfiguration;
import com.netflix.config.FixedDelayPollingScheduler;
import com.netflix.config.PolledConfigurationSource;
import com.netflix.config.sources.JDBCConfigurationSource;

/**   
 * @ClassName:  ApplicationPropertiesConfigurations
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年11月20日 下午4:32:44
 * @version V1.0
 * 
 */
@Configuration
public class ApplicationPropertiesConfigurations {

	@Autowired
	DataSource h2DataSource;

	@Bean
	public AbstractConfiguration addApplicationPropertiesSource() {
		PolledConfigurationSource source = new JDBCConfigurationSource(h2DataSource,
				"select distinct key, value from properties", "key", "value");
		return new DynamicConfiguration(source, new FixedDelayPollingScheduler());
	}

}
