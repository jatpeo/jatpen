package com.jatpeo.yard.entity.article.dto;

import com.jatpeo.yard.entity.article.Article;
import com.jatpeo.yard.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * ArticleDto
 *
 * @author jiatp
 * @date 2019/01/08 19:04
 * @email jatpeo@163.com
 * @description
 */
@Data
public class ArticleDTO extends Article {

    private List<Tag> tagList;

}
