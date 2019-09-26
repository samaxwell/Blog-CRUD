package com.blog.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.crud.converters.ConverterService;
import com.blog.crud.domain.Blog;
import com.blog.crud.domain.BlogDto;
import com.blog.crud.exceptions.ResourceNotFoundException;
import com.blog.crud.exceptions.UnsatisfiedConstraint;
import com.blog.crud.repositories.BlogRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogRepository repository;
	private ConverterService converter;
	
	public BlogServiceImpl() {
		this.converter = new ConverterService();
	}

	@Override
	public List<BlogDto> getAllBlogs() {
		return converter.convertAll(repository.findAll());
	}
	
	@Override
	public BlogDto findById(Long id) {

		// TODO - test
		/* Verify blog exists */
		Optional<Blog> blog = repository.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("no can do"));
		if(!blog.isPresent()) {
			throw new ResourceNotFoundException("Cannot find resouce with id '" + id + "'");
		}

		return converter.convert(blog.get());
	}

	@Override
	public BlogDto saveBlog(BlogDto blogToSave) {
		
		// TODO - test
		/* Verify blog title doesn't already exist */
		repository.findOneByTitle(blogToSave.getTitle()).ifPresent(blog -> { 
			log.info("Unable to add blog with title '{}' because an existing blog already has that title", blog.getTitle());
			throw new UnsatisfiedConstraint("A blog already exists with the title '" + blog.getTitle() + "'");
		});

		Blog blog = repository.save(converter.convert(blogToSave));

		return converter.convert(blog);
	}

}
