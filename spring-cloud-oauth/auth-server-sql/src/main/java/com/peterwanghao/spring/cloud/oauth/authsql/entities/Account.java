package com.peterwanghao.spring.cloud.oauth.authsql.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**   
 * @ClassName:  Account
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年7月25日 下午2:43:21
 * @version V1.0
 * 
 */
@Entity
public class Account {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "username", length = 128)
	private String username;
	@Column(name = "password", length = 128)
	private String password;

	public Account() {
	}

	public Account(String username, String password) {

		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
