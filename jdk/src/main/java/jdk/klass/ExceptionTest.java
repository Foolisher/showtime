package jdk.klass;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Desc:
 * Created by wanggen on 2016-03-28 下午4:57.
 */
public class ExceptionTest {


	ExecutorService executorService = Executors.newFixedThreadPool(1000);


	@Test
	public void test1() {


		Stopwatch started = Stopwatch.createStarted();
		for (int i = 0; i < 100000; i++) {
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					try {
						m1();
					} catch (Exception e) {

					}
				}
			});

		}
		System.out.println(started.elapsed(TimeUnit.MILLISECONDS)); // 514ms


		started = Stopwatch.createStarted();
		for (int i = 0; i < 100000; i++) {
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					m2();
				}
			});
		}
		System.out.println(started.elapsed(TimeUnit.MILLISECONDS)); // 136ms

		// 总结:可以放心的使用抛出异常的方式来结束当前线程,繁琐的return令人生厌

	}

	private void m2() {
		return;
	}

	private void m1() throws Exception {
		throw new Exception("");
	}


}
