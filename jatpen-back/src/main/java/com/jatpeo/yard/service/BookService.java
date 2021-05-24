package com.jatpeo.yard.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jatpeo.yard.common.util.PageUtils;
import com.jatpeo.yard.entity.book.Book;
import com.jatpeo.yard.entity.book.dto.BookDTO;
import com.jatpeo.yard.entity.book.vo.BookVO;

import java.util.Map;

/**
 * <p>
 * 图书表 服务类
 * </p>
 *
 * @author jiatp
 * @since 2019-01-27
 */
public interface BookService extends IService<Book> {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存图书
     *
     * @param book
     */
    void saveBook(BookDTO book);

    /**
     * 获取图书对象
     *
     * @param id
     * @return
     */
    BookDTO getBook(String id);

    /**
     * 更新图书
     *
     * @param book
     */
    void updateBook(BookDTO book);

    /**
     * 批量删除
     *
     * @param bookIds
     */
    void deleteBatch(Integer[] bookIds);

    /**
     * @param categoryId
     * @return
     */
    boolean checkByCategory(Integer categoryId);

    /**
     * 分页分类获取列表
     *
     * @param params
     * @return
     */
    PageUtils queryPageCondition(Map<String, Object> params);

    /**
     * 获取Book对象
     *
     * @param id
     * @return
     */
    BookVO getBookVo(Integer id);
}
