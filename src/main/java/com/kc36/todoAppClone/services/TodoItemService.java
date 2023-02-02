package com.kc36.todoAppClone.services;

import com.kc36.todoAppClone.models.TodoItem;
import com.kc36.todoAppClone.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class TodoItemService {

    private TodoItemRepository todoItemRepository;

    public TodoItemService(@Autowired TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public Optional<TodoItem> getById(Long id) {
        return todoItemRepository.findById(id);
    }

    public Iterable<TodoItem> getAll() {
        return todoItemRepository.findAll();
    }

    public TodoItem save(TodoItem todoItem)
    {
        if (todoItem.getId() == null)
        {
            todoItem.setCreationDate(Instant.now());
        }

        return todoItemRepository.save(todoItem);
    }

    public void delete(TodoItem todoItem)
    {
        todoItemRepository.delete(todoItem);
    }

    public void deleteAll()
    {
        todoItemRepository.deleteAll();
    }

}
