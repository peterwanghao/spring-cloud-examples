package com.peterwanghao.spring.cloud.contract.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**   
 * @ClassName:  EvenOddController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2019年1月10日 下午3:50:55
 * @version V1.0
 * 
 */
@RestController
public class EvenOddController {
	@GetMapping("/validate/prime-number")
	public String isNumberPrime(@RequestParam("number") Integer number) {
		return number % 2 == 0 ? "Even" : "Odd";
	}
}
