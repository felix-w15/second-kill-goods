package com.felix.backstage.mapper;

import com.felix.backstage.entity.Navigation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NavigationMapper {
    Navigation getNavigationById(int menuId);
    List<Navigation> getNavigationByPId(int pid);
}
