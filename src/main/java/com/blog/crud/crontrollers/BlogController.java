package com.blog.crud.crontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.crud.domain.Blog;
import com.blog.crud.services.BlogService;

@RestController
@RequestMapping("/blogs")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@GetMapping
	public List<Blog> getAllBlogs() {
		return blogService.getAllBlogs();
	}

}
