package com.kr.changepoint.autoreply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ServletComponentScan
@SpringBootApplication
@EnableScheduling
public class AutoreplyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoreplyApplication.class, args);
	}

}
