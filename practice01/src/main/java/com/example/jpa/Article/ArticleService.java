package com.example.jpa.Article;


import com.example.jpa.Article.model.Article;
import com.example.jpa.Article.repo.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository repository;
    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    //Create
    public Article create(String title, String content, String writer) {
        Article article = new Article(title, content, writer);
        return repository.save(article);
    }

    //Read All
    public List<Article> readAll() {
        return repository.findAll();
    }

    //Read One
    public Article readOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    //Update
    public Article update(Long id, String title, String content, String writer) {
        Optional<Article> optionalTarget = repository.findById(id);
        if (optionalTarget.isEmpty()) return null;
        Article target = optionalTarget.get();
        target.setTitle(title);
        target.setContent(content);
        target.setWriter(writer);

        return repository.save(target);
    }

    //Delete
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
