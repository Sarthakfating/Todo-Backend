package com.practise.ToDo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practise.ToDo.pojo.Todo;
import com.practise.ToDo.service.Todoservice;
@RestController
@RequestMapping("/todo")
public class Todocontroller {
	@Autowired
	private Todoservice todoservice;
	
	@GetMapping
	public ResponseEntity<List<Todo>> getalltodo(){
		List<Todo> todo=todoservice.getalltodo();
		return ResponseEntity.ok(todo);
	}
	
	@GetMapping("{/id}")
	public ResponseEntity<Todo> gettodobyid(@PathVariable long id) {
		Todo todo =todoservice.gettodobyid(id).orElseThrow(null);
		if(todo!=null) {
			return ResponseEntity.ok(todo);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Todo> createtodo(@RequestBody Todo todo) {
		Todo crtodo = todoservice.createtodo(todo);
		return ResponseEntity.status(HttpStatus.CREATED).body(crtodo);
	}
	
	@PutMapping("{/id}")
	public ResponseEntity<Todo> updatetodo(@PathVariable long id,@RequestBody Todo tododetails) {
		Todo updatedtodo= todoservice.updatetodo(id, tododetails);
		if(updatedtodo!=null) {
			return ResponseEntity.ok(updatedtodo);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{/id}")
	public ResponseEntity<Void> deletetodo(@PathVariable long id) {
		todoservice.deletetodo(id);
		return ResponseEntity.noContent().build();
	}

}
