package com.adk.ssm.dao;

import com.adk.ssm.domain.Role;
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
}
