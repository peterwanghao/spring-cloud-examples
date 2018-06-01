package com.peterwanghao.spring.cloud.ribbon.client;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**   
 * @ClassName:  ServerLocationAppIntegrationTest
 * @Description:Spring Cloud Ribbon客户端负载测试类
 * @author: wanghao
 * @date:   2018年3月28日 下午2:23:21
 * @version V1.0
 * 
 */
@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerLocationApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServerLocationAppIntegrationTest {
	ConfigurableApplicationContext application2;
	ConfigurableApplicationContext application3;

	@Before
	public void startApps() {
		this.application2 = startApp(8081);
		this.application3 = startApp(8082);
	}

	@After
	public void closeApps() {
		this.application2.close();
		this.application3.close();
	}

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void loadBalancingServersTest() throws InterruptedException {
		// 调用Ribbon客户端
		ResponseEntity<String> response = this.testRestTemplate
				.getForEntity("http://localhost:" + this.port + "/server-location", String.class);
		assertEquals(response.getBody(), "Beijing");
	}

	// 启动服务实例
	private ConfigurableApplicationContext startApp(int port) {
		return SpringApplication.run(TestServiceProvider.class, "--server.port=" + port, "--spring.jmx.enabled=false");
	}
}
