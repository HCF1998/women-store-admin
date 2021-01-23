package com.hcf.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hcf.system.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hcf
 * @since 2021-01-23
 */
public interface UserService extends IService<User> {
    IPage<User> findUserPage(Page<User> page, QueryWrapper<User> wrapper);

}
