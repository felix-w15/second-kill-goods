package com.felix.backstage.service;

import com.felix.backstage.entity.AdminGroup;
import com.felix.backstage.mapper.AdminGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminGroupService {
    @Autowired
    AdminGroupMapper adminGroupMapper;

    public AdminGroup getAdminGroupById(int id){
        return adminGroupMapper.getAdminGroupById(id);
    }
}
