package com.adk.ssm.controller;

import com.adk.ssm.domain.SysLog;
import com.adk.ssm.service.LogAopService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class LogController {

    @Autowired
    private LogAopService logAopService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1") Integer page, @RequestParam(name = "pagesize",defaultValue = "10") Integer pagesize){
        List<SysLog> sysLogList=logAopService.findAll(page,pagesize);
        PageInfo pageInfo = new PageInfo(sysLogList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("sysLogs",pageInfo);
        mv.setViewName("syslog-list");
        return mv;

    }
}
