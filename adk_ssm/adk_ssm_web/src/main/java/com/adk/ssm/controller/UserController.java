package com.adk.ssm.controller;

import com.adk.ssm.dao.UserMapper;
import com.adk.ssm.domain.Orders;
import com.adk.ssm.domain.UserInfo;
import com.adk.ssm.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(value = "page",defaultValue = "1")int page,@RequestParam(value = "pagesize",defaultValue = "4")int pagesize){
        List<UserInfo> userInfoList=userService.findAll(page,pagesize);
        PageInfo userList = new PageInfo(userInfoList);
        ModelAndView mv =new ModelAndView();
        mv.addObject("userList",userList);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/addUser.do")
    public String addUser(UserInfo userInfo){
        userService.addUser(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id){
        UserInfo user = userService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return mv;
    }
}
