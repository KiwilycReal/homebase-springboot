package com.lyc.homebasespringboot.services;

import com.lyc.homebasespringboot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = mongoTemplate.findOne(
                Query.query(Criteria.where("username").is(username)), User.class
        );
        if(user == null){
            throw new UsernameNotFoundException("Username: "+username+" does not exist!");
        }
        return user;
    }

    public User registerNewUser(User user){
        return mongoTemplate.insert(user);
    }

    public boolean doesUsernameExist(String username) {
        User user = mongoTemplate.findOne(
                Query.query(Criteria.where("username").is(username)), User.class
        );

        return user == null;
    }

}
