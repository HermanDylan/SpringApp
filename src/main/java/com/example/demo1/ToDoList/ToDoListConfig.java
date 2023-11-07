package com.example.demo1.ToDoList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import java.util.List;
@Configurable
public class ToDoListConfig {

    @Bean
    CommandLineRunner commandLineRunner(ToDoListRepository repository) {
        return args -> {
            ToDoList toDoList1 = new ToDoList("toDoList1");
            ToDoList toDoList2 = new ToDoList("toDoList2");
            repository.saveAll(List.of(toDoList1, toDoList2));
        };
    }
}
