package zhumeng.com.uimei.kafka.serialization;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: EncodeingKafka.java
 * @Package zhumeng.com.uimei.interfaces.kafka
 * @Description: 对象序列化(用一句话描述该文件做什么)
 * @author z
 * @date 2018年7月2日
 * @version V1.0
 */
public class EncodeingKafka implements Serializer<Object>{

	private static Logger logger = LoggerFactory.getLogger(EncodeingKafka.class);

	@Override
	public void close() {
		logger.info("EncodeingKafka is close");
	}

	
	@Override
	public void configure(Map<String, ?> arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public byte[] serialize(String topic, Object data) {
		// TODO Auto-generated method stub
		return SerializationBeanUtils.bean2Byte(data);
	}

}
