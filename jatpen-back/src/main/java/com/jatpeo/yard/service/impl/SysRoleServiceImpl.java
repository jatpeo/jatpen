package com.jatpeo.yard.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jatpeo.yard.common.constants.SysConstants;
import com.jatpeo.yard.common.exception.MyException;
import com.jatpeo.yard.common.util.PageUtils;
import com.jatpeo.yard.common.util.Query;
import com.jatpeo.yard.entity.sys.SysRole;
import com.jatpeo.yard.mapper.sys.SysRoleMapper;
import com.jatpeo.yard.service.SysRoleMenuService;
import com.jatpeo.yard.service.SysRoleService;
import com.jatpeo.yard.service.SysUserRoleService;
import com.jatpeo.yard.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * SysRoleServiceImpl
 *
 * @author jiatp
 * @date 2018/10/25 15:36
 * @email jatpeo@163.com
 * @description
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String roleName = (String) params.get("roleName");
        Long createUserId = (Long) params.get("createUserId");
        IPage<SysRole> page = baseMapper.selectPage(new Query<SysRole>(params).getPage(),
                new QueryWrapper<SysRole>().lambda()
                        .like(StringUtils.isNotBlank(roleName), SysRole::getRoleName, roleName)
                        .eq(createUserId != null, SysRole::getCreateUserId, createUserId)
        );
        return new PageUtils(page);
    }

    @Override
    public void deleteBatch(Integer[] roleIds) {
        //????????????
        this.removeByIds(Arrays.asList(roleIds));

        //???????????????????????????
        sysRoleMenuService.deleteBatchByRoleId(roleIds);

        //???????????????????????????
        sysUserRoleService.deleteBatchByRoleId(roleIds);
    }

    /**
     * ??????roleId
     *
     * @param createUserId
     * @return
     */
    @Override
    public List<Integer> queryRoleIdList(Integer createUserId) {
        return baseMapper.queryRoleIdList(createUserId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(SysRole role) {
        role.setCreateTime(new Date());
        baseMapper.insert(role);

        //????????????????????????
        checkPrems(role);

        //???????????????????????????
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateById(SysRole role) {
        baseMapper.updateById(role);

        //????????????????????????
        checkPrems(role);

        //???????????????????????????
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
        return true;
    }


    /**
     * ????????????????????????
     */
    private void checkPrems(SysRole role) {
        //???????????????????????????????????????????????????????????????????????????????????????
        if (SysConstants.SUPER_ADMIN.equals(role.getCreateUserId())) {
            return;
        }

        //????????????????????????????????????
        List<Integer> menuIdList = sysUserService.queryAllMenuId(role.getCreateUserId());

        //??????????????????
        if (!menuIdList.containsAll(role.getMenuIdList())) {
            throw new MyException("???????????????????????????????????????????????????");
        }
    }
}
