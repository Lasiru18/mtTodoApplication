package com.example.mytodoapplication.repository;

import com.example.mytodoapplication.entities.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ToDoRepository extends JpaRepository<ToDo, Long> {

    public List<ToDo> findAll();

}