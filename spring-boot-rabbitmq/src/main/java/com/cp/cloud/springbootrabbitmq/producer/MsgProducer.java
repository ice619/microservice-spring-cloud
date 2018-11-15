package com.cp.cloud.springbootrabbitmq.producer;

import com.cp.cloud.springbootrabbitmq.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Description: 消息生产者
 *
 * @author chenpeng
 * @date 2018/11/15 15:44
 */
@Component
public class MsgProducer implements RabbitTemplate.ConfirmCallback{

    private RabbitTemplate rabbitTemplate;

    public MsgProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
        //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
        rabbitTemplate.setConfirmCallback(this);
    }

    public void sendMsg(String content){
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());

        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A,RabbitConfig.ROUTINGKEY_A,content,correlationId);

    }

    /**
     * 回调
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("回调id：" + correlationData);
        if(ack){
            System.out.println("消息成功消费");
        }else {
            System.out.println("消息消费失败：" + cause);
        }

    }
}
