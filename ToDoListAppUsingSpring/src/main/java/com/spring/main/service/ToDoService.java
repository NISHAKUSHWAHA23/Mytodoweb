package com.spring.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.main.model.ToDo;
import com.spring.main.repo.ToDoRepo;
@Service
public class ToDoService {
	@Autowired
	ToDoRepo repo;
	
	public List<ToDo>getAllToDoItems(){
		ArrayList<ToDo>todoList=new ArrayList<>();
		repo.findAll().forEach(todo ->todoList.add(todo));
		return todoList;
		
		
	}
	public ToDo getToDoItemById(Long id) {
		return repo.findById(id).get();
		
		
	}
	public boolean updateStatus(Long id) {
		ToDo todo=getToDoItemById(id);
		todo.setStatus("completed");
		return saveOrUpdateToDoItem(todo);
		
		
	}
	public boolean saveOrUpdateToDoItem(ToDo todo) {
		ToDo updatedobj=repo.save(todo);
		if(getToDoItemById(updatedobj.getId())!=null) {
			return true;
			
		}
		return false;
		
	}
	public boolean deleteToDoItem(Long id) {
		repo.deleteById(id);
		if(repo.findById(id)==null) {
			return true;
		}
		return false;
	}

}
