package com.shindeh.springboot.fynd.service;

import com.shindeh.springboot.fynd.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogService extends JpaRepository<Blog, Long>{
}
