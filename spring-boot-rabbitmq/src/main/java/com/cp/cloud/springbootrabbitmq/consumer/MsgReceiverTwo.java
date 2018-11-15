package com.cp.cloud.springbootrabbitmq.consumer;

import com.cp.cloud.springbootrabbitmq.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Description: 消费者
 *
 * @author chenpeng
 * @date 2018/11/15 16:14
 */
@Component
@RabbitListener(queues = RabbitConfig.QUEUE_A)
public class MsgReceiverTwo {

   /* @RabbitHandler
    public void process(String content){
        System.out.println("消费者2 接受处理A队列中的消息：" + content);
    }*/
}
