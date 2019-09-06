package com.blog.crud.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Blog {

	/* https://www.baeldung.com/spring-data-annotations */
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	private String description;

	public Blog(String title, String description) {
		this.title = title;
		this.description = description;
	}

}
