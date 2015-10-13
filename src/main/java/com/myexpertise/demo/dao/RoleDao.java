package com.myexpertise.demo.dao;

import com.myexpertise.demo.base.dao.Dao;
import com.myexpertise.demo.dataobject.RoleDO;

public interface RoleDao extends Dao<RoleDO>
{
    public RoleDO getRoleByIdentifier(String identifier);
}
