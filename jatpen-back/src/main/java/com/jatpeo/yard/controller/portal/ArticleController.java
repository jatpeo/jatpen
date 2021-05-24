package com.jatpeo.yard.controller.portal;


import com.jatpeo.yard.common.Result;
import com.jatpeo.yard.common.annotation.LogLike;
import com.jatpeo.yard.common.annotation.LogView;
import com.jatpeo.yard.common.util.PageUtils;
import com.jatpeo.yard.entity.article.Article;
import com.jatpeo.yard.entity.article.vo.ArticleVO;
import com.jatpeo.yard.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文章 前端控制器
 * </p>
 *
 * @author jiatp
 * @since 2018-11-07
 */
@RestController("articlePortalController")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/article/{articleId}")
    @LogView(type = "article")
    public Result getArticle(@PathVariable Integer articleId) {
        ArticleVO article = articleService.getArticleVo(articleId);
        return Result.ok().put("article", article);
    }

    @PutMapping("/article/like/{id}")
    @LogLike(type = "article")
    public Result likeArticle(@PathVariable Integer id) {
        return Result.ok();
    }

    @GetMapping("/articles")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = articleService.queryPageCondition(params);
        return Result.ok().put("page", page);
    }

    /**
     * 搜索标题，描述，内容
     *
     * @param keywords
     * @return
     */
    @GetMapping("articles/search")
    public Result search(@RequestParam("keywords") String keywords) {
        List<Article> articleList = articleService.search(keywords);
        return Result.ok().put("articleList", articleList);
    }

}
