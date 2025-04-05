package com.homecontrol.HomeControl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class HomeControlApplication {
	public static void main(String[] args) {
		SpringApplication.run(HomeControlApplication.class, args);
	}
}

