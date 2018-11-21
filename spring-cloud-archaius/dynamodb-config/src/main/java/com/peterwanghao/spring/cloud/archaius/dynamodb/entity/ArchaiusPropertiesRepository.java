package com.peterwanghao.spring.cloud.archaius.dynamodb.entity;

import org.springframework.data.repository.CrudRepository;

/**   
 * @ClassName:  ArchaiusPropertiesRepository
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年11月20日 下午4:57:16
 * @version V1.0
 * 
 */
public interface ArchaiusPropertiesRepository extends CrudRepository<ArchaiusProperties, String> {

}
