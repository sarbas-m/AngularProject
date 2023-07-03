package com.faith.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
//this annotation is applied to the class to indicate 
//that it is the main class for a spring boot application
//and triggers the auto configuration process
public class CmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmsApplication.class, args);
		System.out.println("welcome to cms");
		System.out.println("welcome to cms");
	}

}
