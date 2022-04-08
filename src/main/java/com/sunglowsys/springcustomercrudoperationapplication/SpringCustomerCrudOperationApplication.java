package com.sunglowsys.springcustomercrudoperationapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.sunglowsys.domain")
@EnableJpaRepositories(basePackages = "com.sunglowsys.repository")
@ComponentScan(basePackages = "com.sunglowsys")
public class SpringCustomerCrudOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCustomerCrudOperationApplication.class, args);
	}

}
