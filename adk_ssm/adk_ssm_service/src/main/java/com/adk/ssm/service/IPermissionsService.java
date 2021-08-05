package com.adk.ssm.service;

import com.adk.ssm.domain.Permissions;

import java.util.List;

public interface IPermissionsService {
    public List<Permissions> findAll();
    public void addPermissions(Permissions permissions);
    public Permissions findById(String id);
    public void deletePermissionsById(String id);
}
