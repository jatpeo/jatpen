package com.jatpeo.yard.controller.portal;


import com.jatpeo.yard.common.Result;
import com.jatpeo.yard.common.annotation.LogLike;
import com.jatpeo.yard.common.annotation.LogView;
import com.jatpeo.yard.common.constants.RedisCacheNames;
import com.jatpeo.yard.common.util.PageUtils;
import com.jatpeo.yard.entity.book.vo.BookVO;
import com.jatpeo.yard.service.BookService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 文章 前端控制器
 * </p>
 *
 * @author jiatp
 * @since 2018-11-07
 */
@RestController("bookPortalController")
@CacheConfig(cacheNames = {RedisCacheNames.BOOK})
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping("/book/{bookId}")
    @LogView(type = "book")
    public Result getBook(@PathVariable Integer bookId) {
        BookVO book = bookService.getBookVo(bookId);
        return Result.ok().put("book", book);
    }

    @GetMapping("/books")
    @Cacheable
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = bookService.queryPageCondition(params);
        return Result.ok().put("page", page);
    }

    @PutMapping("/book/like/{id}")
    @LogLike(type = "book")
    public Result likeBook(@PathVariable Integer id) {
        return Result.ok();
    }


}
