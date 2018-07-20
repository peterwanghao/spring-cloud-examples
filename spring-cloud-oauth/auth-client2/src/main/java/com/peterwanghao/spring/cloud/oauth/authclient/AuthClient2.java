package com.peterwanghao.spring.cloud.oauth.authclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.peterwanghao.spring.cloud.oauth.authclient.filters.SimpleFilter;

/**   
 * @ClassName:  Application
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年7月19日 下午3:21:27
 * @version V1.0
 * 
 */
@SpringBootApplication
public class AuthClient2 {
	public static void main(String[] args) {
        SpringApplication.run(AuthClient2.class, args);
    }    
    
    @Bean
    public SimpleFilter simpleFilter() {
      return new SimpleFilter();
    } 
}
