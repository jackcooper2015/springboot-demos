package com.reapal.service.impl;

import com.reapal.dao.UserRepository;
import com.reapal.domain.User;
import com.reapal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by 10400 on 2017/1/10.
 */

@Component
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String name, String password) {
        return userRepository.findByNameAndPassword(name,password);
    }

    public User regiset(User user){
        user.setCreateDateTime(new Date());
        user.setModifyDateTime(new Date());
        user.setCreateBy("system");
        user.setModifyBy("system");
        user.setDeleteFlag("1");
        return userRepository.save(user);
    }

}
