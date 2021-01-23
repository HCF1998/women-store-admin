package com.hcf.system.controller.admin;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hcf.response.Result;
import com.hcf.system.entity.User;
import com.hcf.system.service.UserService;
import com.hcf.system.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 * @author hcf
 * @since 2021-01-23
 */
@Api("后台用户管理")
@RestController
@RequestMapping("/system/admin/user")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation(value = "查询用户列表",notes = "从用户列表中分组查询用户")
    @GetMapping("/findUserList")
    public Result findUserList(@RequestParam(required = true,defaultValue ="1")Integer current,
                               @RequestParam(required = true,defaultValue ="6")Integer size){
        Page<User> page = new Page<>(current,size);
        Page<User> userPage = userService.page(page);
        long total = userPage.getTotal();
        List<User> records = userPage.getRecords();
        return Result.ok().data("total",total).data("record",records);
    }

    private QueryWrapper<User> getWrapper(UserVO userVO){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (userVO!=null){
            if (!StringUtils.isEmpty(userVO.getUserId())){
                queryWrapper.eq("user_Id",userVO.getUserId());
            }
            if (!StringUtils.isEmpty(userVO.getUserAcount())){
                queryWrapper.eq("user_Acount",userVO.getUserAcount());
            }
            if (!StringUtils.isEmpty(userVO.getUserName())){
                queryWrapper.eq("user_Name",userVO.getUserName());
            }
            if (!StringUtils.isEmpty((userVO.getUserPriority()))){
                queryWrapper.eq("user_Priority",userVO.getUserPriority());
            }
            if (!StringUtils.isEmpty(userVO.getUserStatus())){
                queryWrapper.eq("user_Status",userVO.getUserStatus());
            }
        }
        return queryWrapper;
    }
}

