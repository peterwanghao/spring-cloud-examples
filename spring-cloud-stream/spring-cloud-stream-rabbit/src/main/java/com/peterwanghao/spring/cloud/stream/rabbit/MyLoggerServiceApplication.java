package com.peterwanghao.spring.cloud.stream.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

import com.peterwanghao.spring.cloud.stream.rabbit.model.LogMessage;
/**   
 * @ClassName:  MyLoggerServiceApplication
 * @Description:主程序类，监听消息并按一定格式返回
 * @author: wanghao
 * @date:   2018年5月11日 上午10:31:26
 * @version V1.0
 * 
 */
@SpringBootApplication
@EnableBinding(Processor.class)
public class MyLoggerServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyLoggerServiceApplication.class, args);
	}

	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public LogMessage enrichLogMessage(LogMessage log) {
		return new LogMessage(String.format("[1]: %s", log.getMessage()));
	}
}
