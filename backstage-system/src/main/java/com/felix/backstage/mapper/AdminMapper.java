package com.felix.backstage.mapper;

import com.felix.backstage.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    Admin getAdminByName(String username);
    void updateAdmin(String username, String password);
}
