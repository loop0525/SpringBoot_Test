package com.loop.mybatisplus_demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.loop.mybatisplus_demo.mapper.UserMapper;
import com.loop.mybatisplus_demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisplusDemoApplicationTests {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    //测试插入
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("loop");
        user.setAge(30);
        user.setEmail("1477824757@qq.com");

        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user);
    }
    //测试更新
    @Test
    public void testupdate() {
        User user = new User();
        user.setId(2L);
        user.setName("loop2");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }
    //测试填充策略
    @Test
    public void testfillstrategy() {
        User user = new User();
        user.setName("loop");
        user.setAge(30);
        user.setEmail("1477824757@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);

//        User user = new User();
//        user.setId(1676178006135377924L);
//        user.setAge(30);
//        user.setEmail("12345678@qq.com");
//        int insert = userMapper.updateById(user);
//        System.out.println(insert);
    }
    //测试乐观锁
    @Test
    public void testVersion() {
        //查询用户(模拟1)
        User user = userMapper.selectById(2L);
        user.setName("loopbook");

        //查询用户(模拟2)
        User user2 = userMapper.selectById(2L);
        user2.setName("looptest");

        userMapper.updateById(user2); // 插队修改成功
        userMapper.updateById(user); //由于乐观锁的作用修改失败

    }
    //测试条件查询
    @Test
    public void testSelect(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("age",20);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }
    //测试分页查询
    @Test
    public void testPage() {
        Page<User> page = new Page<>(1,3); //第1页，5个数据
        userMapper.selectPage(page,null);

        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());//获取总的记录数
    }
    //测试删除
    @Test
    public void testDelete(){
        userMapper.deleteById(7L);
    }
    //测试逻辑删除
    @Test
    public void testLogicDelete(){
        userMapper.deleteById(6L);
    }
    @Test
    public void testLogicSelect(){
        userMapper.selectById(6L);
    }
    // 条件构造器
    @Test
    public void test(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name").ge("age",25); //姓名不为空，年龄大于等于12
        userMapper.selectList(wrapper).forEach(System.out::println);
    }
    //代码自动生成器
    @Test
    public void testGenerator(){

        NewAutoGenerator.Generation("springboot_test","user2");
    }

}


