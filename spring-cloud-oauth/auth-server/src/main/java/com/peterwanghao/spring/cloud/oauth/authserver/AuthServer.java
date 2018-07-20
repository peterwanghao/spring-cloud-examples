package com.peterwanghao.spring.cloud.oauth.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;

/**   
 * @ClassName:  AuthServer
 * @Description:OAuth认证服务
 * @author: wanghao
 * @date:   2018年7月19日 下午2:21:34
 * @version V1.0
 * 
 */
@SpringBootApplication
public class AuthServer {

    public static void main(String[] args) {
        SpringApplication.run(AuthServer.class, args);
    }
}
