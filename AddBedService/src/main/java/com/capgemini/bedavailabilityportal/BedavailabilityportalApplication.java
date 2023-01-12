package com.capgemini.bedavailabilityportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
@Component
public class BedavailabilityportalApplication {
	@Bean
	public RestTemplate getRestTemplate(){
		return  new RestTemplate();
	}


	public static void main(String[] args) {
		SpringApplication.run(BedavailabilityportalApplication.class, args);
	}

}
