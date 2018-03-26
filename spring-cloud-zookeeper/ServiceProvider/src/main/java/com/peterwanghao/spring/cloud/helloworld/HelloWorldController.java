package com.peterwanghao.spring.cloud.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**   
 * @ClassName:  HelloWorldController
 * @Description:RESTful服务，HelloWorld
 * @author: wanghao
 * @date:   2018年3月23日 下午5:39:42
 * @version V1.0
 * 
 */
@RestController
public class HelloWorldController {
	@GetMapping("/helloworld")
	public String HelloWorld() {
		return "Hello World!";
	}
}
