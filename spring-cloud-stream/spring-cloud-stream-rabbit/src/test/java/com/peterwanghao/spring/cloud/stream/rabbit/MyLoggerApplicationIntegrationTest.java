package com.peterwanghao.spring.cloud.stream.rabbit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.peterwanghao.spring.cloud.stream.rabbit.model.LogMessage;

/**   
 * @ClassName:  MyLoggerApplicationIntegrationTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年5月11日 上午10:58:30
 * @version V1.0
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyLoggerServiceApplication.class)
@DirtiesContext
public class MyLoggerApplicationIntegrationTest {
	@Autowired
	private Processor pipe;

	@Autowired
	private MessageCollector messageCollector;

	@Test
	public void whenSendMessage_thenResponseShouldUpdateText() {
		pipe.input().send(MessageBuilder.withPayload(new LogMessage("This is my message")).build());

		Object payload = messageCollector.forChannel(pipe.output()).poll().getPayload();

		assertEquals("[1]: This is my message", payload.toString());
	}
}
