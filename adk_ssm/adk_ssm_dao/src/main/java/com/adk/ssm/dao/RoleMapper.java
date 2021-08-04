package com.adk.ssm.dao;

import com.adk.ssm.domain.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
    public Role findAll();
}
