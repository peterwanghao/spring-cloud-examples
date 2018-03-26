package com.peterwanghao.spring.cloud.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**   
 * @ClassName:  GreetingController
 * @Description:本地Web应用接口，调用HelloWorld服务客户端
 * @author: wanghao
 * @date:   2018年3月23日 下午5:46:19
 * @version V1.0
 * 
 */
@RestController
public class GreetingController {
	@Autowired
	private HelloWorldClient helloWorldClient;

	@GetMapping("/get-greeting")
	public String greeting() {

		return helloWorldClient.HelloWorld();

	}
}
