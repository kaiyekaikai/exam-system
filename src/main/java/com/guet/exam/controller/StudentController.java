package com.guet.exam.controller;

import com.guet.exam.common.R;
import com.guet.exam.entity.Student;
import com.guet.exam.form.LoginForm;
import com.guet.exam.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/user")
public class StudentController {

    @Autowired
    private StudentService userService;

    // 登录接口
    @PostMapping("/login")
    public R<String> login(@RequestBody LoginForm loginForm){

        Boolean okLogin = userService.isOsLogin(loginForm);
        if (okLogin){
            return R.success("登录成功");
        }
        return R.error("账号或密码错误");
    }

    // 获取个人信息
    @GetMapping()
    public R<Student> getInfo(int id){
        return R.success(userService.getInfoById(id));
    }

}
