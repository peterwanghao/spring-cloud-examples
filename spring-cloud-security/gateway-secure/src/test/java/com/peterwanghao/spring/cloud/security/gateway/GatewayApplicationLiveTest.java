package com.peterwanghao.spring.cloud.security.gateway;

import static io.restassured.RestAssured.config;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.config.RedirectConfig;
import io.restassured.response.Response;

/**   
 * @ClassName:  GatewayApplicationLiveTest
 * @Description:测试服务网关
 * @author: wanghao
 * @date:   2018年5月2日 下午2:06:18
 * @version V1.0
 * 
 * @Copyright: 2018 www.viewhigh.com Inc. All rights reserved.
 */
public class GatewayApplicationLiveTest {
	private final String ROOT_URI = "http://localhost:8080";
	private final FormAuthConfig formConfig = new FormAuthConfig("/login", "username", "password");

	@Before
	public void setup() {
		RestAssured.config = config().redirect(RedirectConfig.redirectConfig().followRedirects(false));
	}

	/**
	 * 
	 * @Title: whenGetAllBooks_thenSuccess
	 * @Description: 访问一个没有权限控制的接口
	 * @param: 
	 * @return: void
	 * @throws
	 */
	@Test
	public void whenGetAllBooks_thenSuccess() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();

		ResponseEntity<String> response = testRestTemplate.getForEntity(ROOT_URI + "/book-service/books", String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertNotNull(response.getBody());
	}

	/**
	 * 
	 * @Title: whenAccessProtectedResourceWithoutLogin_thenForbidden
	 * @Description: 访问一个有权限控制的接口，返回403
	 * @param: 
	 * @return: void
	 * @throws
	 */
	@Test
	public void whenAccessProtectedResourceWithoutLogin_thenForbidden() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<String> response = testRestTemplate.getForEntity(ROOT_URI + "/book-service/books/1",
				String.class);
		Assert.assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
	}

	/**
	 * 
	 * @Title: whenAccessProtectedResourceBySession_thenSuccess
	 * @Description: 访问一个有权限控制的接口，通过共享会话可正常访问受保护资源
	 * @param: 
	 * @return: void
	 * @throws
	 */
	@Test
	public void whenAccessProtectedResourceBySession_thenSuccess() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
		form.add("username", "peter");
		form.add("password", "123456");
		ResponseEntity<String> response = testRestTemplate.postForEntity(ROOT_URI + "/login", form, String.class);

		String sessionCookie = response.getHeaders().get("Set-Cookie").get(0).split(";")[0];
		HttpHeaders headers = new HttpHeaders();
		headers = new HttpHeaders();
		headers.add("Cookie", sessionCookie);
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);

		response = testRestTemplate.exchange(ROOT_URI + "/book-service/books/1", HttpMethod.GET, httpEntity,
				String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertNotNull(response.getBody());
	}

	/**
	 * 
	 * @Title: whenAccessProtectedResourceAfterLogin_thenSuccess
	 * @Description: 登录后访问受保护资源，可正常访问
	 * @param: 
	 * @return: void
	 * @throws
	 */
	@Test
	public void whenAccessProtectedResourceAfterLogin_thenSuccess() {
		final Response response = RestAssured.given().auth().form("peter", "123456", formConfig)
				.get(ROOT_URI + "/book-service/books/1");
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
		Assert.assertNotNull(response.getBody());
		System.out.println(response.getBody().asString());
	}

	/**
	 * 
	 * @Title: whenAccessAdminProtectedResource_thenForbidden
	 * @Description: 使用普通用户权限访问管理员资源，拒绝访问
	 * @param: 
	 * @return: void
	 * @throws
	 */
	@Test
	public void whenAccessAdminProtectedResource_thenForbidden() {
		final Response response = RestAssured.given().auth().form("peter", "123456", formConfig)
				.get(ROOT_URI + "/rating-service/ratings");
		Assert.assertEquals(HttpStatus.FORBIDDEN.value(), response.getStatusCode());

	}
}
