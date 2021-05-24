package com.jatpeo.yard.controller.portal;

import com.jatpeo.yard.common.Result;
import com.jatpeo.yard.entity.operation.vo.RecommendVO;
import com.jatpeo.yard.service.RecommendService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Recommend
 *
 * @author jiatp
 * @date 2019/02/22 13:40
 * @email jatpeo@163.com
 * @description
 */
@RestController("recommendPortalController")
@RequestMapping("/operation")
public class RecommendController {

    @Resource
    private RecommendService recommendService;

    @RequestMapping("/recommends")
    public Result listRecommend() {
        List<RecommendVO> recommendList = recommendService.listRecommendVo();
        return Result.ok().put("recommendList", recommendList);
    }

    @RequestMapping("/hotReads")
    public Result listHotRead() {
        List<RecommendVO> hotReadList = recommendService.listHotRead();
        return Result.ok().put("hotReadList", hotReadList);
    }
}
