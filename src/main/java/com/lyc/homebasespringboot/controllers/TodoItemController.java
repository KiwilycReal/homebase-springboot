package com.lyc.homebasespringboot.controllers;

import com.google.gson.Gson;
import com.lyc.homebasespringboot.models.TodoItem;
import com.lyc.homebasespringboot.services.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class TodoItemController {

    @Autowired
    TodoItemService service;

    Gson gson = new Gson();

    @PostMapping("/todo/new")
    public String createNewTodoItem(@RequestBody TodoItem newItem){
        return gson.toJson(service.createNewTodoItem(newItem));
    }

    @PostMapping("/todo/update")
    public String updateTodoItem(@RequestBody TodoItem updatedItem){
        return gson.toJson(service.updateTodoItem(updatedItem));
    }

    @DeleteMapping("/todo/{id}")
    public Boolean removeTodoItem(@PathVariable String id){
        return service.deleteTodoItem(id);
    }

    @GetMapping("/todo")
    public String fetchTodoItemList(){
        return gson.toJson(service.fetchTodoItemList());
    }

}
