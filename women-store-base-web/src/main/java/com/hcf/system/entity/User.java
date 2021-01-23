package com.hcf.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author hcf
 * @since 2021-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_user")
@ApiModel(value="User对象", description="用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_Id", type = IdType.AUTO)
    private Integer userId;

    @TableField("user_Acount")
    private String userAcount;

    @TableField("user_Name")
    private String userName;

    @TableField("user_Phone")
    private String userPhone;

    @TableField("user_Priority")
    private Integer userPriority;

    @TableField("user_Address")
    private String userAddress;

    @TableField("user_Password")
    private String userPassword;

    @TableField("user_Status")
    private Integer userStatus;


}
