package com.jatpeo.yard.entity.operation.vo;

import com.jatpeo.yard.entity.operation.Recommend;
import com.jatpeo.yard.entity.operation.Tag;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * RecommendVo
 *
 * @author jiatp
 * @date 2019/02/22 10:49
 * @email jatpeo@163.com
 * @description
 */
@Data
public class RecommendVO extends Recommend {

    private String description;

    private Long readNum;

    private Long commentNum;

    private Long likeNum;

    private String urlType;

    private String cover;

    private Date createTime;

    private List<Tag> tagList;

}
