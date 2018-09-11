package org.peterwanghao.zuul.resource.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**   
 * @ClassName:  ResourceServerWebConfig
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年9月11日 上午9:34:23
 * @version V1.0
 * 
 */
@Configuration
@EnableWebMvc
@ComponentScan({ "org.peterwanghao.zuul.resource.web.controller" })
public class ResourceServerWebConfig extends WebMvcConfigurerAdapter {

}
