package com.loop;

import com.loop.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestfulSwaggerApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        userMapper.deleteById(2L);
    }

    //生成代码
    @Test
    void generationCode() {
        NewAutoGenerator.Generation("springboot_test","user");
    }

}
