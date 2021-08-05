package com.adk.ssm.service;

import com.adk.ssm.dao.RoleMapper;
import com.adk.ssm.domain.Role;
import com.adk.ssm.utils.UUIDutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public void addRole(Role role) {
        role.setId("Role"+UUIDutils.getUUID().replace("-","").substring(1,5));
        roleMapper.addRole(role);
    }

    @Override
    public Role findById(String id) {
        Role role = roleMapper.findById(id);
        return role;
    }

    @Override
    public void deleteById(String id) {
        roleMapper.deleteFromrole_user(id);
        roleMapper.deleteFromrole_permissions(id);
        roleMapper.deleteById(id);
    }
}
