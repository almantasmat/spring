package com.spring.boot.craftsoft.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.spring.boot.craftsoft.entity.Task;
import com.spring.boot.craftsoft.service.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class TaskRestControllerTest {
    private MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private TaskService taskService;

    @InjectMocks
    private TaskRestController taskRestController;

    Task RECORD_1 = new Task(1, "Hibernate", "configure hibernate", "Hibernate", "waiting", "Lukas", "1.5 hour", null);
    Task RECORD_2 = new Task(2, "Java", "configure Java", "Java", "in progress", "Petriukas", "2 hour", "make everyone cup of coffee");
    Task RECORD_3 = new Task(3, "JUnit", "cover code J_Units", "J Units", "in progress", "Antanas", "4 hour", null);

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(taskRestController).build();
    }

    @Test
    public void getAll_success() throws Exception{
        List<Task> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
        Mockito.when(taskService.getAll()).thenReturn(records);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/tasks")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].taskName", is("Hibernate")))
                .andExpect(jsonPath("$[1].taskName", is("Java")))
                .andExpect(jsonPath("$[2].taskName", is("JUnit")));
    }

    @Test
    public void getById_success() throws Exception{
         Mockito.when(taskService.findByID(RECORD_1.getId())).thenReturn(java.util.Optional.of(RECORD_1).get());
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/task/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.taskName", is("Hibernate")));
    }
    @Test
    public void create_success() throws Exception{
        Task record = Task.builder()
                .taskName("Data_base")
                .taskDescription("build data base")
                .taskGroup("DB")
                .taskStatus("done")
                .assignee("Arunas")
                .timeSpent("1 hour")
                .subTask("Feed a Cat")
                .build();

        Mockito.when(taskService.create(record)).thenReturn(record);

        String content = objectWriter.writeValueAsString(record);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/task")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.taskName", is("Data_base")));

    }
    @Test
    public void update_success() throws Exception{
        Task updatedRecord = Task.builder()
                .id(1)
                .taskName("Update task")
                .taskDescription("updated description")
                .taskGroup("update")
                .taskStatus("updating")
                .assignee("updater")
                .timeSpent("2.5 hour")
                .subTask("Update more tasks")
                .build();
        Mockito.when(taskService.findByID(RECORD_1.getId())).thenReturn(java.util.Optional.of(RECORD_1).get());
        Mockito.when(taskService.create(updatedRecord)).thenReturn(updatedRecord);

        String updateContent = objectWriter.writeValueAsString(updatedRecord);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/api/task")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(updateContent);
        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.taskName", is("Update task")));

    }
    @Test
    public  void delete_success() throws Exception{
        Mockito.when(taskService.findByID(RECORD_3.getId())).thenReturn(Optional.of(RECORD_3).get());

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/task/3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
