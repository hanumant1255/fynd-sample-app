package com.shindeh.springboot.fynd.service;

import com.shindeh.springboot.fynd.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentService extends JpaRepository<Comment,Long> {
}
