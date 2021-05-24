package com.jatpeo.yard.entity.sys.form;

import lombok.Data;

/**
 * SysLoginForm
 *
 * @author jiatp
 * @date 2018/10/20 14:51
 * @email jatpeo@163.com
 * @description 登录表单对象
 */
@Data
public class SysLoginForm {
    private String username;
    private String password;
    private String captcha;
    private String uuid;
}
