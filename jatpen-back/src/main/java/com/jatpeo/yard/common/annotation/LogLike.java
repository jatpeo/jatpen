package com.jatpeo.yard.common.annotation;

import java.lang.annotation.*;

/**
 * ViewLog
 *
 * @author jiatp
 * @date 2019/02/15 14:51
 * @email jatpeo@163.com
 * @description
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogLike {

    String type();
}
