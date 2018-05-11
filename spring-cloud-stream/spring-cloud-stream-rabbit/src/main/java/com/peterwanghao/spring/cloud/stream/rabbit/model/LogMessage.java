package com.peterwanghao.spring.cloud.stream.rabbit.model;

import java.io.Serializable;

/**   
 * @ClassName:  LogMessage
 * @Description:消息类
 * @author: wanghao
 * @date:   2018年5月11日 上午10:33:55
 * @version V1.0
 * 
 */
public class LogMessage implements Serializable {

	private static final long serialVersionUID = 1194171350176151128L;
	private String message;

	public LogMessage() {

	}

	public LogMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
