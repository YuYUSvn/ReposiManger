package com.sxt.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.IPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.system.common.DataGridView;
import com.sxt.system.dao.LoginfoDao;
import com.sxt.system.model.Loginfo;
import com.sxt.system.service.LogInfoService;
import com.sxt.system.vo.LogInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LogInfoServiceImpl extends ServiceImpl<LoginfoDao, Loginfo> implements LogInfoService {
    @Autowired
    private LoginfoDao dao;

    @Override
    public DataGridView queryAllLogInfo(LogInfoVo loginfo) {
        PageHelper.startPage(loginfo.getPage(),loginfo.getLimit());
        QueryWrapper<Loginfo> qp=new QueryWrapper<Loginfo>();
        qp.like(StringUtils.isNotBlank(loginfo.getLoginname()),"loginname",loginfo.getLoginname());
        qp.like(StringUtils.isNotBlank(loginfo.getLoginip()),"loginip",loginfo.getLoginip());
        qp.ge(loginfo.getStartTime()!=null,"logintime",loginfo.getStartTime());
        qp.le(loginfo.getStartTime()!=null,"logintime",loginfo.getEndTime());
        qp.orderByDesc("logintime");
        Page<Loginfo> page= (Page<Loginfo>) dao.selectList(qp);

        return new DataGridView(page.getTotal(),page.getResult());
    }
}
