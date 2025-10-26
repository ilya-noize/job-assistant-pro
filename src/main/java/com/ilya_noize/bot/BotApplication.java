package com.ilya_noize.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BotApplication {
	public static void main(String[] args) {
		System.out.printf("Start %s%n", System.getProperty("app.name"));
		SpringApplication.run(BotApplication.class, args);
	}
}
