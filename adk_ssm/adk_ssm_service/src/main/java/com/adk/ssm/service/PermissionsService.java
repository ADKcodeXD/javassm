package com.adk.ssm.service;

import com.adk.ssm.dao.PermissionsMapper;
import com.adk.ssm.domain.Permissions;
import com.adk.ssm.utils.UUIDutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionsService implements IPermissionsService {
    @Autowired
    private PermissionsMapper permissionsMapper;

    @Override
    public List<Permissions> findAll() {
        List<Permissions> permissionsList = permissionsMapper.findAll();
        return permissionsList;
    }

    @Override
    public void addPermissions(Permissions permissions) {
        permissions.setId("permissionsId"+UUIDutils.getUUID().replace("-","").substring(1,10));
        permissionsMapper.addPermissions(permissions);
    }

    @Override
    public Permissions findById(String id) {
        Permissions permissions = permissionsMapper.findById(id);
        return permissions;
    }

    @Override
    public void deletePermissionsById(String id) {
        permissionsMapper.deleteFromrole_permissions(id);
        permissionsMapper.deletePermissionsById(id);
    }

    @Override
    public void deleteRoleById(String pid, String rid) {
        permissionsMapper.deleteRoleById(pid, rid);
    }


}
