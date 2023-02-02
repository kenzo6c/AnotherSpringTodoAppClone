package com.kc36.todoAppClone.controllers;

import com.kc36.todoAppClone.models.TodoItem;
import com.kc36.todoAppClone.services.TodoItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String index(Model model) {
        model.addAttribute("todoItems", todoItemService.getAll());
        model.addAttribute("todoItem", new TodoItem());
        model.addAttribute("edit", false);
        return "index";
    }

    @PostMapping("/todoitem")
    public String saveTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model)
    {
        System.out.println("new todoItem from the request:" + todoItem);
        todoItemService.save(todoItem);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable Long id, Model model)
    {
        TodoItem todoItem = todoItemService.getById(id).orElseThrow(() -> new IllegalArgumentException("Todo item id "+ id + " not found."));
        todoItemService.delete(todoItem);
        return "redirect:/";
    }

//    @GetMapping("/edit/{id}")
//    public String showEditForm(@PathVariable Long id, Model model)
//    {
//        System.out.println("edit val2: " + model.getAttribute("edit"));
//        model.addAttribute("editedId", id);
//        model.addAttribute("edit", true);
//        System.out.println("edit val3: " + model.getAttribute("edit"));
//        return "redirect:/";
//    }

    @GetMapping("/check/{id}")
    public String checkTodoItem(@PathVariable Long id, Model model)
    {
        TodoItem todoItem = todoItemService.getById(id).orElseThrow(() -> new IllegalArgumentException("Todo item id "+ id + " not found."));
        todoItem.setIsDone(!todoItem.getIsDone());
        todoItemService.save(todoItem);
        return "redirect:/";
    }
}
