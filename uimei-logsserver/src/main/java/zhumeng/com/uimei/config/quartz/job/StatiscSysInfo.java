package zhumeng.com.uimei.config.quartz.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @Title: StatiscSysInfo.java
 * @Package zhumeng.com.uimei.config.quartz.job
 * @Description: 定时上报系统信息
 * @author z
 * @date 2018年6月29日
 * @version V1.0
 */
@Component
@EnableScheduling
public class StatiscSysInfo{
	
	public final static Logger log = LoggerFactory.getLogger(StatiscSysInfo.class);

	

//	@Scheduled(cron = "0/30 * * * * ?")
//	@Scheduled(cron = "0 0/10 * * * ?")
	public void orderStatusJoRun() throws Exception{
		log.error("开始处理超过n小时未支付的订单======");
		
	}


}
