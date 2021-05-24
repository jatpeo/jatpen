package com.jatpeo.yard.service;

import com.jatpeo.yard.common.Result;
import com.jatpeo.yard.entity.sys.SysUserToken;

/**
 * SysUserTokenService
 *
 * @author jiatp
 * @date 2018/10/20 15:17
 * @email jatpeo@163.com
 * @description
 */
public interface SysUserTokenService {
    /**
     * 生成Token
     *
     * @param userId
     * @return
     */
    Result createToken(Integer userId);

    /**
     * 查询token
     *
     * @param token
     * @return
     */
    SysUserToken queryByToken(String token);

    /**
     * 退出登录
     *
     * @param userId
     */
    void logout(Integer userId);

    /**
     * 续期
     *
     * @param userId
     * @param token
     */
    void refreshToken(Integer userId, String token);
}
