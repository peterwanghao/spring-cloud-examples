package com.peterwanghao.spring.cloud.stream.rabbit.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**   
 * @ClassName:  MyProcessor
 * @Description:自定义处理器，创建一个输入两个输出的通道
 * @author: wanghao
 * @date:   2018年5月11日 上午10:43:42
 * @version V1.0
 * 
 */
public interface MyProcessor {
	String INPUT = "myInput";

	@Input
	SubscribableChannel myInput();

	@Output("myOutput")
	MessageChannel anOutput();

	@Output
	MessageChannel anotherOutput();
}
