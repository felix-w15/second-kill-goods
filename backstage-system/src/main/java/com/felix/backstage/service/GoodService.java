package com.felix.backstage.service;

import com.felix.backstage.entity.Good;
import com.felix.backstage.mapper.GoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService {
    @Autowired
    GoodMapper goodMapper;

    public Good getGoodByName(String goodName){
        return goodMapper.getGoodByName(goodName);
    }

    public Good getGoodById(int id){
        return goodMapper.getGoodById(id);
    }

    public void insertGood(String goodName, int goodNum){
        goodMapper.insertGood(goodName, goodNum);
    }

    public List<Good> findAllGood(){
        return goodMapper.findAllGood();
    }

    public void delGood(String goodName){
        goodMapper.delGood(goodName);
    }
}
