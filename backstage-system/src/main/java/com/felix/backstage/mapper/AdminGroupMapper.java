package com.felix.backstage.mapper;

import com.felix.backstage.entity.AdminGroup;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminGroupMapper {
    AdminGroup getAdminGroupById(int id);
}
