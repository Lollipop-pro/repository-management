package com.cooper.factorymanager.Generator.Generator.mapper;

import com.cooper.factorymanager.Generator.Generator.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cooper
 * @since 2023-10-08
 */
public interface UserMapper extends BaseMapper<User> {

    List<String> getRoleNameByUserId(Integer id);
}
