package com.devglan.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.devglan.model.FederationProfileEntity;
import com.devglan.model.Processing_JsonEntity;
import com.devglan.model.UserDetails;

@Configuration
@EnableJpaRepositories(
		entityManagerFactoryRef = "tenantEntityManager", 
		transactionManagerRef = "tenantTransactionManager", 
		basePackages = "com.devglan.tenant.dao"
)
public class TenantDBConfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.tenant.datasource")
	public DataSource postgresqlDataSource() {
		return DataSourceBuilder
					.create()
					.build();
	}

	@Bean(name = "tenantEntityManager")
	public LocalContainerEntityManagerFactoryBean postgresqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder
					.dataSource(postgresqlDataSource())
					.properties(hibernateProperties())
					.packages(UserDetails.class).packages(Processing_JsonEntity.class).packages(FederationProfileEntity.class)
					.persistenceUnit("tenantPU")
					.build();
	}

	@Bean(name = "tenantTransactionManager")
	public PlatformTransactionManager postgresqlTransactionManager(@Qualifier("tenantEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	private Map<String, Object> hibernateProperties() {

		Resource resource = new ClassPathResource("hibernate.properties");
		
		try {
			Properties properties = PropertiesLoaderUtils.loadProperties(resource);
			
			return properties.entrySet().stream()
											.collect(Collectors.toMap(
														e -> e.getKey().toString(),
														e -> e.getValue())
													);
		} catch (IOException e) {
			return new HashMap<String, Object>();
		}
	}
	
	
}
