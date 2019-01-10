package com.peterwanghao.spring.cloud.contract.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**   
 * @ClassName:  BasicMathController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2019年1月10日 下午5:16:14
 * @version V1.0
 * 
 */
@RestController
public class BasicMathController {
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/calculate")
	public String checkOddAndEven(@RequestParam("number") Integer number) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json");

		ResponseEntity<String> responseEntity = restTemplate.exchange(
				"http://localhost:8090/validate/prime-number?number=" + number, HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);

		return responseEntity.getBody();
	}
}
