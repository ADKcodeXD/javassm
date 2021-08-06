package com.adk.ssm.dao;

import com.adk.ssm.domain.Permissions;
import com.adk.ssm.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    public List<Role> findAll();
    public void addRole(Role role);
    public Role findById(String id);
    public void deleteById(String id);
    public void deleteFromrole_user(String id);
    public void deleteFromrole_permissions(String id);
    public List<Permissions> findUserByIdAndAllRole(String id);
    public void deletePermissionsById(@Param(value = "pid")String pid,@Param(value = "rid")String rid);
    public void addPermissions(@Param(value = "pid") String pid, @Param(value = "rid")String rid);
}
