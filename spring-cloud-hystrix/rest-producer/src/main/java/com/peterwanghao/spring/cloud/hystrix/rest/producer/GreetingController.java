package com.peterwanghao.spring.cloud.hystrix.rest.producer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
 * @ClassName:  GreetingController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年8月15日 下午4:23:04
 * @version V1.0
 * 
 */
public interface GreetingController {
	@RequestMapping("/greeting/{username}")
	String greeting(@PathVariable("username") String username);
}
