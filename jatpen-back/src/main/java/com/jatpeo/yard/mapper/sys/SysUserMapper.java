package com.jatpeo.yard.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jatpeo.yard.entity.sys.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jiatp
 * @since 2018-10-08
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 查询用户所有权限
     *
     * @param userId
     * @return
     */
    List<String> queryAllPerms(Integer userId);

    /**
     * 查询用户的menuId
     *
     * @param userId
     * @return
     */
    List<Integer> queryAllMenuId(Integer userId);
}
