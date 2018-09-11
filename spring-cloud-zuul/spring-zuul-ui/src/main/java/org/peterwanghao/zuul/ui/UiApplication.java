package org.peterwanghao.zuul.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**   
 * @ClassName:  UiApplication
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年9月11日 上午9:58:33
 * @version V1.0
 * 
 */
@EnableZuulProxy
@SpringBootApplication
public class UiApplication  extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(UiApplication.class, args);
    }
}
