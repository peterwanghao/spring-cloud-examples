package com.peterwanghao.spring.cloud.archaius.dynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**   
 * @ClassName:  ArchaiusProperties
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2018年11月20日 下午4:55:46
 * @version V1.0
 * 
 */
@Getter
@Setter
@AllArgsConstructor
@DynamoDBTable(tableName = "archaiusProperties")
public class ArchaiusProperties {

	@DynamoDBHashKey
	@DynamoDBAttribute
	private String key;

	@DynamoDBAttribute
	private String value;
}
