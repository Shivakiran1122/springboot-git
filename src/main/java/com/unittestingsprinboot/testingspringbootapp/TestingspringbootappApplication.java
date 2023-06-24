package com.unittestingsprinboot.testingspringbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TestingspringbootappApplication {
               private static final String  REST_URL="https:// www.equifax.com/getScores";
	public static void main(String[] args) {
		 ConfigurableApplicationContext run= SpringApplication.run(TestingspringbootappApplication.class, args);
		 //changes of task 2
		  run.close();
                  // this is the main class
                 // hello vetx branch
	}

}
