package com.jatpeo.yard.controller.portal;

import com.jatpeo.yard.common.Result;
import com.jatpeo.yard.common.annotation.LogLike;
import com.jatpeo.yard.common.annotation.LogView;
import com.jatpeo.yard.common.constants.RedisCacheNames;
import com.jatpeo.yard.common.util.PageUtils;
import com.jatpeo.yard.entity.book.BookNote;
import com.jatpeo.yard.service.BookNoteService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;


/**
 * BookNoteNoteAdminController
 *
 * @author jiatp
 * @date 2018/11/20 20:25
 * @email jatpeo@163.com
 * @description
 */
@RestController("bookNotePortalController")
@CacheConfig(cacheNames = {RedisCacheNames.BOOKNOTE})
public class BookNoteController {

    @Resource
    private BookNoteService bookNoteService;


    @GetMapping("/bookNote/{bookNoteId}")
    @LogView(type = "bookNote")
    public Result getBookNote(@PathVariable Integer bookNoteId) {
        BookNote bookNote = bookNoteService.getById(bookNoteId);
        return Result.ok().put("bookNote", bookNote);
    }

    @GetMapping("/bookNotes")
    @Cacheable
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = bookNoteService.queryPageCondition(params);
        return Result.ok().put("page", page);
    }

    @PutMapping("/bookNote/like/{id}")
    @LogLike(type = "bookNote")
    public Result likeBookNote(@PathVariable Integer id) {
        return Result.ok();
    }


}
