package com.guet.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guet.exam.entity.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PaperMapper extends BaseMapper<Paper> {

    @Select("select * from paper  where major = (select major from student where id = #{id})")
    public List<Paper> getUserPaperInfo(int id);
}
