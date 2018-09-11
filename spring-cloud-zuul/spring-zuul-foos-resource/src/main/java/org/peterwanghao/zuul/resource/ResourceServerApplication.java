package org.peterwanghao.zuul.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**   
 * @ClassName:  ResourceServerApplication
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年9月11日 上午9:32:25
 * @version V1.0
 * 
 */
@SpringBootApplication
public class ResourceServerApplication  extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(ResourceServerApplication.class, args);
    }
}
