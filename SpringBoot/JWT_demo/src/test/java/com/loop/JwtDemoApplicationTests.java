package com.loop;

import com.loop.utils.NewAutoGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JwtDemoApplicationTests {

    @Test
    void contextLoads() {
        NewAutoGenerator.Generation("springboot_test","user");
    }

}
