package com.finex.cloudera.web.configures;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by lordorr on 2017/3/17.
 */
@Configuration
public class DruidDataSourceConfig  implements EnvironmentAware {

    private RelaxedPropertyResolver propertyResolver;

    public void setEnvironment(Environment env) {
        this.propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
    }

    /**
     * Created By Lordorr At 2017.03.22
     * Goal:创建数据库连接池，并托管在spring中
     * Primary:表示有有多个数据库连接池时，优先使用druid连接池
     * @return dataSource 返回数据连接池实例
     */
    @Bean
    @Primary
    public DataSource dataSource() {
        System.out.println("注入druid！！！");
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(propertyResolver.getProperty("url"));
        datasource.setDriverClassName(propertyResolver.getProperty("driver-class-name"));
        datasource.setUsername(propertyResolver.getProperty("username"));
        datasource.setPassword(propertyResolver.getProperty("password"));
        datasource.setInitialSize(Integer.valueOf(propertyResolver.getProperty("druid.initial-size")));
        datasource.setMinIdle(Integer.valueOf(propertyResolver.getProperty("druid.min-idle")));
        datasource.setMaxWait(Long.valueOf(propertyResolver.getProperty("druid.max-wait")));
        datasource.setMaxActive(Integer.valueOf(propertyResolver.getProperty("druid.max-active")));
        datasource.setMinEvictableIdleTimeMillis(Long.valueOf(propertyResolver.getProperty("druid.min-evictable-idle-time-millis")));
        datasource.setPoolPreparedStatements(Boolean.valueOf(propertyResolver.getProperty("druid.pool-prepared-statement")));
        datasource.setMaxPoolPreparedStatementPerConnectionSize(Integer.valueOf(propertyResolver.getProperty("druid.max-pool-prepared-statement-per-connection-size")));
        datasource.setValidationQuery(propertyResolver.getProperty("druid.validation-query"));
        //datasource.setFilters(propertyResolver.getProperty("filters"));
        // datasource.setConnectProperties(propertyResolver.getProperty("druid.connection-properties"));
        datasource.setUseGlobalDataSourceStat(Boolean.valueOf(propertyResolver.getProperty("druid.use-global-datasource-stat")));
        try {
            datasource.setFilters("stat,wall");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datasource;
    }
}

