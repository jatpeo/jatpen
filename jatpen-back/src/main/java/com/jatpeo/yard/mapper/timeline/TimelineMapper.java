package com.jatpeo.yard.mapper.timeline;

import com.jatpeo.yard.entity.timeline.Timeline;
import com.jatpeo.yard.entity.timeline.TimelinePost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TimeLineMapper
 *
 * @author jiatp
 * @date 2019/02/24 20:53
 * @email jatpeo@163.com
 * @description
 */
@Mapper
public interface TimelineMapper {

    List<TimelinePost> listTimelinePost(@Param("year") Integer year, @Param("month") Integer month);

    List<Timeline> listTimeline();
}
