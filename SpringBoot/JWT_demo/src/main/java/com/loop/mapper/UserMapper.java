package com.loop.mapper;

import com.loop.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author loop0525
 * @since 2023-07-06
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
