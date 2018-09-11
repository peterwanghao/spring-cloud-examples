package org.peterwanghao.zuul.ui;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**   
 * @ClassName:  LiveTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年9月11日 上午10:09:51
 * @version V1.0
 * 
 */
public class LiveTest {
	@Test
	public void whenSendRequestToFooResource_thenOK() {
		final Response response = RestAssured.get("http://localhost:8080/foos/1");
		assertEquals(200, response.getStatusCode());
	}

	@Test
	public void whenSendRequest_thenHeaderAdded() {
		final Response response = RestAssured.get("http://localhost:8080/foos/1");
		assertEquals(200, response.getStatusCode());
		assertEquals("TestSample", response.getHeader("Test"));
	}
}
