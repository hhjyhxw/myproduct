package zhumeng.com.uimei.kafka.serialization;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

/**
 * @Title: DecodeingKafka.java
 * @Package zhumeng.com.uimei.interfaces.kafka
 * @Description:对象反序列化实现(用一句话描述该文件做什么)
 * @author z
 * @date 2018年7月2日
 * @version V1.0
 */
public class DecodeingKafka implements Deserializer<Object>{

	@Override
	public void close() {
		
	}

	
	@Override
	public void configure(Map<String, ?> arg0, boolean arg1) {
		
	}

	@Override
	public Object deserialize(String topic, byte[] data) {
		return SerializationBeanUtils.byte2Obj(data);
	}

}
