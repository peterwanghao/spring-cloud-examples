package com.peterwanghao.spring.cloud.oauth.authclient.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**   
 * @ClassName:  SiteSecurityConfigurer
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年7月19日 下午3:25:03
 * @version V1.0
 * 
 */
@EnableZuulProxy
@Configuration
@EnableOAuth2Sso
public class SiteSecurityConfigurer
    extends
        WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http)
        throws Exception {
        http.antMatcher("/**")
            .authorizeRequests()
            .antMatchers("/", "/webjars/**")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .logout()
            .logoutSuccessUrl("/")
            .permitAll()
            .and()
            .csrf()
            .csrfTokenRepository(
                CookieCsrfTokenRepository
                    .withHttpOnlyFalse());
    }

    @Bean
    public OAuth2RestOperations restOperations(
        OAuth2ProtectedResourceDetails resource,
        OAuth2ClientContext context) {
        return new OAuth2RestTemplate(resource, context);
    }

}
