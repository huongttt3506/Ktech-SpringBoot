package com.example.jpa.Article.repo;

import com.example.jpa.Article.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
