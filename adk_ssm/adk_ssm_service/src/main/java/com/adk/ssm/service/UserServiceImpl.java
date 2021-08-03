package com.adk.ssm.service;

import com.adk.ssm.dao.UserMapper;
import com.adk.ssm.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        } catch (Exception e) {
            e.printStackTrace();
        }
        //通过他的User对象封装成userdetails 并返回
        User user=new User(userInfo.getUsername(),userInfo.getPassword(),null);
        return user;
    }
}
