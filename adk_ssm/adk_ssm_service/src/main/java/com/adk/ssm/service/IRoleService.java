package com.adk.ssm.service;

import com.adk.ssm.domain.Permissions;
import com.adk.ssm.domain.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> findAll();
    public void addRole(Role role);
    public Role findById(String id);
    public void deleteById(String id);
    public List<Permissions> findUserByIdAndAllRole(String id);
    public void deletePermissionsById(String pid,String rid);
    public void addPermissions(String[] pid,String rid);
}
