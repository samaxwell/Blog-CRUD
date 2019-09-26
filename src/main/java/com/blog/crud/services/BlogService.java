package com.blog.crud.services;

import java.util.List;

import com.blog.crud.domain.Blog;
import com.blog.crud.domain.BlogDto;

public interface BlogService {

	List<BlogDto> getAllBlogs();

	BlogDto saveBlog(BlogDto blog);

	BlogDto findById(Long id);

}
