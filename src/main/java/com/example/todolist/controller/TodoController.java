package com.example.todolist.controller;

import com.example.todolist.model.Todo;
import com.example.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String listTodos(Model model) {
        model.addAttribute("todos", todoService.findAll());
        return "index"; // Thymeleaf template name
    }

    @GetMapping("/add")
    public String addTodoForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "add-todo"; // Thymeleaf template name for adding a new todo
    }

    @PostMapping("/add")
    public String addTodo(Todo todo) {
        todoService.save(todo);
        return "redirect:/"; // Redirect back to the list view
    }

    // Additional methods for edit, delete, etc., can also be added here.
}
