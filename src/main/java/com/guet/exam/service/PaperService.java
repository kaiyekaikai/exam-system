package com.guet.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guet.exam.entity.Paper;

import java.util.List;

public interface PaperService extends IService<Paper> {

    List<Paper> getUserPaperInfo(int id);
}
