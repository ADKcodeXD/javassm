package com.adk.ssm.dao;

import com.adk.ssm.domain.Permissions;

import java.util.List;

public interface PermissionsMapper {
    public List<Permissions> findAll();
    public void addPermissions(Permissions permissions);
    public Permissions findById(String id);
    public void deletePermissionsById(String id);
    public void deleteFromrole_permissions(String id);

}
