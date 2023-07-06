package com.loop.controller;


import com.loop.mapper.UserMapper;
import com.loop.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author loop0525
 * @since 2023-07-05
 */
@Api(tags = "测试！")
@RestController
@CrossOrigin  // 当前所有API允许跨域访问
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;
    @ApiOperation("测试读取一条记录！")
    @GetMapping("/1")
    public String test1(){
        User user = userMapper.selectById(1L);
        return user.toString();
    }
    @ApiOperation("测试读取一条记录返回json！")
    @ResponseBody //自动返回json数据
    @GetMapping("/2")
    public User test2(){
        User user = userMapper.selectById(1L);
        return user;
    }
}

