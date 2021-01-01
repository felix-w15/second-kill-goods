package com.felix.backstage.service;

import com.felix.backstage.entity.Log;
import com.felix.backstage.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    @Autowired
    LogMapper logMapper;

    public List<Log> getAllLog(){
        return logMapper.getAllLog();
    }
    public void insertLog(String url, String time, String username){
        logMapper.insertLog(url, time, username);
    }

}
