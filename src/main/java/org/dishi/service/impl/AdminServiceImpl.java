package org.dishi.service.impl;

import org.dishi.entity.Admin;
import org.dishi.entity.Permission;
import org.dishi.service.AdminService;
import org.dishi.utis.JwtTokenUtil;
import org.dishi.utis.VirtualUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public Admin getAdminByUsername(String username) {
        return VirtualUser.virtualUser.get(username);
    }

    @Override
    public List<Permission> getPermissionList(String name) {
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
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            System.out.println(e.getMessage());
        }
        return token;
    }
}
