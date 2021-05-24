package com.jatpeo.yard.common.base;

import com.jatpeo.yard.entity.sys.SysUser;
import org.apache.shiro.SecurityUtils;

/**
 * AbstractController
 *
 * @author jiatp
 * @date 2018/10/22 12:35
 * @email jatpeo@163.com
 * @description
 */
public class AbstractController {

    protected SysUser getUser() {
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    protected Integer getUserId() {
        return getUser().getUserId();
    }
}
