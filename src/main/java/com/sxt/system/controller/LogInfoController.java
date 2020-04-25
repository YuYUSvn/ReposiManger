package com.sxt.system.controller;

import com.sxt.system.service.LogInfoService;
import com.sxt.system.vo.LogInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("logInfo")
public class LogInfoController {
    @Autowired
    private LogInfoService service;

    @RequestMapping("loadAllLogInfo")
    public Object loadAllLogInfo(LogInfoVo logInfoVo){
        return service.queryAllLogInfo(logInfoVo);
    }
}
