package com.cec.tv.live;

import com.cec.tv.dao.RoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LiveApplicationTests {

	@Test
	public void contextLoads() {
		String time = "23:59:50";
		String s = time.split(":")[2];
		System.out.println("-------" + s + "-------");
	}



}
