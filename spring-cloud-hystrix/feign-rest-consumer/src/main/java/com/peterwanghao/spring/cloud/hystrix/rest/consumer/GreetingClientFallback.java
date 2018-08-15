package com.peterwanghao.spring.cloud.hystrix.rest.consumer;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**   
 * @ClassName:  GreetingClientFallback
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年8月15日 下午5:30:12
 * @version V1.0
 * 
 */
@Component
public class GreetingClientFallback implements GreetingClient {

	@Override
	public String greeting(@PathVariable("username") String username) {
		System.out.println("-----------------------------------");
		return "Hello User!";
	}

}
