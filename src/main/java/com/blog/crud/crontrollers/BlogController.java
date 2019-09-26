package com.blog.crud.crontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.crud.domain.Blog;
import com.blog.crud.domain.BlogDto;
import com.blog.crud.services.BlogService;

@RestController
@RequestMapping("/v1/blogs")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@GetMapping
	public List<BlogDto> getAllBlogs() {
		return blogService.getAllBlogs();
	}
	
	@PostMapping
	public BlogDto createBlog(@RequestBody BlogDto blog) {
		return blogService.saveBlog(blog);
	}

}
