package com.example.mytodoapplication.repository;

import com.example.mytodoapplication.entities.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {

    public List<ToDo> findAll();

}