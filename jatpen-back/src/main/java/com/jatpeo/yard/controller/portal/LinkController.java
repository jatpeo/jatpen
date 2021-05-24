package com.jatpeo.yard.controller.portal;

import com.jatpeo.yard.common.Result;
import com.jatpeo.yard.common.constants.RedisCacheNames;
import com.jatpeo.yard.entity.operation.Link;
import com.jatpeo.yard.service.LinkService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * LinkController
 *
 * @author jiatp
 * @date 2019/02/21 17:09
 * @email jatpeo@163.com
 * @description
 */
@RequestMapping("/operation")
@CacheConfig(cacheNames = RedisCacheNames.LINK)
@RestController("LinkPortalController")
public class LinkController {

    @Resource
    private LinkService linkService;

    @RequestMapping("/links")
    @Cacheable
    public Result listLink() {
        List<Link> linkList = linkService.listLink();
        return Result.ok().put("linkList", linkList);
    }
}
