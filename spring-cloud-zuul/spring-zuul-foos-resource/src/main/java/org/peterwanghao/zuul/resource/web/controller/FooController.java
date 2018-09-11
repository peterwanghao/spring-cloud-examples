package org.peterwanghao.zuul.resource.web.controller;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.peterwanghao.zuul.resource.web.dto.Foo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * @ClassName:  FooController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年9月11日 上午9:38:26
 * @version V1.0
 * 
 */
@Controller
public class FooController {
	public FooController() {
		super();
	}

	// API - read
	@RequestMapping(method = RequestMethod.GET, value = "/foos/{id}")
	@ResponseBody
	public Foo findById(@PathVariable final long id, HttpServletRequest req, HttpServletResponse res) {
		// System.out.println(req.getHeaderNames());
		// System.out.println("------" + req.getHeader("Test"));
		if (req.getHeader("Test") != null) {
			res.addHeader("Test", req.getHeader("Test"));
		}
		return new Foo(Long.parseLong(randomNumeric(2)), randomAlphabetic(4));
	}
}
