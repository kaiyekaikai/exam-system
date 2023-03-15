package com.guet.exam.controller;

import com.guet.exam.common.R;
import com.guet.exam.entity.Student;
import com.guet.exam.entity.Teacher;
import com.guet.exam.form.LoginForm;
import com.guet.exam.service.Teacherservice;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private Teacherservice teacherservice;
    //登录
    @PostMapping("/login")
    public R<String> login(@RequestBody LoginForm loginForm){
        Boolean okLogin = teacherservice.isOsLogin(loginForm);
        if (okLogin){
            return R.success("登录成功");
        }
        return R.error("账号或密码错误");
    }

    // 获取个人信息
    @GetMapping()
    public R<Teacher> getInfo(int id){
        return R.success(teacherservice.getInfoById(id));
    }

}
