package com.sxt.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxt.system.dao.NoticeDao;
import com.sxt.system.model.Notice;
import com.sxt.system.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NoticeServiceImpl extends ServiceImpl<NoticeDao, Notice> implements NoticeService {
    @Autowired
    private NoticeDao dao;
}
