package com.peterwanghao.spring.cloud.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
 * @ClassName:  GreetingClient
 * @Description:打招呼服务客户
 * @author: wanghao
 * @date:   2018年3月14日 下午4:25:35
 * @version V1.0
 * 
 */
@FeignClient("spring-cloud-eureka-client")
public interface GreetingClient{
	@RequestMapping("/greeting")
    String greeting();
}
