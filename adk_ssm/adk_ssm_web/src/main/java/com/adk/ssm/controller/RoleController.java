package com.adk.ssm.controller;

import com.adk.ssm.domain.Role;
import com.adk.ssm.domain.UserInfo;
import com.adk.ssm.service.IRoleService;
import com.adk.ssm.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(value = "page",defaultValue = "1")int page,@RequestParam(value = "pagesize",defaultValue = "4")int pagesize){
        List<Role> roleList=roleService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/addRole.do")
    public String addRole(Role role){
        roleService.addRole(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(value = "id")String id){
        Role role = roleService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }

    @RequestMapping("/deleteById.do")
    public String deleteById(@RequestParam(value = "id")String id){
        roleService.deleteById(id);
        return "redirect:findAll.do";
    }

}
