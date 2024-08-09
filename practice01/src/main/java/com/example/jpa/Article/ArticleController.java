package com.example.jpa.Article;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("articles")
public class ArticleController {
    private final ArticleService service;

    public ArticleController(ArticleService service) {
        this.service = service;
    }

    //CREATE
    @GetMapping("create")
    public String createView() {
        return "articles/create.html";
    }

    @PostMapping("create")
    public String create(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("writer") String writer
    ) {
        Long id = service.create(title, content, writer).getId();
        //POST - redirect - GET
        return String.format("redirect:/articles/%d", id);
    }

    //READ ALL
    @GetMapping // /articles
    public String readAll(Model model) {
        model.addAttribute("articles", service.readAll());
        return "articles/home.html";
    }
    //READ ONE
    // /articles/{id}
    @GetMapping("{id}")
    public String readOne(@PathVariable("id") Long id, Model model) {
        model.addAttribute("article", service.readOne(id));
        return "articles/read.html";
    }

    //UPDATE
    @GetMapping("{id}/update")
    public String updateView(@PathVariable Long id, Model model) {
        model.addAttribute("article", service.readOne(id));
        return "articles/update.html";
    }
    @PostMapping("{id}/update")
    public String update(
            @PathVariable("id") Long id,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("writer") String writer) {
        service.update(id, title, content, writer);
        return String.format("redirect:/articles/%d", id);

    }

    //DELETE
    @PostMapping("{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/articles";
    }


}
