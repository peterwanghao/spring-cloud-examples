package com.peterwanghao.spring.cloud.oauth.authsql.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import com.peterwanghao.spring.cloud.oauth.authsql.repository.AccountRepository;
import com.peterwanghao.spring.cloud.oauth.authsql.service.AccountUserDetailsService;

/**   
 * @ClassName:  WebSecurityConfigurer
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年7月25日 下午5:01:12
 * @version V1.0
 * 
 */
@Configuration
@EnableWebSecurity
@EnableOAuth2Client
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
	@Autowired
	private AccountRepository accountRepository;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login**").permitAll().anyRequest().authenticated().and().csrf().and()
				.formLogin().loginPage("/login");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceBean());
	}

	@Override
	@Bean(name = "userDetailsService")
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return new AccountUserDetailsService(accountRepository);
	}

}
