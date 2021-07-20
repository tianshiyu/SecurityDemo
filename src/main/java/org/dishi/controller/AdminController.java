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
        adminService.login(admin.getUsername(), admin.getPassword());
        return ServerResponse.createBySuccessMessage("登录成功");
    }
}
