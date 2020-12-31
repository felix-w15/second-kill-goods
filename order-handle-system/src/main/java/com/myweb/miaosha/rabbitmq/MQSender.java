package com.myweb.miaosha.rabbitmq;

import com.myweb.miaosha.config.RabbitConfig;
import com.myweb.miaosha.entity.SecKillMsg;
import com.myweb.miaosha.entity.SecKillRes;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MQSender {
    @Autowired
    AmqpTemplate amqpTemplate;



    public byte[] getBytesFromObject(Serializable obj) throws  Exception {
        if(obj == null){
            return null;
        }
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(obj);
        return bo.toByteArray();
    }

    public void sendSeckillMsg(SecKillMsg secKillMsg) throws Exception {

        System.out.println("send order "+secKillMsg.getCustomerId()+" "+secKillMsg.getGoodId());

        amqpTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, RabbitConfig.ORDER_QUEUE, getBytesFromObject(secKillMsg));
    }

}
