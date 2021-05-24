package com.jatpeo.yard.service.impl;

import com.google.common.collect.Maps;
import com.jatpeo.yard.common.Result;
import com.jatpeo.yard.mapper.article.ArticleMapper;
import com.jatpeo.yard.mapper.book.BookMapper;
import com.jatpeo.yard.mapper.book.BookNoteMapper;
import com.jatpeo.yard.mapper.log.LogLikeMapper;
import com.jatpeo.yard.mapper.log.LogViewMapper;
import com.jatpeo.yard.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by rubin on 2020-02-13.
 */
@Service
public class CountServiceImpl implements CountService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookNoteMapper bookNoteMapper;
    @Autowired
    private LogViewMapper logViewMapper;
    @Autowired
    private LogLikeMapper logLikeMapper;

    @Override
    public Result getCount() {
        Integer visitors, articles, books, bookNotes, likes;
        visitors = logViewMapper.getVisitorNum();
        articles = articleMapper.getArticleNum();
        books = bookMapper.getBookNum();
        bookNotes = bookNoteMapper.getBookNoteNum();
        likes = logLikeMapper.getLikeNum();
        Map<String, Integer> result = Maps.newHashMapWithExpectedSize(5);
        result.put("visitors", visitors);
        result.put("articles", articles);
        result.put("books", books);
        result.put("bookNotes", bookNotes);
        result.put("likes", likes);
        return Result.ok().put("data", result);
    }
}
