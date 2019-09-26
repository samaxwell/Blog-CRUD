package com.blog.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.crud.converters.ConverterService;
import com.blog.crud.domain.Blog;
import com.blog.crud.domain.BlogDto;
import com.blog.crud.repositories.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogRepository repository;
	private ConverterService converterService;
	
	public BlogServiceImpl() {
		this.converterService = new ConverterService();
	}

	@Override
	public List<BlogDto> getAllBlogs() {
		return converterService.convertAll(repository.findAll());
	}

	@Override
	public BlogDto saveBlog(BlogDto blogToSave) {
		// TODO - verify title doesn't already exist

		Blog blog = converterService.convert(blogToSave);

		return converterService.convert(repository.save(blog));
	}

}
