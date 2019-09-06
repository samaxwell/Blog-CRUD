package com.blog.crud;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.blog.crud.domain.Blog;
import com.blog.crud.repositories.BlogRepository;

@Profile("default")
@Component
public class SeedData {
	
	@Autowired
	private BlogRepository repository;
	
	@PostConstruct
	public void addSeedData() {
		Arrays.asList(
				new Blog("Spring Config Server", "How to setup Spring Cloud config", "Sean Maxwell"),
				new Blog("Angular Guide", "Testing in Angular made simple!", "Sean Maxwell"),
				new Blog("Zuul Notes", "How to map routes in Netflix's Zuul", "Sean Maxwell"))
		.forEach(b -> repository.save(b));
	}

}
