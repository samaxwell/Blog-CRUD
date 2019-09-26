package com.blog.crud.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.blog.crud.domain.Blog;
import com.blog.crud.domain.BlogDto;

public class ConverterService {

	private ModelMapper mapper;

	public ConverterService() {
		this.mapper = new ModelMapper();
	}

	public List<BlogDto> convertAll(List<Blog> blogs) {
		return blogs
				.stream()
				.map(blog -> mapper.map(blog, BlogDto.class))
				.collect(Collectors.toList());
	}

	public BlogDto convert(Blog blog) {
		return mapper.map(blog, BlogDto.class);
	}

	public Blog convert(BlogDto blogDto) {
		return mapper.map(blogDto, Blog.class);
	}


}
