package com.example.jpa.Article;


import com.example.jpa.Article.model.Article;
import com.example.jpa.Article.model.Comment;
import com.example.jpa.Article.repo.ArticleRepository;
import com.example.jpa.Article.repo.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final ArticleRepository articleRepo;
    private final CommentRepository commentRepo;
    public CommentService(
            ArticleRepository articleRepo,
            CommentRepository commentRepo
    ) {
        this.articleRepo = articleRepo;
        this.commentRepo = commentRepo;
    }

    // Create
    public Comment create(
            Long articleId,
            String content,
            String writer
    ) {
        Article article = articleRepo.findById(articleId)
                .orElseThrow();

        Comment comment = new Comment(
                content,
                writer,
                article
        );
        return commentRepo.save(comment);
    }


    public Comment readOne(
            Long articleId,
            Long commentId
    ) {
        Comment comment = commentRepo.findById(commentId)
                .orElseThrow();

        // articleId를 받아온다면
        // 댓글을 요청한 요청이 정당한지 판단할 수 있다.
        if (!comment.getArticle().getId().equals(articleId))
            throw new RuntimeException();

        return comment;
    }
}