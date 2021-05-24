package com.jatpeo.yard.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jatpeo.yard.common.util.PageUtils;
import com.jatpeo.yard.entity.sys.SysRole;

import java.util.List;
import java.util.Map;

/**
 * SysRoleService
 *
 * @author jiatp
 * @date 2018/10/25 15:36
 * @email jatpeo@163.com
 * @description
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 分页查询角色
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 批量删除
     *
     * @param roleIds
     */
    void deleteBatch(Integer[] roleIds);

    /**
     * 查询roleId
     *
     * @param createUserId
     * @return
     */
    List<Integer> queryRoleIdList(Integer createUserId);
}
