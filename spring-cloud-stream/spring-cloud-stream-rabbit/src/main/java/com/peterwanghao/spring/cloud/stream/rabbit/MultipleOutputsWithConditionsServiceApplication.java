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
 * @ClassName:  MultipleOutputsWithConditionsServiceApplication
 * @Description:主程序类，根据消息体内容通过表达式判断返回到不同的输出队列。
 * @author: wanghao
 * @date:   2018年5月11日 上午10:51:36
 * @version V1.0
 * 
 */
@SpringBootApplication
@EnableBinding(MyProcessor.class)
public class MultipleOutputsWithConditionsServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MultipleOutputsWithConditionsServiceApplication.class, args);
	}

	@Autowired
	private MyProcessor processor;

	@StreamListener(target = MyProcessor.INPUT, condition = "payload < 10")
	public void routeValuesToAnOutput(Integer val) {
		processor.anOutput().send(message(val));
	}

	@StreamListener(target = MyProcessor.INPUT, condition = "payload >= 10")
	public void routeValuesToAnotherOutput(Integer val) {
		processor.anotherOutput().send(message(val));
	}

	private static final <T> Message<T> message(T val) {
		return MessageBuilder.withPayload(val).build();
	}
}
