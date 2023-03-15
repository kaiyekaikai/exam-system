package com.guet.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guet.exam.entity.Student;
import com.guet.exam.entity.Teacher;
import com.guet.exam.form.LoginForm;

public interface Teacherservice extends IService<Teacher> {
    // 判断用户是否可以登录
    Boolean isOsLogin(LoginForm loginForm);

    // 根据id获取个人信息
    Teacher getInfoById(int id);
}
