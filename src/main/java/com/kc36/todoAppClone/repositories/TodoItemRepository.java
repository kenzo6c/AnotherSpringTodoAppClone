package com.kc36.todoAppClone.repositories;

import com.kc36.todoAppClone.models.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}
