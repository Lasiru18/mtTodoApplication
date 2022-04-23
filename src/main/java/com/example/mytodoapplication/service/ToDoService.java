package com.example.mytodoapplication.service;

import com.example.mytodoapplication.entities.ToDo;
import com.example.mytodoapplication.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private ToDoRepository toDoRepository;

    //Constructor
    public ToDoService(ToDoRepository toDoRepository){
        this.toDoRepository = toDoRepository;
    }

    //Call to ToDoRepository
    public List<ToDo> getTodos() {
        return toDoRepository.findAll();
    }

    //Call to ToDoRepository
    public Optional<ToDo> getTodo(Long todoId){
        var todo = toDoRepository.findById(todoId);
        return todo;
    }

    //Call to ToDoRepository
    public ToDo newTodo(ToDo toDo){
        return (ToDo) toDoRepository.save(toDo);
    }

    //Call to ToDoRepository
    public Optional<ToDo> updateTodo(Long todoId, ToDo updatedToDo){
        return this.toDoRepository.findById(todoId).map(oldTodo -> this.toDoRepository.save(updatedToDo));
    }

    //Call to ToDoRepository
    public void deleteTodo(Long todoId){
        toDoRepository.deleteById(todoId);
    }
}
