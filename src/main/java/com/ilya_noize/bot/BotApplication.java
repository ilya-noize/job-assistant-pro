package com.ilya_noize.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BotApplication {
	public static final String HH_USER_AGENT = "";//@Value("${aggregator.hh.userAgent}")

	public static void main(String[] args) {
		SpringApplication.run(BotApplication.class, args);
	}
}
