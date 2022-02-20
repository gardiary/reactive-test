package com.test.reactivetest;

import com.test.reactivetest.client.FooWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveTestApplication.class, args);
		//FooWebClient fooWebClient = new FooWebClient();
		//fooWebClient.retrieve();
	}

}
