package com.adk.ssm.service;

import com.adk.ssm.dao.UserMapper;
import com.adk.ssm.domain.Role;
import com.adk.ssm.domain.UserInfo;
import com.adk.ssm.utils.UUIDutils;
import com.github.pagehelper.PageHelper;
import javafx.beans.property.SimpleListProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo=null;
        try {
            userInfo = userMapper.findByUsername(username);
            System.out.println(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //通过他的User对象封装成userdetails 并返回
        User user=new User(userInfo.getUsername(),userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll(int page,int pageszie) {
        PageHelper.startPage(page,pageszie);
        return userMapper.findAll();
    }

    @Override
    public String addUser(UserInfo userInfo) {
        userInfo.setId("userId"+UUIDutils.getUUID().replace("-","").substring(1,10));
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        userMapper.addUser(userInfo);
        return null;
    }

    @Override
    public UserInfo findById(String id) {
        return userMapper.findById(id);

    }


}
