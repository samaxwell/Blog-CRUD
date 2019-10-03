package com.blog.crud.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.crud.domain.BlogDto;
import com.blog.crud.services.BlogService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/blogs")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@GetMapping
	public List<BlogDto> getAllBlog() {
		log.info("Received request for all blogs");
		return blogService.getAllBlogs();
	}
	
	@GetMapping("/{id}")
	public BlogDto getBlogById(@PathVariable Long id) {
		log.info("Received request for blog {}", id);
		return blogService.findById(id);
	}
	
	@PostMapping
	public BlogDto createBlog(@Valid @RequestBody BlogDto blog) {
		log.info("Received request to update blog {}", blog.getId());
		return blogService.saveBlog(blog);
	}

}
