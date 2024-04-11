package com.example.springrecapproject.controller;

import com.example.springrecapproject.dto.TodoWOId;
import com.example.springrecapproject.model.Todo;
import com.example.springrecapproject.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class ApiController {

    private final TodoService service;
    @GetMapping
    public List<Todo> getAllTodos() {
        return service.getAllTodos();
    }

    @PostMapping
    public Todo saveNewTodo(@RequestBody TodoWOId newTodo) {
        return service.saveNewTodo(newTodo);
    }

    @PutMapping("/{id}")
    public Todo editTodo(@RequestBody Todo requiredTodo) {
        return service.editTodo(requiredTodo);
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable String id) {
        try {
            service.deleteTodo(id).orElseThrow();
            return "Todo not deleted";
        } catch (NoSuchElementException e) {
            return "Todo deleted ok";
        }
    }

    @GetMapping("/{id}")
    public Todo showDetails(@PathVariable String id) {
        return service.showDetails(id);
    }


}