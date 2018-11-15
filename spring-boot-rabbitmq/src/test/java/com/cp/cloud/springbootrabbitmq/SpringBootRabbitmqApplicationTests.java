package com.cp.cloud.springbootrabbitmq;

import com.cp.cloud.springbootrabbitmq.producer.MsgProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRabbitmqApplicationTests {

	@Autowired
	private MsgProducer msgProducer;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSend(){
		for(int i = 0; i < 10;i ++){
			msgProducer.sendMsg("第"+i+"个消息");
		}

	}
}
