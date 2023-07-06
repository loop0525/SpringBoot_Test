package com.loop.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

//@Slf4j  //打印日志
@Component
public class MyMeteObjectHandler implements MetaObjectHandler {

    //插入时填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
//        log.info("start insert fill....");
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);

    }
    //更新时填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
//        log.info("start update fill....");
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
