package com.sxt.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxt.system.common.DataGridView;
import com.sxt.system.model.Loginfo;
import com.sxt.system.vo.LogInfoVo;

public interface LogInfoService extends IService<Loginfo> {
    DataGridView queryAllLogInfo(LogInfoVo loginfo);
}
