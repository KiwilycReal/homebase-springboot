package com.lyc.homebasespringboot.services;

import com.lyc.homebasespringboot.models.TodoItem;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoItemService {

    @Autowired
    MongoTemplate mongoTemplate;

    public TodoItem createNewTodoItem(TodoItem newItem){
        return mongoTemplate.insert(newItem);
    }

    public TodoItem updateTodoItem(TodoItem updatedItem){
        return mongoTemplate.save(updatedItem);
    }

    public Boolean deleteTodoItem(String id){
        return mongoTemplate.remove(
                Query.query(Criteria.where("id").is(id)),
                TodoItem.class
        ).wasAcknowledged();
    }

    public List<TodoItem> fetchTodoItemList(){
        return mongoTemplate.findAll(TodoItem.class);
    }

}
