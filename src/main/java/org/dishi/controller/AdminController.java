package org.dishi.controller;

import org.dishi.common.response.ServerResponse;
import org.dishi.entity.Admin;
import org.dishi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("register")
    public ServerResponse<String> register(@RequestBody Admin admin){
        adminService.register(admin);
        return ServerResponse.createBySuccessMessage("注册成功");
    }

    @PostMapping("login")
    public ServerResponse<String> login(@RequestBody Admin admin){
        String token = adminService.login(admin.getUsername(), admin.getPassword());
        if(token==null){
            return ServerResponse.createByErrorMessage("用户名或密码错误");
        }
        return ServerResponse.createBySuccess("登录成功", token);
    }
}
