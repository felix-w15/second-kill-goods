package com.felix.backstage.service;

import com.felix.backstage.entity.Navigation;
import com.felix.backstage.mapper.NavigationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NavigationService {
    @Autowired
    NavigationMapper navigationMapper;

    public Navigation getNavigationById(int menuId){
        return navigationMapper.getNavigationById(menuId);
    }

    public List<Navigation> getNavigationByPId(int pid){
        return  navigationMapper.getNavigationByPId(pid);
    }
}
