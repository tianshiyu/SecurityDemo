package org.dishi.service.impl;

import org.dishi.entity.Admin;
import org.dishi.entity.Permission;
import org.dishi.service.AdminService;
import org.dishi.utis.VirtualUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Admin getAdminByUsername(String username) {
        return VirtualUser.virtualUser.get(username);
    }

    @Override
    public List<Permission> getPermissionList(long id) {
        return new ArrayList<>();
    }

    @Override
    public Admin register(Admin admin) {
        admin.setCreateTime(new Date());
        admin.setStatus(1);
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        VirtualUser.virtualUser.put(admin.getUsername(), admin);
        return admin;
    }

    @Override
    public String login(String username, String password) {
        return null;
    }
}
