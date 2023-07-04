package com.loop.mybatisplus_demo;

import com.loop.mybatisplus_demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WrapperTest {
    @Autowired(required = false)
    UserMapper userMapper;


    @Test
    public void test(){

    }

}
