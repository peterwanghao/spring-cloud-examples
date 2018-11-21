package com.peterwanghao.spring.cloud.archaius.jdbc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**   
 * @ClassName:  Properties
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年11月20日 下午4:36:35
 * @version V1.0
 * 
 */
@Entity
public class Properties {

	@Id
	private String key;

	@SuppressWarnings("unused")
	private String value;
}
