package org.dishi.service;

import org.dishi.entity.Admin;
import org.dishi.entity.Permission;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * 后台用户管理Service
 * Created by macro on 2018/4/26.
 */
public interface AdminService {
    /**
     * 根据用户名获取后台管理员
     */
    Admin getAdminByUsername(String username);

    List<Permission> getPermissionList(long id);

    /**
     * 注册功能
     */
    Admin register(Admin admin);
//
//    /**
//     * 登录功能
//     * @param username 用户名
//     * @param password 密码
//     * @return 生成的JWT的token
//     */
//    String login(String username,String password);
//
//    /**
//     * 刷新token的功能
//     * @param oldToken 旧的token
//     */
//    String refreshToken(String oldToken);
//
//
//    /**
//     * 获取用户信息
//     */
//    UserDetails loadUserByUsername(String username);
}
