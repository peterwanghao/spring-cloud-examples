package com.peterwanghao.spring.cloud.eureka.client;

import org.springframework.web.bind.annotation.RequestMapping;

/**   
 * @ClassName:  GreetingController
 * @Description:打招呼服务
 * @author: wanghao
 * @date:   2018年3月14日 下午3:58:56
 * @version V1.0
 * 
 */
public interface GreetingController {
	@RequestMapping("/greeting")
	String greeting();
}
