package com.blog.crud.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Blog {

	/* https://www.baeldung.com/spring-data-annotations */
	
	@Id
	@GeneratedValue
	@Column(name = "blog_id", nullable = false)
	private Long id;
	
	// TODO - fix createdAt
	@CreatedDate
    private Date createdAt;
	
	// TODO - fix lastModifiedDate
	@LastModifiedDate
    private Date modifiedAt;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "author", nullable = false)
	private String author;

	public Blog(String title, String description, String author) {
		this.title = title;
		this.description = description;
		this.author = author;
	}

}
