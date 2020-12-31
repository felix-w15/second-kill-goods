package com.myweb.miaosha.rabbitmq;

import com.myweb.miaosha.config.RabbitConfig;
import com.myweb.miaosha.entity.Good;
import com.myweb.miaosha.entity.SecKillMsg;
import com.myweb.miaosha.service.GoodService;
import com.myweb.miaosha.service.OrderService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;

@Service
public class MQRecevier {
    @Autowired
    AmqpTemplate amqpTemplate;

    @Autowired
    OrderService orderService;

    @Autowired
    GoodService goodService;

    public Object getObjectFromBytes(byte[] objBytes) throws  Exception{
        if(objBytes == null || objBytes.length == 0){
            return null;
        }
        ByteArrayInputStream bi = new ByteArrayInputStream(objBytes);
        ObjectInputStream oi = new ObjectInputStream(bi);
        return oi.readObject();
    }


    @Transactional
    @RabbitListener(queues = RabbitConfig.ORDER_QUEUE)
    public void receive(byte[] bytes) throws Exception{
        SecKillMsg secKillMsg = (SecKillMsg)getObjectFromBytes(bytes);
        Good g = goodService.getGoodById(secKillMsg.getGoodId());
        if(g.getGoodRemainNum() > 0) {
            orderService.putOrder(secKillMsg.getCustomerId(), secKillMsg.getGoodId());
            goodService.updateGood(g.getId(), g.getGoodName(), g.getGoodTotalNum(), g.getGoodRemainNum()-1);
        }
        System.out.println(secKillMsg.getCustomerId()+" "+secKillMsg.getGoodId());
    }
}
