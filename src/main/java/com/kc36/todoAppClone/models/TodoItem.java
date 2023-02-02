package com.kc36.todoAppClone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "todo_items")
public class TodoItem {

    public TodoItem() {
        this.id = null;
        this.content = "";
        this.creationDate = null;
        this.isWIP = false;
        this.isDone = false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private Instant creationDate;
    private Boolean isWIP;
    private Boolean isDone;

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", creationDate=" + creationDate +
                ", isWIP=" + isWIP +
                ", isDone=" + isDone +
                '}';
    }
}
