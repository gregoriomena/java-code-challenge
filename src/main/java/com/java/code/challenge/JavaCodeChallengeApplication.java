package com.java.code.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class JavaCodeChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaCodeChallengeApplication.class, args);
	}

}
