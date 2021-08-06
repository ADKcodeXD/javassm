package com.adk.ssm.dao;

import com.adk.ssm.domain.Role;
import com.adk.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    public UserInfo findByUsername(String username) throws Exception;
    public List<UserInfo> findAll();
    public void addUser(UserInfo userInfo);
    public UserInfo findById(String id);
    public List<Role> findOtherRoles(@Param(value = "userId") String userId);
    public void addRoleToUser(@Param(value = "userId")String userId,@Param(value = "roleId") String roleId);
}
