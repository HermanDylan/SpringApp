package com.example.demo1.ToDoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/ToDoList")
public class ToDoListController {

    private final ToDoListService toDoListService;

    @Autowired
    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @GetMapping
    public List<ToDoList> getToDoList() {
        return toDoListService.getToDoList();
    }
    @PostMapping
    public void addToDo(@RequestBody ToDoList toDoList){
        toDoListService.addToDo(toDoList);
    }
    @PutMapping(path = "{toDoListId}")
    public void putToDo(@PathVariable("toDoListId")Long toDoListId, @RequestParam(required = false) String content,@RequestParam(required = false) LocalDateTime dateTime) {
        toDoListService.putToDo(toDoListId, content, dateTime);
    }

    @DeleteMapping(path = "{toDoListId}")
    public void deleteToDo(@PathVariable("toDoListId") Long toDoListId){
        toDoListService.deleteToDo(toDoListId);
    }

}
