package com.peterwanghao.spring.cloud.oauth.authsql.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

/**   
 * @ClassName:  AppConfig
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年7月25日 下午2:08:03
 * @version V1.0
 * 
 */
@Configuration
public class AppConfig {
	@Value("${spring.datasource.url}")
    private String datasourceUrl;
    
    @Value("${spring.database.driverClassName}")
    private String dbDriverClassName;
    
    @Value("${spring.datasource.username}")
    private String dbUsername;
    
    @Value("${spring.datasource.password}")
    private String dbPassword;
    
    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        dataSource.setDriverClassName(dbDriverClassName);
        dataSource.setUrl(datasourceUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        
        return dataSource;
    }
    
    @Bean
    public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource());
    }
}
