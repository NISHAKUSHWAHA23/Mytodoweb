package com.spring.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.main.model.ToDo;
@Repository
public interface ToDoRepo extends JpaRepository<ToDo,Long>{
	

}
