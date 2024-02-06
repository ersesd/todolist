package com.example.todolist.service;

import com.example.todolist.model.Todo;
import com.example.todolist.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    public void testSaveTodo() {
        Todo todo = new Todo();
        todo.setTitle("Test Todo");
        when(todoRepository.save(any(Todo.class))).thenReturn(todo);

        Todo savedTodo = todoService.save(new Todo());
        assertThat(savedTodo.getTitle()).isEqualTo("Test Todo");
    }
}
