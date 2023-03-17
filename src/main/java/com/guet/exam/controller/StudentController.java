package com.guet.exam.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guet.exam.common.PassToken;
import com.guet.exam.common.R;
import com.guet.exam.common.UserLoginToken;
import com.guet.exam.entity.Student;
import com.guet.exam.form.FaceForm;
import com.guet.exam.form.LoginForm;
import com.guet.exam.service.StudentService;
import com.guet.exam.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@RestController
@Slf4j
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService userService;

    @Autowired
    private HttpServletRequest request;

    // 登录接口
    @PostMapping("/login")
    public R<String> login(@RequestBody LoginForm loginForm){

        Boolean okLogin = userService.isOsLogin(loginForm);

        if (!okLogin){
            return R.error("账号或密码错误");
        }

        // 根据id生成token
        String token = TokenUtils.token(loginForm.getId());
        return R.success(token);
    }

    // 获取个人信息
    @GetMapping()
    @UserLoginToken
    public R<Student> getInfo(){
        String token = request.getHeader("x-token");
        log.info("获取token："+token);
        return R.success(userService.getUserInfoByToken(token));
    }

    // 测试人脸识别
    @PostMapping("/recognize")
    @PassToken
    public R<String> testFace(@RequestBody FaceForm faceForm){
        log.info("faceForm:"+faceForm.toString());
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Student::getId,"102001");
        Student student = userService.getOne(queryWrapper);
        ObjectMapper objectMapper = new ObjectMapper();
        faceForm.setFaceVector(student.getFaceVector());

        try {
            String json = objectMapper.writeValueAsString(faceForm);
            HttpClient httpClient = HttpClientBuilder.create().build();

            HttpPost httpPost = new HttpPost("http://127.0.0.1:8082/recognize");

            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-type", "application/json");
            HttpResponse httpResponse = httpClient.execute(httpPost);
            String responseBody = EntityUtils.toString(httpResponse.getEntity());
            log.info("响应数据："+responseBody);
        } catch (Exception e) {

            e.printStackTrace();
        }

        return R.success("ok");
    }


}
