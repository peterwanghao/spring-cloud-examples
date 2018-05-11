package com.peterwanghao.spring.cloud.stream.rabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import com.peterwanghao.spring.cloud.stream.rabbit.processor.MyProcessor;

/**   
 * @ClassName:  MultipleOutputsServiceApplication
 * @Description:主程序类，根据接收的数据返回到不同的输出队列。
 * @author: wanghao
 * @date:   2018年5月11日 上午10:48:53
 * @version V1.0
 * 
 */
@SpringBootApplication
@EnableBinding(MyProcessor.class)
public class MultipleOutputsServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MultipleOutputsServiceApplication.class, args);
	}

	@Autowired
	private MyProcessor processor;

	@StreamListener(MyProcessor.INPUT)
	public void routeValues(Integer val) {
		if (val < 10) {
			processor.anOutput().send(message(val));
		} else {
			processor.anotherOutput().send(message(val));
		}
	}

	private static final <T> Message<T> message(T val) {
		return MessageBuilder.withPayload(val).build();
	}
}
