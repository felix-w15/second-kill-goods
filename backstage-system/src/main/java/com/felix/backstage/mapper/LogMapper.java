package com.felix.backstage.mapper;

import com.felix.backstage.entity.Log;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogMapper {
    List<Log> getAllLog();

    void insertLog(String url, String time, String username);
}
