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

@RestController
@RequestMapping("/v1/blogs")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@GetMapping
	public List<BlogDto> getAllBlog() {
		return blogService.getAllBlogs();
	}
	
	@GetMapping("/{id}")
	public BlogDto getBlogById(@PathVariable Long id) {
		return blogService.findById(id);
	}
	
	@PostMapping
	public BlogDto createBlog(@Valid @RequestBody BlogDto blog) {
		return blogService.saveBlog(blog);
	}

}
