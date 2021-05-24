package com.jatpeo.yard.controller.portal;

import com.jatpeo.yard.common.Result;
import com.jatpeo.yard.entity.timeline.Timeline;
import com.jatpeo.yard.service.TimelineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * TimeLineController
 *
 * @author jiatp
 * @date 2019/02/24 20:46
 * @email jatpeo@163.com
 * @description
 */
@RestController
@RequestMapping("/timeline")
public class TimelineController {

    @Resource
    private TimelineService timelineService;

    @GetMapping("")
    public Result listTimeline() {
        List<Timeline> timelineList = timelineService.listTimeLine();

        return Result.ok().put("timelineList", timelineList);
    }
}
