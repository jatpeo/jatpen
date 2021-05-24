package com.jatpeo.yard.entity.book.dto;

import com.jatpeo.yard.entity.book.BookNote;
import com.jatpeo.yard.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * BookNote
 *
 * @author jiatp
 * @date 2019/01/08 19:04
 * @email jatpeo@163.com
 * @description
 */
@Data
public class BookNoteDTO extends BookNote {

    private List<Tag> tagList;

}
