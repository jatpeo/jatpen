package com.jatpeo.yard.entity.book.vo;

import com.jatpeo.yard.entity.book.Book;
import com.jatpeo.yard.entity.book.BookNote;
import com.jatpeo.yard.entity.book.BookSense;
import com.jatpeo.yard.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * ReadBookVo
 *
 * @author jiatp
 * @date 2019/01/29 14:17
 * @email jatpeo@163.com
 * @description
 */
@Data
public class BookVO extends Book {

    /**
     * 所属分类，以逗号分隔
     */
    private String categoryListStr;

    /**
     * 所属标签
     */
    private List<Tag> tagList;

    /**
     * 所属笔记
     */
    private List<BookNote> bookNoteList;

    /**
     * 读后感
     */
    private BookSense bookSense;
}
