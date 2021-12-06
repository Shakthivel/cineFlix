package com.cineFlix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cineFlix.service.UserService;

@SpringBootApplication
@ComponentScan("com.cineFlix")
public class CineFlixApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CineFlixApplication.class, args);
	}

}
