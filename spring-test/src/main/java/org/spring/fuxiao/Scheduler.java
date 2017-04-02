package org.spring.fuxiao;

import org.joda.time.DateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Desc:
 * Created by wanggen on 2016-03-05 上午11:50.
 */
@Service("Scheduler")
public class Scheduler {

	public void Scheduler() {
		System.out.println("init ");
	}

	@Scheduled(cron = "* * * * * ?")
	public void doSomething() {
		System.out.println(DateTime.now().toString());
	}

}
