package com.adk.ssm.dao;

import com.adk.ssm.domain.Permissions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionsMapper {
    public List<Permissions> findAll();
    public void addPermissions(Permissions permissions);
    public Permissions findById(String id);
    public void deletePermissionsById(String id);
    public void deleteFromrole_permissions(String id);
    public void deleteRoleById(@Param(value = "pid")String pid, @Param(value = "rid")String rid);

}
