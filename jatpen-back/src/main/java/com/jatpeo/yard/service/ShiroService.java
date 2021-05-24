package com.jatpeo.yard.service;

import com.jatpeo.yard.entity.sys.SysUser;
import com.jatpeo.yard.entity.sys.SysUserToken;

import java.util.Set;

/**
 * ShiroService
 *
 * @author jiatp
 * @date 2018/10/08 19:58
 * @email jatpeo@163.com
 * @description service接口类
 */
public interface ShiroService {

    /**
     * 获取用户的所有权限
     *
     * @param userId
     * @return
     */
    Set<String> getUserPermissions(Integer userId);

    /**
     * 查询token
     *
     * @param token
     * @return
     */
    SysUserToken queryByToken(String token);

    /**
     * 查询用户信息
     *
     * @param userId
     * @return
     */
    SysUser queryUser(Integer userId);

    /**
     * 续期
     *
     * @param userId
     * @param accessToken
     */
    void refreshToken(Integer userId, String accessToken);
}
