package com.blog.crud.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * A view of the Blog model
 */
@Data
@NoArgsConstructor
public class BlogDto {

	private Long id;
	
	private String title;
	
	private String description;
	
	private String author;
	
}
