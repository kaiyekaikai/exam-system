package com.guet.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guet.exam.entity.Student;
import com.guet.exam.form.LoginForm;

public interface StudentService extends IService<Student> {

    // 判断用户是否可以登录
    Boolean isOsLogin(LoginForm loginForm);

    // 根据id获取个人信息
    Student getInfoById(int id);

    // 根据token获取个人信息
    Student getUserInfoByToken(String token);
}
