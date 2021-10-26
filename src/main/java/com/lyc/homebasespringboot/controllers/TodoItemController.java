package com.lyc.homebasespringboot.controllers;

import com.lyc.homebasespringboot.models.TodoItem;
import com.lyc.homebasespringboot.services.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoItemController {

    @Autowired
    TodoItemService service;

    @PostMapping("/todo/new")
    public String createNewTodoItem(@RequestBody TodoItem newItem){
        System.out.println("hello, this is controller with");
        System.out.println(newItem);
        return service.createNewTodoItem(newItem);
    }
}
