package com.blog.crud.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Blog {

	/* https://www.baeldung.com/spring-data-annotations */
	/* https://springbootdev.com/2018/03/13/spring-data-jpa-auditing-with-createdby-createddate-lastmodifiedby-and-lastmodifieddate/ */
	
	@Id
	@GeneratedValue
	@Column(name = "blog_id", nullable = false)
	private Long id;
	
	@CreatedDate
    private Date createdAt;
	
	@LastModifiedDate
    private Date modifiedAt;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "description", nullable = false)
	private String contents;
	
	@Column(name = "author", nullable = false)
	private String author;

	public Blog(String title, String contents, String author) {
		this.title = title;
		this.contents = contents;
		this.author = author;
	}

}
