package com.myexpertise.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.myexpertise.demo.base.dao.AbstractBaseDao;
import com.myexpertise.demo.dataobject.RoleDO;

@Repository
public class RoleDaoImpl extends AbstractBaseDao<RoleDO> implements RoleDao
{
    public RoleDO getRoleByIdentifier(String identifier)
    {
       Query query = entityManager.createQuery("SELECT role FROM RoleDO role WHERE role.identifier= :identifier");
       query.setParameter("identifier", identifier);
       @SuppressWarnings("unchecked")
       List<RoleDO> roles = query.getResultList();
       if(roles != null && !roles.isEmpty())
       {
           return roles.get(0);
       }
       return null;
    }

}
