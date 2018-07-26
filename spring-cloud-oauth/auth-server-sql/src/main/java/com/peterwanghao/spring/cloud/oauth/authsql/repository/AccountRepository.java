package com.peterwanghao.spring.cloud.oauth.authsql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peterwanghao.spring.cloud.oauth.authsql.entities.Account;

import java.util.Optional;

/**   
 * @ClassName:  AccountRepository
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年7月25日 下午2:41:42
 * @version V1.0
 * 
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findByUsername(String username);
}
