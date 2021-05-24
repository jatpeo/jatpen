package com.jatpeo.yard.entity.book.dto;

import com.jatpeo.yard.entity.book.Book;
import com.jatpeo.yard.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * ReadBookDto
 *
 * @author jiatp
 * @date 2019/01/28 16:44
 * @email jatpeo@163.com
 * @description
 */
@Data
public class BookDTO extends Book {

    List<Tag> tagList;
}
