package com.cooper.factorymanager.Generator.Generator.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cooper.factorymanager.Generator.Generator.entity.User;
import com.cooper.factorymanager.Generator.Generator.mapper.UserMapper;
import com.cooper.factorymanager.Generator.Generator.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cooper
 * @since 2023-10-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     *
     * @AUTHOR:Cooper
     * @DATE 2023/8/18 22:25
     * @param user
     * @return Map<Object> 使用map封装数据
     *     Notice:
     *     旧方法是未经过密码加密使用
     *     已注释
     *
     *     新方法使用了spring-security加密过使用了加严 以此需要改变方法逻辑
     */
    @Override
    public Map<String, Object> login(User user) {
        //根据用户名密码查询
        LambdaQueryWrapper<User> Wrapper = new LambdaQueryWrapper<>();
        Wrapper.eq(User::getUsername,user.getUsername());
        Wrapper.eq(User::getPassword,user.getPassword());
        User loginUser = this.baseMapper.selectOne(Wrapper);
        //结果不为空，生成token 并存入redis
        if(loginUser != null){
            //暂时用UUID  去了解jwt
            String key ="user:" + UUID.randomUUID();
            //存入redis 序列化处理
            loginUser.setPassword(null);
            redisTemplate.opsForValue().set(key,loginUser,30, TimeUnit.MINUTES);
            //返回结果
            Map<String,Object> data = new HashMap<>();
            data.put("token",key);
            return data;
        }
        return null;
//        LambdaQueryWrapper<User> Wrapper = new LambdaQueryWrapper<>();
//        Wrapper.eq(User::getUsername,user.getUsername());
//        User loginUser = this.baseMapper.selectOne(Wrapper);
//        if(loginUser != null && passwordEncoder.matches(user.getPassword(),loginUser.getPassword())){
//            String key ="user:" + UUID.randomUUID();
//            loginUser.setPassword(null);
//            redisTemplate.opsForValue().set(key,loginUser,30, TimeUnit.MINUTES);
//            Map<String,Object> data = new HashMap<>();
//            data.put("token",key);
//            return data;
//        }
//        return null;
    }

    @Override
    public Map<String, Object> getUserInfo(String token) {
        //根据token获取用户信息 反序列化
        Object ob = redisTemplate.opsForValue().get(token);
        if(ob != null){
            User loginUser = JSON.parseObject(JSON.toJSONString(ob),User.class);
            Map<String,Object> data = new HashMap<>();
            data.put("name",loginUser.getUsername());
            data.put("avatar",loginUser.getAvatar());

            List<String> roleList = this.baseMapper.getRoleNameByUserId(loginUser.getId());
            data.put("roles",roleList);
            return data;
        }
        return null;
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete(token);
    }
}
