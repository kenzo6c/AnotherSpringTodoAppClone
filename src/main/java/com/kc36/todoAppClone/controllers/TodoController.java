package com.kc36.todoAppClone.controllers;

import com.kc36.todoAppClone.services.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
        return modelAndView;
    }
}
