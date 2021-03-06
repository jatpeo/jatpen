package com.jatpeo.yard.controller.manage;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * BookNoteAdminController
 *
 * @author jiatp
 * @date 2019/11/12 20:25
 * @email jatpeo@163.com
 * @description
 */
@RestController
@RequestMapping("/admin/operation/redis")
public class RedisCacheController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


}
