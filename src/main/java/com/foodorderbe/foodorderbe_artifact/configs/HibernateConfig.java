package com.foodorderbe.foodorderbe_artifact.configs;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;

@Configuration
@PropertySource("classpath:application.properties")
public class HibernateConfig {
    @Autowired
    private Environment env;

    @Bean(name="entityManagerFactory")
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setPackagesToScan(new String[] {
                "com.foodorderbe.foodorderbe_artifact.entities"

        });
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties props = new Properties();
        props.put(SHOW_SQL, env.getProperty("spring.jpa.show-sql"));
        return props;
    }

}
