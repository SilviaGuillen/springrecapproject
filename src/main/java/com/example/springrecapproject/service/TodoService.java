package com.example.springrecapproject.service;

import com.example.springrecapproject.model.Status;
import com.example.springrecapproject.dto.TodoWOId;
import com.example.springrecapproject.model.Todo;
import com.example.springrecapproject.repo.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository repo;
    private final IdService idService;

    public List<Todo> getAllTodos() {
        return repo.findAll();
    }

    public Todo saveNewTodo(TodoWOId newTodo) {
        Todo todo = new Todo(
                idService.generateId(),
                newTodo.getDescription(),
                newTodo.getStatus(),
                LocalDateTime.now()
        );
        repo.save(todo);
        return todo;
    }

    public Todo editTodo(Todo requiredTodo) {
        Todo toEdit = repo.findById(requiredTodo.getId()).orElseThrow();
        repo.save(toEdit.withStatus(requiredTodo.getStatus()).withDescription(requiredTodo.getDescription()));
        return repo.findById(toEdit.getId()).orElseThrow();
    }

    public Optional<Todo> deleteTodo(String id) {
        repo.delete(repo.findById(id).orElseThrow());
        return repo.findById(id);
    }

    public Todo showDetails(String id) {
        return repo.findById(id).orElseThrow();
    }
}