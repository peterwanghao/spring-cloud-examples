package com.peterwanghao.spring.cloud.oauth.authsql.config;

import java.security.KeyPair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

/**   
 * @ClassName:  AuthServerOAuth2Config
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年7月25日 下午5:02:22
 * @version V1.0
 * 
 */
@Configuration
@EnableAuthorizationServer
@Order(6)
public class AuthServerOAuth2Config extends AuthorizationServerConfigurerAdapter {
	private final AuthenticationManager authenticationManager;
    private final AppConfig appConfig;
    
	@Value("${jwt.certificate.store.file}")
	private Resource keystore;

	@Value("${jwt.certificate.store.password}")
	private String keystorePassword;

	@Value("${jwt.certificate.key.alias}")
	private String keyAlias;

	@Value("${jwt.certificate.key.password}")
	private String keyPassword;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
    public AuthServerOAuth2Config(AuthenticationManager authenticationManager, AppConfig appConfig) {
        this.authenticationManager = authenticationManager;
        this.appConfig = appConfig;
    }
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.jdbc(appConfig.dataSource());
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.accessTokenConverter(jwtAccessTokenConverter()).userDetailsService(userDetailsService);
		endpoints
         .authenticationManager(authenticationManager)
         .tokenStore(appConfig.tokenStore()); // Persist the tokens in the database
	}

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(keystore, keystorePassword.toCharArray());
		KeyPair keyPair = keyStoreKeyFactory.getKeyPair(keyAlias, keyPassword.toCharArray());
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setKeyPair(keyPair);
		return converter;
	}
}
