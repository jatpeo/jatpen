package com.jatpeo.yard.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jatpeo.yard.common.util.PageUtils;
import com.jatpeo.yard.entity.sys.SysUser;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author jiatp
 * @since 2018-10-08
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 查询用户菜单
     *
     * @param userId
     * @return
     */
    List<Integer> queryAllMenuId(Integer userId);

    /**
     * 分页查询用户信息
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 更新密码
     *
     * @param userId
     * @param password
     * @param newPassword
     * @return
     */
    boolean updatePassword(Integer userId, String password, String newPassword);

    /**
     * 批量删除用户
     *
     * @param userIds
     */
    void deleteBatch(Integer[] userIds);
}
