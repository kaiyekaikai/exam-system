package com.guet.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guet.exam.entity.Student;
import com.guet.exam.form.LoginForm;
import com.guet.exam.mapper.StudentMapper;
import com.guet.exam.service.StudentService;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

@Service
public class StudentSericeImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {


    @Override
    public Boolean isOsLogin(LoginForm loginForm) {
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(Student::getId,loginForm.getId());
        Student stu = getOne(queryWrapper);
        if (stu == null){
            return false;
        }
        String id = Integer.toString(stu.getId());
        if (id.substring(id.length()-5).equals(loginForm.getPassword())){
            return true;
        }
        return false;
    }

    @Override
    public Student getInfoById(int id) {
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Student::getId,id);
        Student student = getOne(queryWrapper);
        return student;
    }
}
