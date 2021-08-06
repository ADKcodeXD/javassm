package com.adk.ssm.controller;


import com.adk.ssm.dao.PermissionsMapper;
import com.adk.ssm.domain.Permissions;
import com.adk.ssm.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permissions")
public class PermissionsController {

    @Autowired
    private PermissionsService permissionsService;


    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        List<Permissions> permissionsList = permissionsService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("permissionsList",permissionsList);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/addPermissions.do")
    public String addPermissions(Permissions permissions){
        permissionsService.addPermissions(permissions);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(value = "id")String id){
        Permissions permissions = permissionsService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("permissions",permissions);
        mv.setViewName("permission-show");
        return mv;
    }

    @RequestMapping("/deletePermissionsById.do")
    public String deletePermissionsById(@RequestParam(value = "permissionsId")String permissionsId){
        permissionsService.deletePermissionsById(permissionsId);
        return "redirect:findAll.do";
    }

    @RequestMapping("deleteRoleById.do")
    public String deleteRoleById(@RequestParam(value = "permissionsId")String permissionsId,@RequestParam(value = "roleId")String roleId){
        permissionsService.deleteRoleById(permissionsId,roleId);
        return "redirect:findAll.do";
    }
}
