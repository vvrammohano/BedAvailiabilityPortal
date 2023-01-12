package com.userview.userveiwmicroservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserveiwMicroserviceApplication implements CommandLineRunner {




	public static void main(String[] args) {
		SpringApplication.run(UserveiwMicroserviceApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate(){
		return  new RestTemplate();
	}
	@Override
	public void run(String... args) throws Exception {

	}

}
