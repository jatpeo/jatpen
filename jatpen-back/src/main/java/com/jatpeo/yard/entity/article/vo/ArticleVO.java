package com.jatpeo.yard.entity.article.vo;

import com.jatpeo.yard.entity.article.Article;
import com.jatpeo.yard.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * ArticleVo
 *
 * @author jiatp
 * @date 2019/01/09 16:51
 * @email jatpeo@163.com
 * @description 文章列表VO
 */
@Data
public class ArticleVO extends Article {

    /**
     * 所属分类，以逗号分隔
     */
    private String categoryListStr;

    /**
     * 所属标签
     */
    private List<Tag> tagList;

}
