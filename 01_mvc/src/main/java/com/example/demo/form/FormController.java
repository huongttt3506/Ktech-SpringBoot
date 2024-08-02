package com.example.demo.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FormController {
    // @RequestMapping("send")
    @GetMapping("send")
    public String getForm() {
        return "form/send.html";
    }

    // @RequestMapping("receive")
    @PostMapping("receive")
    public String receiveData(
            @RequestParam("from")
            String from,
            @RequestParam("message")
            String message,
            Model model
    ) {
        model.addAttribute("from", from);
        model.addAttribute("message", message);
        return "form/receive.html";
    }

    @GetMapping("save-todo")
    public String saveTodo() {
        return "form/save-todo.html";
    }

    private List<String> todos = new ArrayList<>();

    @PostMapping("get-saved-todos")
    public String getSavedTodos(
            @RequestParam("todo")
            String todo,
            Model model
    ) {
        todos.add(todo);
        model.addAttribute("savedTodo", todo);
        model.addAttribute("todoList", todos);
        return "form/get-saved-todos.html";
    }
}
