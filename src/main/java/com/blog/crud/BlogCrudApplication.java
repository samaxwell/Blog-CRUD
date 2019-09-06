package com.blog.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class BlogCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogCrudApplication.class, args);
	}

}
