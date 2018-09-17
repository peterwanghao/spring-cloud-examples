package com.peterwanghao.spring.cloud.eureka.client;

import org.springframework.web.bind.annotation.RequestMapping;

/**   
 * @ClassName:  GreetingController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年9月17日 下午4:45:45
 * @version V1.0
 * 
 */
public interface GreetingController {
	@RequestMapping("/greeting")
	String greeting();
}
