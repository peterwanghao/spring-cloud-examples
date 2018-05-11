package com.peterwanghao.spring.cloud.stream.rabbit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.peterwanghao.spring.cloud.stream.rabbit.processor.MyProcessor;

/**   
 * @ClassName:  MultipleOutputsServiceApplicationIntegrationTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年5月11日 上午11:02:54
 * @version V1.0
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MultipleOutputsServiceApplication.class)
@DirtiesContext
public class MultipleOutputsServiceApplicationIntegrationTest {
	@Autowired
	private MyProcessor pipe;

	@Autowired
	private MessageCollector messageCollector;

	@Test
	public void whenSendMessage_thenResponseIsInAOutput() {
		whenSendMessage(1);
		thenPayloadInChannelIs(pipe.anOutput(), 1);
	}

	@Test
	public void whenSendMessage_thenResponseIsInAnotherOutput() {
		whenSendMessage(11);
		thenPayloadInChannelIs(pipe.anotherOutput(), 11);
	}

	private void whenSendMessage(Integer val) {
		pipe.myInput().send(MessageBuilder.withPayload(val).build());
	}

	private void thenPayloadInChannelIs(MessageChannel channel, Integer expectedValue) {
		Object payload = messageCollector.forChannel(channel).poll().getPayload();
		assertEquals(expectedValue, payload);
	}
}
