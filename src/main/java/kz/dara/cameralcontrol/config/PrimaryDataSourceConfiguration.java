package kz.dara.cameralcontrol.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "primaryEntityManagerFactory",
        transactionManagerRef = "primaryTransactionManager",
        basePackages = {"kz.dara.cameralcontrol.repository.primaryDataSourse"})
public class PrimaryDataSourceConfiguration {
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.driverClassName}")
    String driverClassName;

    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().username(username)
                .password(password).url(url)
                .build();
    }

    @Bean
    @Primary
    @Qualifier("primaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory() {

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(primaryDataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan("kz.dara.cameralcontrol.model");
        return entityManagerFactoryBean;
    }

    @Primary
    @Bean(name = "primaryTransactionManager")
    public PlatformTransactionManager primaryTransactionManager(
            @Qualifier("primaryEntityManagerFactory") EntityManagerFactory primaryEntityManagerFactory) {

        return new JpaTransactionManager(primaryEntityManagerFactory);
    }
}








































//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "primaryEntityManagerFactory",
//        transactionManagerRef = "primaryTransactionManager",
//        basePackages = {"kz.dara.marapat.repository.local"})
//public class PrimaryDataSourceConfiguration {
//
//    @Value("${spring.datasource.username}")
//    String username;
//    @Value("${spring.datasource.password}")
//    String password;
//    @Value("${spring.datasource.url}")
//    String url;
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.liquibase")
//    public LiquibaseProperties liquibaseProperties() {
//        return new LiquibaseProperties();
//    }
//
//    @Bean
//    @Primary
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().username(username)
//                .password(password).url(url)
//                .driverClassName("org.postgresql.Driver")
//                .build();
//    }
//
//    @Bean
//    @Primary
//    @Qualifier("primaryEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory() {
//
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(dataSource());
//        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//        entityManagerFactoryBean.setPackagesToScan("kz.dara.marapat.model.local");
//        return entityManagerFactoryBean;
//    }
//
//    @Primary
//    @Bean(name = "primaryTransactionManager")
//    public PlatformTransactionManager primaryTransactionManager(
//            @Qualifier("primaryEntityManagerFactory") EntityManagerFactory primaryEntityManagerFactory) {
//
//        return new JpaTransactionManager(primaryEntityManagerFactory);
//    }
//
//
//    @Bean
//    public SpringLiquibase primaryLiquibase() {
//        return springLiquibase(dataSource(), liquibaseProperties());
//    }
//
//    private static SpringLiquibase springLiquibase(DataSource dataSource, LiquibaseProperties properties) {
//        SpringLiquibase liquibase = new SpringLiquibase();
//        liquibase.setDataSource(dataSource);
//        liquibase.setChangeLog(properties.getChangeLog());
//        liquibase.setContexts(properties.getContexts());
//        liquibase.setDefaultSchema(properties.getDefaultSchema());
//        liquibase.setDropFirst(properties.isDropFirst());
//        liquibase.setShouldRun(properties.isEnabled());
//        liquibase.setLabels(properties.getLabels());
//        liquibase.setChangeLogParameters(properties.getParameters());
//        liquibase.setRollbackFile(properties.getRollbackFile());
//        return liquibase;
//    }
//}
