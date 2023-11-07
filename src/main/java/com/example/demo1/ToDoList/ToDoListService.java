package com.example.demo1.ToDoList;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;

    @Autowired
    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    public void addToDo(ToDoList toDoList) {
        Optional<ToDoList> toDoListOptional = toDoListRepository.findToDoListById(toDoList.getId());
        if (toDoListOptional.isPresent()) {
            throw new IllegalStateException("Id taken");
        }
        toDoListRepository.save(toDoList);
        System.out.println(toDoList);
    }
    @Transactional
    public void putToDo(Long toDoListId, String content, LocalDateTime dateTime) {
        ToDoList toDoList = toDoListRepository.findById(toDoListId).orElseThrow(() -> new IllegalStateException("ID: "+ toDoListId+" does not exists"));

            System.out.println("Loading");
        if (content != null && !content.isEmpty() && !Objects.equals(toDoList.  getContent(), content)){
            System.out.println("Checking Content");
            Optional<ToDoList> toDoListOptional = toDoListRepository.findToDoListByContent(content);
            System.out.println("Checking duplicates");
            if (toDoListOptional.isPresent()){
                throw new IllegalStateException("Content taken");
            }
            System.out.println();
            toDoList.setContent(content);
        }
    }
    public void deleteToDo(Long toDoListId) {
        boolean exists =  toDoListRepository.existsById(toDoListId);
        if(!exists) {
            throw new IllegalStateException("ID: "+toDoListId+" does not exists");
        }
        toDoListRepository.deleteById(toDoListId);
    }
    public List<ToDoList> getToDoList() {
        return toDoListRepository.findAll();
//        return List.of(
//                new ToDoList(
//                        1L,
//                        "Cascading",
//                        LocalDateTime.of(1864, Month.MAY, 9, 22,59, 59 )
//                )
//        );
    }


}
