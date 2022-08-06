package com.infortech.Bazar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BazarApplication {

	public static void main(String[] args) {
		SpringApplication.run(BazarApplication.class, args);
	}

}
