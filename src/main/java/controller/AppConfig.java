package controller;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="contorller")
public class AppConfig {
	@Bean
	public Date CreateDate() {
		return new Date();
	}
	
}
