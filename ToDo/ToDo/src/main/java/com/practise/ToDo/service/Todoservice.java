package com.practise.ToDo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.practise.ToDo.pojo.Todo;
import com.practise.ToDo.repositiory.Todorepositiory;


public class Todoservice {
	@Autowired
	private Todorepositiory todorepositiory;
	
	public List<Todo> getalltodo(){
		return todorepositiory.findAll();
		}
	
	public Optional<Todo> gettodobyid(long id) {
		return todorepositiory.findById(id);
	}
	
	public Todo createtodo(Todo todo) {
		return todorepositiory.save(todo);
	}
	
	public Todo updatetodo(long id,Todo updatedetails) {
		Optional<Todo> optionaltodo = todorepositiory.findById(id);
		if(optionaltodo.isPresent()) {
			Todo todo=optionaltodo.get();
					todo.setTitle(updatedetails.getTitle());
					todo.setContent(updatedetails.getContent());
					todo.setCompleted(updatedetails.isCompleted());
		return todorepositiory.save(todo);
		}else {
			return null;
		}
	}
	
	public void deletetodo(long id) {
		todorepositiory.deleteById(id);;
	}	
}
