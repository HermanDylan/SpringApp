package com.example.demo1.ToDoList;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ToDoList {
    @Id
    @SequenceGenerator(
            name = "to_do_list_sequence",
            sequenceName = "to_do_list_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "to_do_list_sequence"
    )
    private Long id;
    private String content;
    private LocalDateTime DateTime;


    public ToDoList() {
    }

    public ToDoList(Long id, String content, LocalDateTime dateTime) {
        this.id = id;
        this.content = content;
        DateTime = dateTime;
    }

    public ToDoList(String toDoList1) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateTime() {
        return DateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        DateTime = dateTime;
    }

    @Override
    public String toString() {
        return "ToDoList{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", DateTime=" + DateTime +
                '}';
    }

}
