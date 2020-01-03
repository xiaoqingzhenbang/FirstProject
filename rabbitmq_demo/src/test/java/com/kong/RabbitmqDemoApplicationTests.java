package com.kong;

import com.kong.springboot.producer.Producer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitmqDemoApplicationTests {

	@Autowired
	private Producer producer;

	@Test
	public void contextLoads() {
		producer.sendMsg();
	}

}
