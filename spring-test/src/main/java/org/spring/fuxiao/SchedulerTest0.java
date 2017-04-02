package org.spring.fuxiao;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Desc:
 * Created by wanggen on 2016-03-05 下午1:14.
 */
public class SchedulerTest0 {

	ClassPathXmlApplicationContext context = null;

//	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath*:context.xml");
		context.start();
	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/context.xml");
		context.getBean("scheduler");

	}


//	@Test
	public void testDoSomething() throws Exception {
		context.getBean("Scheduler");
//		TimeUnit.SECONDS.sleep(10000);
	}
}