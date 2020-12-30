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
}
