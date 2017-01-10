package com.reapal.controller;

import com.reapal.dao.UserRepository;
import com.reapal.domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 10400 on 2017/1/10.
 */

@RestController
@RequestMapping(value = "/users")
public class RestApiController {

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = { "" }, method = RequestMethod.GET)
    public List<User> getUserList() {
        List<User> users = (List<User>)userRepository.findAll();
        return users;
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        userRepository.save(user);
        return "success";
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return userRepository.findOne(id);
    }

    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
                         @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User") })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        User u = userRepository.findOne(id);
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        userRepository.save(u);
        return "success";
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        userRepository.delete(id);
        return "success";
    }

    @ApiOperation(value = "分页查询", notes = "")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "第几页",required = true, dataType = "Integer")
            ,@ApiImplicitParam(name = "size", value = "每页几条",required = true,  dataType = "Integer")})
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Page<User> list(  Integer page , Integer size) {
        PageRequest pageRequest = new PageRequest(page,size);
        return userRepository.findAll(pageRequest);
    }

}
