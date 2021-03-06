package zhumeng.com.uimei.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @Title: HttpSessionConfig.java
 * @Package zhumeng.com.uimei.config
 * @Description: 替换httpSession(用一句话描述该文件做什么)
 * @author z
 * @date 2018年6月29日
 * @version V1.0
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 30*60)
public class HttpSessionConfig {

	    @Value("${server.session.timeout}")
	    private int sessionTimeout = 1800;
	 
	    @Primary
	    @Bean
	    public RedisOperationsSessionRepository sessionRepository(
	        @Qualifier("sessionRedisTemplate") RedisOperations<Object, Object> sessionRedisTemplate,
	        ApplicationEventPublisher applicationEventPublisher) {
	        RedisOperationsSessionRepository sessionRepository = new RedisOperationsSessionRepository(sessionRedisTemplate);
	        sessionRepository.setApplicationEventPublisher(applicationEventPublisher);
	        sessionRepository.setDefaultMaxInactiveInterval(sessionTimeout);
	        return sessionRepository;
	    }

}
