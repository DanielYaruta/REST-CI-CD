package org.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllTasks_returnsOkStatus() throws Exception {
        mockMvc.perform(get("/api/tasks"))
                .andExpect(status().isOk());
    }

    @Test
    void getAllTasks_returnsJsonContentType() throws Exception {
        mockMvc.perform(get("/api/tasks"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getAllTasks_returnsJsonArray() throws Exception {
        mockMvc.perform(get("/api/tasks"))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void getAllTasks_returnsThreeTasks() throws Exception {
        mockMvc.perform(get("/api/tasks"))
                .andExpect(jsonPath("$.length()").value(3));
    }

    @Test
    void getAllTasks_firstTaskHasExpectedTitle() throws Exception {
        mockMvc.perform(get("/api/tasks"))
                .andExpect(jsonPath("$[0].title").value("Buy groceries"));
    }

    @Test
    void getAllTasks_tasksHaveRequiredFields() throws Exception {
        mockMvc.perform(get("/api/tasks"))
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].title").exists())
                .andExpect(jsonPath("$[0].description").exists())
                .andExpect(jsonPath("$[0].completed").exists());
    }
}
