package com.practise.ToDo.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practise.ToDo.pojo.Todo;

@Repository
public interface Todorepositiory extends JpaRepository<Todo,Long> {

}
