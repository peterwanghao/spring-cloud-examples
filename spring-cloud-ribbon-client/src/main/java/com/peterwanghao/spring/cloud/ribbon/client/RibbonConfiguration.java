package com.peterwanghao.spring.cloud.ribbon.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.WeightedResponseTimeRule;

/**   
 * @ClassName:  RibbonConfiguration
 * @Description:负载均衡配置
 * @author: wanghao
 * @date:   2018年3月28日 下午2:10:59
 * @version V1.0
 * 
 */
public class RibbonConfiguration {
	@Autowired
	IClientConfig ribbonClientConfig;

	// 判断服务实例是否有效，ping某个url判断其是否alive
	@Bean
	public IPing ribbonPing(IClientConfig config) {
		return new PingUrl();
	}

	// 负载均衡策略，根据服务实例的运行情况来计算权重
	@Bean
	public IRule ribbonRule(IClientConfig config) {
		return new WeightedResponseTimeRule();
	}
}
