package zhumeng.com.uimei.config.datasource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import zhumeng.com.uimei.config.datasource.shares.ModuloDatabaseShardingAlgorithm;
import zhumeng.com.uimei.config.datasource.shares.ModuloTableShardingAlgorithm;

import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import com.github.pagehelper.PageHelper;

/**
 * @Title: DataSourceConfig.java
 * @Package zhumeng.com.uimei.config.datasource
 * @Description: TODO(用一句话描述该文件做什么)
 * @author z
 * @date 2018年7月4日
 * @version V1.0
 */
@Configuration
public class DataSourceConfig {

		 /**
	     * 配置数据源0，数据源的名称最好要有一定的规则，方便配置分库的计算规则
	     * @return
	     */
	    @Bean(name="dataSource0")
	    @ConfigurationProperties(prefix = "spring.datasource.db1")
	    public DataSource dataSource0(){
	        return DataSourceBuilder.create().build();
	    }
	    /**
	     * 配置数据源1，数据源的名称最好要有一定的规则，方便配置分库的计算规则
	     * @return
	     */
	    @Bean(name="dataSource1")
	    @ConfigurationProperties(prefix = "spring.datasource.db2")
	    public DataSource dataSource1(){
	        return DataSourceBuilder.create().build();
	    }
    
	    /**
	     * 配置数据源规则，即将多个数据源交给sharding-jdbc管理，并且可以设置默认的数据源，
	     * 当表没有配置分库规则时会使用默认的数据源
	     * @param dataSource0
	     * @param dataSource1
	     * @return
	     */
	    @Bean
	    public DataSourceRule dataSourceRule(@Qualifier("dataSource0") DataSource dataSource0,
	                                         @Qualifier("dataSource1") DataSource dataSource1){
	        Map<String, DataSource> dataSourceMap = new HashMap<>(); //设置分库映射
	        dataSourceMap.put("dataSource0", dataSource0);
	        dataSourceMap.put("dataSource1", dataSource1);
	        return new DataSourceRule(dataSourceMap, "dataSource0"); //设置默认库，两个库以上时必须设置默认库。默认库的数据源名称必须是dataSourceMap的key之一
	    }

	    /**
	     * 配置数据源策略和表策略，具体策略需要自己实现
	     * @param dataSourceRule
	     * @return
	     */
	    @Bean
	    public ShardingRule shardingRule(DataSourceRule dataSourceRule){
	        //具体分库分表策略
	    	//按id 分表
	    	 TableRule visitlogsTableRule = TableRule.builder("t_visit_logs")
		                .actualTables(Arrays.asList("t_visit_logs_0", "t_visit_logs_1"))
		                .dataSourceRule(dataSourceRule)
		                .build();
	    	 
	    	 //具体分库分表策略，按什么规则来分
		        ShardingRule shardingRule = ShardingRule.builder()
		                .dataSourceRule(dataSourceRule)
		                .tableRules(Arrays.asList(visitlogsTableRule))
		                .databaseShardingStrategy(new DatabaseShardingStrategy("id", new ModuloDatabaseShardingAlgorithm()))
		                .tableShardingStrategy(new TableShardingStrategy("id", new ModuloTableShardingAlgorithm())).build();
				
		        return shardingRule;

	    }

	    /**
	     * 创建sharding-jdbc的数据源DataSource，MybatisAutoConfiguration会使用此数据源
	     * @param shardingRule
	     * @return
	     * @throws SQLException
	     */
	    @Bean(name="dataSource")
	    public DataSource shardingDataSource(ShardingRule shardingRule) throws SQLException {
	        return ShardingDataSourceFactory.createDataSource(shardingRule);
	    }
		/**
	     * 需要手动配置事务管理器
	     * @param dataSource
	     * @return
	     */
	    @Bean
	    public DataSourceTransactionManager transactitonManager(@Qualifier("dataSource") DataSource dataSource){
	        return new DataSourceTransactionManager(dataSource);
	    }

	    @Bean(name = "testSqlSessionFactory")
	    @Primary
	    public SqlSessionFactory testSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
	    	SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
			sqlSessionFactoryBean.setDataSource(dataSource);
			
			PageHelper pageHelper = new PageHelper(); 
			Properties properties = new Properties();
			properties.setProperty("reasonable", "true");
			properties.setProperty("supportMethodsArguments", "true");
			properties.setProperty("returnPageInfo", "check"); 
			properties.setProperty("params", "count=countSql");
			pageHelper.setProperties(properties);
			sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});
			
			PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/zhumeng/com/uimei/dao/*/mapping/*.xml")); // "**"代表多个文件夹下
			return sqlSessionFactoryBean.getObject();
	    }
	    
	    
//	    private static DataSource createDataSource(final String dataSourceName) {
//	        //使用druid连接数据库
//	        DruidDataSource result = new DruidDataSource();
//	        result.setDriverClassName(Driver.class.getName());
//	        result.setUrl(String.format("jdbc:mysql://localhost:3306/%s", dataSourceName));
//	        result.setUsername("root");
//	        result.setPassword("");
//	        return result;
//	    }
}
