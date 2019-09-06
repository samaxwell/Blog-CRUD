package com.blog.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.crud.domain.Blog;
import com.blog.crud.repositories.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogRepository repository;

	@Override
	public List<Blog> getAllBlogs() {
		return repository.findAll();
	}

}
