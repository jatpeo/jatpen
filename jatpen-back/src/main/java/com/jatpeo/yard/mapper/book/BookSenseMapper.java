package com.jatpeo.yard.mapper.book;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jatpeo.yard.entity.book.BookSense;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 读后感 Mapper 接口
 * </p>
 *
 * @author jiatp
 * @since 2019-02-13
 */
@Mapper
public interface BookSenseMapper extends BaseMapper<BookSense> {

    BookSense selectByBookId(Integer bookId);

}
