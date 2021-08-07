package com.adk.ssm.dao;

import com.adk.ssm.domain.SysLog;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SysLogMapper {
    public void save(SysLog sysLog);
    public List<SysLog> findAll();
}
