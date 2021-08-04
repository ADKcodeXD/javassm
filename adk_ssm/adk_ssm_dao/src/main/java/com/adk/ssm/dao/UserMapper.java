package com.adk.ssm.dao;

import com.adk.ssm.domain.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    public UserInfo findByUsername(String username) throws Exception;
    public List<UserInfo> findAll();
    public void addUser(UserInfo userInfo);
    public UserInfo findById(String id);
}
