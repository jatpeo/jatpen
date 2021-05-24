package com.jatpeo.yard.entity.timeline;

import lombok.Data;

import java.util.List;

/**
 * TimeLine
 *
 * @author jiatp
 * @date 2019/02/24 20:33
 * @email jatpeo@163.com
 * @description
 */
@Data
public class Timeline {

    private Integer year;

    private Integer count;

    private List<TimelineMonth> months;
}
