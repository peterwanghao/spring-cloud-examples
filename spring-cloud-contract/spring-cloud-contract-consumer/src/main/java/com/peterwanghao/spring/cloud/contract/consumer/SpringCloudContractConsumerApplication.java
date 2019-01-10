package com.peterwanghao.spring.cloud.contract.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**   
 * @ClassName:  SpringCloudContractConsumerApplication
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2019年1月10日 下午5:14:16
 * @version V1.0
 * 
 */
@SpringBootApplication
public class SpringCloudContractConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudContractConsumerApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
