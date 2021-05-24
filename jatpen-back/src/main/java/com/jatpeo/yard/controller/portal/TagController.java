package com.jatpeo.yard.controller.portal;

import com.jatpeo.yard.common.Result;
import com.jatpeo.yard.common.constants.RedisCacheNames;
import com.jatpeo.yard.entity.operation.vo.TagVO;
import com.jatpeo.yard.service.TagService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * TagController
 *
 * @author jiatp
 * @date 2019/02/22 16:34
 * @email jatpeo@163.com
 * @description
 */
@RestController("tagPortalController")
@CacheConfig(cacheNames = RedisCacheNames.TAG)
@RequestMapping("/operation")
public class TagController {

    @Resource
    private TagService tagService;

    @GetMapping("/tags")
    @Cacheable
    public Result listTag() {
        List<TagVO> tagList = tagService.listTagVo();
        return Result.ok().put("tagList", tagList);
    }

}
