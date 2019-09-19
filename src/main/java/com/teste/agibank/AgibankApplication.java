package com.teste.agibank;

import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgibankApplication extends SpringRouteBuilder {

	@Value("${directory.path.in}")
	private String contextPathIn;

	@Value("${directory.path.out}")
	private String contextPathOut;

	public static void main(String[] args) {
		SpringApplication.run(AgibankApplication.class, args);
	}

	@Override
	public void configure() {
		final String userHome = System.getProperty("user.home");
		final String pathIn = userHome + contextPathIn + "?noop=true&include=.?\\.dat";
		final String pathOut = userHome + contextPathOut;

		from("file:" + pathIn)
			.to("direct:fileConverter")
			.to("direct:fileProcessor")
			.to("file:" + pathOut);
	}
}