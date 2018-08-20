package com.peterwanghao.spring.cloud.hystrix.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**   
 * @ClassName:  DashboardTurbineApplication
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年8月20日 下午2:48:17
 * @version V1.0
 * 
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
public class DashboardTurbineApplication {
	public static void main(String[] args) {
		SpringApplication.run(DashboardTurbineApplication.class, args);
	}
}
