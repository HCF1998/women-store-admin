package com.hcf.system.service.impl;

import com.hcf.system.entity.User;
import com.hcf.system.mapper.UserMapper;
import com.hcf.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author hcf
 * @since 2021-01-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
