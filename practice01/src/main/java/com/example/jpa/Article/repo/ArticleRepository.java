package com.example.jpa.Article.repo;

import com.example.jpa.Article.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
