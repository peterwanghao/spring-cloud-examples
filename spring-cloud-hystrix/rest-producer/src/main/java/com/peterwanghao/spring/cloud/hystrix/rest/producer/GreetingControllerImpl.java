package com.peterwanghao.spring.cloud.hystrix.rest.producer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**   
 * @ClassName:  GreetingControllerImpl
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年8月15日 下午4:24:48
 * @version V1.0
 * 
 */
@RestController
public class GreetingControllerImpl implements GreetingController {

	/**
	 * <p>Title: greeting</p>
	 * <p>Description: </p>
	 * @param username
	 * @return
	 * @see com.peterwanghao.spring.cloud.hystrix.rest.producer.GreetingController#greeting(java.lang.String)
	 */
	@Override
	public String greeting(@PathVariable("username") String username) {
		return String.format("Hello %s!\n", username);
	}

}
