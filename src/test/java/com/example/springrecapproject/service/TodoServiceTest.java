package com.example.springrecapproject.service;

import com.example.springrecapproject.repo.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class TodoServiceIntegrationTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private TodoRepository repo;

    @Test
    void getAllTodos_ShouldReturnEmptyList_WhenCalledInitially() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/todo"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

    @Test
    void saveNewTodo_ShouldReturnTodo_WhenCalledWithValidData() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/api/todo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {
                            "description" : "Playing soccer run",
                            "status" : "IN_PROGRESS"
                        }
                        """))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                            "description" : "Playing soccer run",
                            "status" : "IN_PROGRESS"
                        }
                        """))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").exists());
    }

    @Test
    void editTodo() {
    }

    @Test
    void deleteTodo() {
    }

    @Test
    void showDetails() {
    }
}