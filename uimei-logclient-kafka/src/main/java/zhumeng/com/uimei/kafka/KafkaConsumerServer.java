package zhumeng.com.uimei.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zhumeng.com.uimei.kafka.model.VisitLogs;

/**
 * @Title: KafkaConsumerServer.java
 * @Package zhumeng.com.uimei
 * @Description: TODO(用一句话描述该文件做什么)
 * @author z
 * @date 2018年7月2日
 * @version V1.0
 */
public class KafkaConsumerServer implements  Runnable{

	private static final Logger log = LoggerFactory.getLogger(KafkaConsumerServer.class);
	private String topic;
	public KafkaConsumerServer(){}
	public KafkaConsumerServer( String topic){
		this.topic=topic;
	}
	public static Properties props = null;
	static{
		 props = new Properties();
		 /* 定义kakfa 服务的地址，不需要将所有broker指定上 */
		 props.put("bootstrap.servers", ConfigUtil.get("bootstrap.servers"));
		 /* 制定consumer group */
	     props.put("group.id",ConfigUtil.get("group.id")!=null?ConfigUtil.get("group.id"):"test-consumer-group");
	     /* 是否自动确认offset */
	     props.put("enable.auto.commit", ConfigUtil.get("enable.auto.commit")!=null?ConfigUtil.get("enable.auto.commit"):"false");
	     /* 自动确认offset的时间间隔 */
	     props.put("auto.commit.interval.ms",ConfigUtil.get("auto.commit.interval.ms")!=null?ConfigUtil.get("auto.commit.interval.ms"):"1000");
	
	     /* key的序列化类 */
	 	if(ConfigUtil.get("key.deserializer")!=null){
			props.put("key.deserializer", ConfigUtil.get("key.deserializer"));
		}else{
			 props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		}
	 	  /* value的序列化类 */
		 if(ConfigUtil.get("consumer.value.deserializer")!=null){
			 props.put("value.deserializer",ConfigUtil.get("consumer.value.deserializer"));
		 }else{
			 props.put("value.deserializerr","zhumeng.com.uimei.kafka.serialization.DecodeingKafka");
		 }
		 
//           props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
           props.put("key.deserializer.encoding", "UTF8");
           props.put("value.deserializer.encoding", "UTF8");
	}
	
	@Override
	public void run() {
		KafkaConsumer<String, Object> consumer = createKafkaConsumer();
	    consumer.subscribe(Arrays.asList(topic));
	    ConsumerRecords<String, Object> records = consumer.poll(10000);
        for (ConsumerRecord<String, Object> record : records){
        	if(record!=null && record.value()!=null){
        		log.info(record.value().toString());
//        		record.topic()
        		if("visitLogs".equals(record.topic())){
        			VisitLogs visitLogs = (VisitLogs) record.value();
        			log.info("==================="+visitLogs.getVisitUrl());
        		}
        	}
        }
        consumer.commitSync();
	}
	
	private   KafkaConsumer<String, Object> createKafkaConsumer(){
		return new KafkaConsumer<String, Object>(props);
	}
}
