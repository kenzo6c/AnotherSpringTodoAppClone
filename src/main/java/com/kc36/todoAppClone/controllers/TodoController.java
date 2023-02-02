package com.kc36.todoAppClone.controllers;

import com.kc36.todoAppClone.models.TodoItem;
import com.kc36.todoAppClone.services.TodoItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoController {

    private TodoItemService todoItemService;

    public TodoController(@Autowired TodoItemService todoItemService)
    {
        this.todoItemService = todoItemService;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemService.getAll());
        modelAndView.addObject("todoItem", new TodoItem());
        return modelAndView;
    }

    @PostMapping("/todoitem")
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model)
    {
        System.out.println("new todoItem from the request:" + todoItem);
        todoItemService.save(todoItem);
        return "redirect:/";
    }
}
