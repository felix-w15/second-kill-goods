package com.felix.backstage.mapper;

import com.felix.backstage.entity.Good;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodMapper {
    Good getGoodByName(String goodName);

    Good getGoodById(int id);


    void insertGood(String goodName, int goodNum);

    List<Good> findAllGood();

    void delGood(String goodName);
}
