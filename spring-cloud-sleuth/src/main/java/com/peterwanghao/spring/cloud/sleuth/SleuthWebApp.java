package com.peterwanghao.spring.cloud.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**   
 * @ClassName:  SleuthWebApp
 * @Description:Spring Boot主应用类
 * @author: wanghao
 * @date:   2018年4月11日 上午11:02:19
 * @version V1.0
 * 
 */
@SpringBootApplication
public class SleuthWebApp {
	public static void main(String[] args) {
		SpringApplication.run(SleuthWebApp.class, args);
    }
}
