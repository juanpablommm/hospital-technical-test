package com.technical.test.hospital.infraestructure;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfig {

	@Bean
	public Flyway flyway(DataSource dataSource) {
		Flyway flyway = Flyway.configure().dataSource(dataSource).locations("classpath:db/migrations")
				.baselineOnMigrate(true).validateMigrationNaming(true).validateOnMigrate(true).cleanDisabled(true)
				.load();
		flyway.migrate();
		return flyway;
	}
}