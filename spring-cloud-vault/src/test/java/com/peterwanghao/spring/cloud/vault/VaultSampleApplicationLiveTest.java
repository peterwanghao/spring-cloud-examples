package com.peterwanghao.spring.cloud.vault;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

/**   
 * @ClassName:  VaultSampleApplicationLiveTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年10月18日 下午4:58:49
 * @version V1.0
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class VaultSampleApplicationLiveTest {

	@Autowired
	Environment env;

	@Autowired
	DataSource datasource;

	//@Test
	public void whenGenericBackendEnabled_thenEnvHasAccessToVaultSecrets() {

		String keyValue = env.getProperty("api_key");
		assertEquals("abc1234", keyValue);

	}

	//@Test
	public void whenKvBackendEnabled_thenEnvHasAccessToVaultSecrets() {

		String secretValue = env.getProperty("api_secret");
		assertEquals("1a2b3c4d", secretValue);

	}

	@Test
	public void whenDatabaseBackendEnabled_thenDatasourceUsesVaultCredentials() {

		try (Connection c = datasource.getConnection()) {

			ResultSet rs = c.createStatement().executeQuery("select 1");

			rs.next();
			Long value = rs.getLong(1);

			assertEquals(Long.valueOf(1), value);

		} catch (SQLException sex) {
			throw new RuntimeException(sex);
		}

	}

}
