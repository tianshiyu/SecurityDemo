package org.dishi.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Admin {
    private Long id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "是否启用")
    private Integer status;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
