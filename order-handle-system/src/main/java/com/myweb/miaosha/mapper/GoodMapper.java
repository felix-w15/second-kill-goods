package com.myweb.miaosha.mapper;

import com.myweb.miaosha.entity.Good;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface GoodMapper {
    Good getGood(String goodName);
}
