package com.peterwanghao.spring.cloud.consul.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**   
 * @ClassName:  ServiceDiscoveryController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年12月6日 下午2:22:07
 * @version V1.0
 * 
 */
@RestController
public class ServiceDiscoveryController {
	@GetMapping("/ping")
	public String ping() {
		return " Service ping";
	}

	@GetMapping("/my-health-check")
	public ResponseEntity<String> myCustomCheck() {
		String message = "Testing my healh check function";
		return new ResponseEntity<>(message, HttpStatus.FORBIDDEN);
	}
}
