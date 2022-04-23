package com.example.mytodoapplication.api.controllers;

import com.example.mytodoapplication.entities.ToDo;
import com.example.mytodoapplication.repository.ToDoRepository;
import com.example.mytodoapplication.service.ToDoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private ToDoRepository toDoRepository;

    private ToDoService toDoService;

    public TodoController(ToDoRepository toDoRepository,ToDoService toDoService) {
        this.toDoRepository = toDoRepository;
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<ToDo> getTodos() {

        //Call to toDoService
        return toDoService.getTodos();
    }

    @GetMapping("/{todoId}")
    public Optional<ToDo> getTodo(@PathVariable("todoId") Long todoId) {
        //call to service
        var todo = toDoService.getTodo(todoId);
        return todo;
    }

    @PostMapping
    public ToDo newTodo(@RequestBody ToDo toDo) {
        //call to service
        return (ToDo) toDoService.newTodo(toDo);

    }

    @PutMapping("/{todoId}")
    public Optional<ToDo> updateTodo(@PathVariable("todoId") Long todoId, @RequestBody ToDo updatedToDo) {
        //call to service
        return toDoService.updateTodo(todoId, updatedToDo);
    }

    @DeleteMapping("/{todoId}")
    public void deleteTodo(@PathVariable("todoId") Long todoId) {
        //call to service
        toDoService.deleteTodo(todoId);
    }


}
