package com.guet.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guet.exam.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
