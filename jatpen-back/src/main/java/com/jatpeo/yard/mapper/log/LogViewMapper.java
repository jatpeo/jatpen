package com.jatpeo.yard.mapper.log;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jatpeo.yard.entity.log.LogView;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 阅读日志 Mapper 接口
 * </p>
 *
 * @author jiatp
 * @since 2019-02-15
 */
@Mapper
public interface LogViewMapper extends BaseMapper<LogView> {

    int getVisitorNum();

}
