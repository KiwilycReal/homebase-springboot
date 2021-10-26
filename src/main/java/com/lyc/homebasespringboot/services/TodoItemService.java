package com.lyc.homebasespringboot.services;

import com.lyc.homebasespringboot.models.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class TodoItemService {

    @Autowired
    MongoTemplate mongoTemplate;

    public String createNewTodoItem(TodoItem newItem){
        System.out.println("hello, this is service with");
        mongoTemplate.insert(newItem);
        System.out.println(newItem);
        return newItem.getId();
    }

}
