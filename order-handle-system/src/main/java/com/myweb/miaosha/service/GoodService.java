package com.myweb.miaosha.service;

import com.myweb.miaosha.entity.Good;
import com.myweb.miaosha.mapper.GoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GoodService {
    @Autowired
    GoodMapper goodMapper;

    public Good getGood(String goodName){
        return goodMapper.getGood(goodName);
    }

    public Good getGoodById(int id){
        return goodMapper.getGoodById(id);
    }

    public void updateGood(int id, String goodName, int totalNum, int remainNum){
        goodMapper.updateGood(id, goodName, totalNum, remainNum);
    }
}
