package com.jatpeo.yard.service;

import com.jatpeo.yard.entity.timeline.Timeline;

import java.util.List;

/**
 * TimeLineService
 *
 * @author jiatp
 * @date 2019/02/24 20:47
 * @email jatpeo@163.com
 * @description
 */
public interface TimelineService {

    /**
     * 获取timeLine数据
     *
     * @return
     */
    List<Timeline> listTimeLine();
}
