package com.example.ToDoApp.service;

import com.example.ToDoApp.repo.IToDoRepo;
import com.example.ToDoApp.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    @Autowired
    IToDoRepo repo;

    public List<ToDo> getAllToDoItem(){
        ArrayList<ToDo> todoList = new ArrayList<>();
        repo.findAll().forEach(todo -> todoList.add(todo));

        return todoList;
    }

    public ToDo getToDoItemById(Long id){
        return repo.findById(id).get();
    }

    public boolean updateStatus(Long id){
        ToDo todo = getToDoItemById(id);
        todo.setStatus("Completed");

        return savOrUpdateToDoItem(todo);
    }

    public boolean savOrUpdateToDoItem(ToDo todo){
        ToDo updatedObj = repo.save(todo);

        if(getToDoItemById(updatedObj.getId()) != null) {
            return true;
        }

        return false;
    }

    public boolean deleteToDoItem(Long id){
        repo.deleteById(id);

        if (getToDoItemById(id) == null){
            return true;
        }
        return  false;
    }
}
