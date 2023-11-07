package com.example.demo1.ToDoList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
    // SELECT * FROM to_do_list WHERE Id = ?
    //@Query("SELECT s FROM s WHERE s.Id = ?1")
    Optional<ToDoList> findToDoListById(Long Id);
    Optional<ToDoList> findToDoListByContent(String content);
}
