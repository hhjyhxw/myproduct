package zhumeng.com.uimei.kafka;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import zhumeng.com.uimei.model.logs.VisitLogs;



/**
 * @Title: Test.java
 * @Package zhumeng.com.uimei.kafka
 * @Description: TODO(用一句话描述该文件做什么)
 * @author z
 * @date 2018年7月2日
 * @version V1.0
 */
public class Test {
//	public static void main(String[] args){
//		ProducerThreadPool pro = new ProducerThreadPool();
//		VisitLogs vl = null;
//		for (int i = 0; i < 30; i++) {
//			vl = new VisitLogs();
//			 vl.setId(System.currentTimeMillis()+i);
//			vl.setMethedName(Thread.currentThread().getName()+"_methed_"+System.currentTimeMillis());
//			  vl.setVisitDatetime(new Date().toString());
//			 List<VisitLogs> asList = Arrays.asList(vl);
//			 pro.getTaskExecutor().execute(new KafkaProductServer("visitLogs",vl.getId().toString(),asList));
//		}
//	}
//	
//	public static void main(String[] args){
//		ProducerThreadPool pro = new ProducerThreadPool();
//		VisitLogs vl = null;
//		for (int i = 0; i < 2; i++) {
//			vl = new VisitLogs();
//			 vl.setId(System.currentTimeMillis());
//			vl.setMethedName(Thread.currentThread().getName()+"_methed_"+System.currentTimeMillis());
//			  vl.setVisitDatetime(new Date().toString());
//			 List<VisitLogs> asList = Arrays.asList(vl);
//			 pro.getTaskExecutor().execute(new KafkaConsumerServer("visitLogs"));
//		}
//	}
}
