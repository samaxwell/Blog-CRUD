package com.blog.crud.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * A view of the Blog model
 */
@Data
@NoArgsConstructor
public class BlogDto {

	private Long id;
	
	@NotBlank(message = "title is required")
	@Size(min = 3, max = 30, message = "title must be between {min} and {max} characters")
	private String title;
	
	// TODO - test
	@NotBlank(message = "blog content is required")
	@Size(min = 3, max = 10_000, message = "content must be between {min} and {max} characters")
	private String contents;
	
	// TODO - test
	@NotBlank(message = "author is a required field")
	@Size(min = 3, max = 30, message = "author name must be between {min} and {max} characters")
	private String author;
	
}
