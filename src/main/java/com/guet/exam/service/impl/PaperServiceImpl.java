package com.guet.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guet.exam.entity.Paper;
import com.guet.exam.mapper.PaperMapper;
import com.guet.exam.service.PaperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements PaperService {
    @Override
    public List<Paper> getUserPaperInfo(int id) {
        log.info("获取信息："+baseMapper.getUserPaperInfo(id).toString());
        return baseMapper.getUserPaperInfo(id);
    }
}
