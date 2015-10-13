package com.myexpertise.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myexpertise.demo.dao.RoleDao;
import com.myexpertise.demo.dataobject.RoleDO;

@Service
public class RoleServiceImpl implements RoleService
{
    @Autowired
    private RoleDao roleDao;

    public RoleDO getRoleByIdentifier(String identifier)
    {
        return roleDao.getRoleByIdentifier(identifier);
    }

}
