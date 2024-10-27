package gaur.example.in.sql;

import java.util.HashMap;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "MysqlBean",
                        transactionManagerRef = "mySqlTransactionManager",
                        basePackages = "gaur.example.in.dao.repo.sql")
public class SqlConfig {
	
	@Bean
	@ConfigurationProperties("db1.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "MysqlBean")
	public LocalContainerEntityManagerFactoryBean MysqlBean(EntityManagerFactoryBuilder builder) {
		HashMap<String, Object> properties = new HashMap<>();
	    properties.put("hibernate.hbm2ddl.auto", "update");
	    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    properties.put("hibernate.show_sql", "true");
	    properties.put("hibernate.format_sql", "true");
		return builder.
				dataSource(dataSource()).
				packages(" gaur.example.in.entity.sql").
				properties(properties).
				persistenceUnit("jdbc:mysql://localhost:3306/hostel").
				build();
	}
	
	@Bean("mySqlTransactionManager")
	public PlatformTransactionManager mySqlTransactionManager( @Qualifier("MysqlBean")
			                                                  LocalEntityManagerFactoryBean factory) {
		return mySqlTransactionManager(factory);
		
	}
}
