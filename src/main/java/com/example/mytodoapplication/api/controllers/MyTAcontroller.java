package com.example.mytodoapplication.api.controllers;

import com.example.mytodoapplication.entities.MyTA;
import com.example.mytodoapplication.entities.MyTARepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/MyTA")
public class MyTAcontroller {

    private final com.example.mytodoapplication.entities.MyTARepository MyTARepository;

    public MyTAcontroller(MyTARepository myTARepository) {
        this.MyTARepository = myTARepository;
    }

    @GetMapping
    public List<MyTA> getTodos() {
        return MyTARepository.findAll();
    }

    @GetMapping("/{todoId}")
    public Optional<MyTA> getTodo(@PathVariable("todoId") Long todoId) {
        var myTA = MyTARepository.findById(todoId);
        return myTA;
    }

    @PostMapping
    public MyTA newTodo(@RequestBody MyTA myTA) {
        return (MyTA) this.MyTARepository.save(myTA);

    }

    @PutMapping("/{todoId}")
    public Optional<MyTA> updateTodo(@PathVariable("todoId") Long todoId, @RequestBody MyTA updatedMyTA) {
        return this.MyTARepository.findById(todoId)
                .map(oldTodo -> this.MyTARepository.save(updatedMyTA));
    }

    @DeleteMapping("/{todoId}")
    public void deleteTodo(@PathVariable("todoId") Long todoId) {
        this.MyTARepository.deleteById(todoId);
    }


}
