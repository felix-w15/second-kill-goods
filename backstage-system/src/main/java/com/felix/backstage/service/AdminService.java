package com.felix.backstage.service;

import com.felix.backstage.entity.Admin;
import com.felix.backstage.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    public Admin getAdminByName(String username){
        return adminMapper.getAdminByName(username);
    }

    public void updateAdmin(String username, String password){
        adminMapper.updateAdmin(username, password);
    }

}
