package com.pfe.marchepublic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MarchepublicApplication {
	public static void main(String[] args) {
		SpringApplication.run(MarchepublicApplication.class, args);
	}

}
