package com.guet.exam.controller;


import com.auth0.jwt.JWT;
import com.guet.exam.common.PassToken;
import com.guet.exam.common.R;
import com.guet.exam.common.UserLoginToken;
import com.guet.exam.entity.Paper;
import com.guet.exam.entity.Student;
import com.guet.exam.service.PaperService;
import com.guet.exam.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/paper")
@Slf4j
public class PaperController {

    @Autowired
    private PaperService paperService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/user")
    @PassToken
    public R<List<Paper>> getUserPaperInfo(){
        String token = request.getHeader("x-token");
        String id = JWT.decode(token).getClaim("id").asString();
        log.info("id:"+id);
        log.info("信息:"+paperService.getUserPaperInfo(Integer.parseInt(id)));
        return R.success(paperService.getUserPaperInfo(Integer.parseInt(id)));
    }
}
