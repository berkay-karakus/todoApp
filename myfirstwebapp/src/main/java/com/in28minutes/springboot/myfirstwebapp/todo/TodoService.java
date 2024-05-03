package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	private static int count = 0;
	static {
		todos.add(new Todo(++count, "berkay", "Learn AWS Certified", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++count, "berkay", "Learn DevOps", LocalDate.now().plusYears(4), false));
		todos.add(new Todo(++count, "berkay", "Learn Full-Stack", LocalDate.now().plusYears(2), false));
	}

	public List<Todo> getByUserName(String username) {
		Predicate<?super Todo> predicate = 
				todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}

	public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {
		todos.add(new Todo(++count, username, description, targetDate, isDone));
	}
	
	public void deleteTodo(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
	   return todos.stream().filter(predicate).findFirst().get();
	}

	public void updateTodo(@Valid Todo todo) {
		deleteTodo(todo.getId());
	    todos.add(todo);	
	}
}
