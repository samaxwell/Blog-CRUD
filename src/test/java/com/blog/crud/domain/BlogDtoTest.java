package com.blog.crud.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Before;
import org.junit.Test;

public class BlogDtoTest {

	private Validator validator;
	private BlogDto blogDto;

	@Before
	public void setUp() throws Exception {
		validator = Validation.buildDefaultValidatorFactory().getValidator();

		blogDto = new BlogDto();
		blogDto.setAuthor("BLOG AUTHOR");
		blogDto.setContents("BLOG CONTENTS");
		blogDto.setTitle("BLOG TITLE");
	}

	@Test
	public void blogIsOk_shouldPass() {
		Set<ConstraintViolation<BlogDto>> constraintViolations = validator.validate(blogDto);
		
		assertThat(constraintViolations)
			.hasSize(0);
	}

	////////////////////////////////////
	// Test 'Title' field constraints //
	////////////////////////////////////
	
	@Test
	public void blogWithNoTitle_shouldThrowException() {
		blogDto.setTitle("");
		
		Set<ConstraintViolation<BlogDto>> constraintViolations = validator.validate(blogDto);
		
		assertThat(constraintViolations)
			.hasSize(2)
			.extracting(ConstraintViolation::getMessage)
			.contains("title is required");
	}
	
	@Test
	public void blogWithTitleThatIsTooShort_shouldThrowException() {
		blogDto.setTitle("ME");
		
		Set<ConstraintViolation<BlogDto>> constraintViolations = validator.validate(blogDto);
		
		assertThat(constraintViolations)
			.hasSize(1)
			.extracting(ConstraintViolation::getMessage)
			.satisfies(m -> {
				assertThat(m.get(0).startsWith("title must be between"));
			});
	}

	//////////////////////////////////////
	// Test 'Content' field constraints //
	//////////////////////////////////////

	@Test
	public void blogWithNoContents_shouldThrowException() {
		blogDto.setContents("");
		
		Set<ConstraintViolation<BlogDto>> constraintViolations = validator.validate(blogDto);
		
		assertThat(constraintViolations)
			.hasSize(2)
			.extracting(ConstraintViolation::getMessage)
			.contains("blog content is required");
	}

	@Test
	public void blogWithContentsThatAreTooShort_shouldThrowException() {
		blogDto.setContents("ME");
		
		Set<ConstraintViolation<BlogDto>> constraintViolations = validator.validate(blogDto);
		
		assertThat(constraintViolations)
			.hasSize(1)
			.extracting(ConstraintViolation::getMessage)
			.satisfies(m -> {
				assertThat(m.get(0).startsWith("content must be between"));
			});
	}

	/////////////////////////////////////
	// Test 'Author' field constraints //
	/////////////////////////////////////
	
	@Test
	public void blogWithNoAuthor_shouldThrowException() {
		blogDto.setAuthor("");
		
		Set<ConstraintViolation<BlogDto>> constraintViolations = validator.validate(blogDto);
		
		assertThat(constraintViolations)
			.hasSize(2)
			.extracting(ConstraintViolation::getMessage)
			.contains("author is a required field");
	}

	@Test
	public void blogWithAuthorThatIsTooShort_shouldThrowException() {
		blogDto.setAuthor("me");
		
		Set<ConstraintViolation<BlogDto>> constraintViolations = validator.validate(blogDto);
		
		assertThat(constraintViolations)
			.hasSize(1)
			.extracting(ConstraintViolation::getMessage)
			.satisfies(m -> {
				assertThat(m.get(0).startsWith("author name must be between"));
			});
	}
}
