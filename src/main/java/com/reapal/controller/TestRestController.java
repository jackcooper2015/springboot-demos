package com.reapal.controller;

import com.reapal.dao.UserRepository;
import com.reapal.domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 10400 on 2017/1/10.
 */

@RestController
public class TestRestController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/findAll")
    @ApiOperation(value = "获取用户列表",notes = "")
    public List<User> findAll(Model model){
        return (List<User>)userRepository.findAll();
    }

    @RequestMapping("/exists")
    @ApiOperation(value = "判断商户Id是否存在",notes = "")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    public boolean exists(Model model,User user){
        return userRepository.exists(user.getId());
    }

    @RequestMapping("/count")
    @ApiOperation(value = "获取用户列表总数",notes = "")
    public Long count(Model model,User user){
        return userRepository.count();
    }

}
