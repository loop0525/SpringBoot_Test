package com.loop.controller;


import com.loop.pojo.User;
import com.loop.utils.JwtUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author loop0525
 * @since 2023-07-06
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @ApiOperation("登录生成Token")
    @PostMapping("/login")
    public String login(@RequestBody User user){
        // 创建jwtToken
        String token = JwtUtil.generateToken(UUID.randomUUID().toString(), // uuid作为令牌id
                user.getName(), // 令牌中的额外信息
                1800000L // 过期时间 30min
                );
        // 把令牌作为信息返回给客户端
        return token;
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/info")
    public String getinfo(String token){
        String username = JwtUtil.parseToken(token).getSubject();
        return username;
    }
}

