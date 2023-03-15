package com.guet.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guet.exam.entity.Student;
import com.guet.exam.entity.Teacher;
import com.guet.exam.form.LoginForm;
import com.guet.exam.mapper.TeacherMapper;
import com.guet.exam.service.Teacherservice;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements Teacherservice {
    @Override
    public Boolean isOsLogin(LoginForm loginForm) {
        LambdaQueryWrapper<Teacher> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(Teacher::getId,loginForm.getId());
        Teacher teacher = getOne(queryWrapper);
        if (teacher == null){
            return false;
        }
        String id = Integer.toString(teacher.getId());
        if (id.substring(id.length()-5).equals(loginForm.getPassword())){
            return true;
        }
        return false;
    }

    @Override
    public Teacher getInfoById(int id) {
        LambdaQueryWrapper<Teacher> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Teacher::getId,id);
        Teacher teacher = getOne(queryWrapper);
        return teacher;
    }
}
