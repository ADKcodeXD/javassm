package com.adk.ssm.service;

import com.adk.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    public List<UserInfo> findAll(int page,int pagesize);
    public String addUser(UserInfo userInfo);
    public UserInfo findById(String id);
}
