package gaur.example.in.postgres;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "PostgresEntityManager",
                        transactionManagerRef = "PostgresTransactionManager",
                        basePackages = "gaur.example.in.dao.repo.postgres")
@EnableTransactionManagement
public class PostgresConfig {
	
	@Bean(name = "PostgresdataSource")
	@ConfigurationProperties("db2.datasource")
	public DataSource PostgresdataSource() {
		return DataSourceBuilder.create().build();
	}
	
//
//	@Bean(name = "PostgresEntityManager")
//	public LocalContainerEntityManagerFactoryBean PostgresEntityManager(@Qualifier("PostgresdataSource") EntityManagerFactoryBuilder
//			entityManagerFactoryBuilder) {
//		HashMap<String, Object> properties = new HashMap<>();
//	    properties.put("hibernate.hbm2ddl.auto", "update");
//	    properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//	    properties.put("hibernate.show_sql", "true");
//	    properties.put("hibernate.format_sql", "true");
//		return entityManagerFactoryBuilder.
//				dataSource(PostgresdataSource()).
//				packages(" gaur.example.in.entity.postgres").
//				properties(properties).
//				persistenceUnit("jdbc:postgresql://localhost:5432/db1").
//				build();
//	}
	@Autowired
	//private EntityManagerFactoryBuilder entityManagerFactoryBuilder;

	@Bean(name = "PostgresEntityManager")
	 public LocalContainerEntityManagerFactoryBean PostgresEntityManager(
	            @Qualifier("PostgresdataSource") DataSource dataSource) {
	        HashMap<String, Object> properties = new HashMap<>();
	        properties.put("hibernate.hbm2ddl.auto", "update");
	        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
	        properties.put("hibernate.show_sql", "true");
	        properties.put("hibernate.format_sql", "true");

	        return new LocalContainerEntityManagerFactoryBean() {{
	            setDataSource(dataSource);
	            setPackagesToScan("gaur.example.in.entity.postgres");
	            setJpaPropertyMap(properties);
	        }};
	    }

	
	
	@Bean(name = "PostgresTransactionManager")
	public PlatformTransactionManager PostgresTransactionManager( @Qualifier("PostgresEntityManager")
			                                                  LocalContainerEntityManagerFactoryBean factory) {
		 return new JpaTransactionManager(factory.getObject());
		
	}

}
