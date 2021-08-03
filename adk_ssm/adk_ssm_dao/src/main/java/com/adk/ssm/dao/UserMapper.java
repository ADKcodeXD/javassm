package com.adk.ssm.dao;

import com.adk.ssm.domain.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {


    public UserInfo findByUsername(String username) throws Exception;
}
