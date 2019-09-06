package com.blog.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.crud.domain.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

}
