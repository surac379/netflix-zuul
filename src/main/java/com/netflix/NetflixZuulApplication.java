package com.netflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy // Netflix Zuul auto-configure
public class NetflixZuulApplication {

	/**
	 * 
	 * default behaviour (if connected to Eureka)
	 * take spring.application.name, make that the route
	 *movies -> spring.application.name = movies
	 */
	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApplication.class, args);
	}

}
