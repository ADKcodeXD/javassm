package com.adk.ssm.service;

import com.adk.ssm.domain.SysLog;

import java.util.List;

public interface ILogAopService {


    public void save(SysLog sysLog);

    public List<SysLog> findAll(int page,int pageszie);
}
