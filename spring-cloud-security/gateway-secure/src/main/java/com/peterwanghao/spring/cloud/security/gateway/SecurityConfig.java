package com.peterwanghao.spring.cloud.security.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**   
 * @ClassName:  SecurityConfig
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年5月2日 上午11:18:50
 * @version V1.0
 * 
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("peter").password("123456").roles("USER").and().withUser("admin")
				.password("admin").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().defaultSuccessUrl("/home/index.html", true).and().authorizeRequests()
				.antMatchers("/book-service/**", "/rating-service/**", "/login*", "/").permitAll()
				.antMatchers("/eureka/**").hasRole("ADMIN").anyRequest().authenticated().and().logout().and().csrf()
				.disable();
	}
}
