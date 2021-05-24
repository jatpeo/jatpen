package com.jatpeo.yard.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jatpeo.yard.common.util.PageUtils;
import com.jatpeo.yard.entity.book.BookNote;
import com.jatpeo.yard.entity.book.dto.BookNoteDTO;
import com.jatpeo.yard.entity.book.vo.BookNoteVO;

import java.util.List;
import java.util.Map;

/**
 * BookNoteAdminService
 *
 * @author jiatp
 * @date 2018/11/21 12:47
 * @email jatpeo@163.com
 * @description
 */
public interface BookNoteService extends IService<BookNote> {

    /**
     * 分页查询笔记列表
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存笔记笔记
     *
     * @param blogBookNote
     */
    void saveBookNote(BookNoteDTO blogBookNote);

    /**
     * 批量删除
     *
     * @param bookNoteIds
     */
    void deleteBatch(Integer[] bookNoteIds);

    /**
     * 更新笔记
     *
     * @param blogBookNote
     */
    void updateBookNote(BookNoteDTO blogBookNote);

    /**
     * 获取笔记对象
     *
     * @param bookNoteId
     * @return
     */
    BookNoteDTO getBookNote(Integer bookNoteId);

    /**
     * 判断该类别下是否有笔记
     *
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
     * 获取简单对象
     *
     * @param bookNoteId
     * @return
     */
    BookNoteVO getSimpleBookNoteVo(Integer bookNoteId);

    /**
     * 获取简单List
     *
     * @param bookId
     * @return
     */
    List<BookNote> listSimpleBookNote(Integer bookId);
}
