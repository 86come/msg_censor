package xyz.onezylee.censor.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {

    @Bean
    public MybatisSqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean;
    }
}

