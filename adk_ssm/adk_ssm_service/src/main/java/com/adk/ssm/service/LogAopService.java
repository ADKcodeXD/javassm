package com.adk.ssm.service;

import com.adk.ssm.dao.SysLogMapper;
import com.adk.ssm.domain.SysLog;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class LogAopService implements ILogAopService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public void save(SysLog sysLog) {
        sysLogMapper.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(int page,int pageszie) {
        PageHelper.startPage(page,pageszie);
        List<SysLog> logList = sysLogMapper.findAll();
        return logList;
    }
}
