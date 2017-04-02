package jdk.concurrent;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class CompletionExecutorTest {


	@Test
	public void test1() throws InterruptedException {
		ExecutorCompletionService<Integer> completionService = new ExecutorCompletionService<>(Executors.newCachedThreadPool());

		System.out.println(System.currentTimeMillis());
		for (int i = 0; i < 100; i++) {
			completionService.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					System.out.println("[" + Thread.currentThread().getName() + "]start: " + this);
					TimeUnit.SECONDS.sleep(3);
					System.out.println("[" + Thread.currentThread().getName() + "]finish: " + this);
					return 1;
				}
			});
		}

		Stopwatch started = Stopwatch.createStarted();
		System.out.println("waiting   > " + System.currentTimeMillis());
		for (int i = 0; i < 100; i++) {
			try {
				completionService.take().get(1, TimeUnit.MILLISECONDS);
			} catch (ExecutionException | TimeoutException e) {
				System.out.println("time out: " + i);
			}
		}
		System.out.println("end at > " + System.currentTimeMillis());
		System.out.println("took time :" + started.elapsed(TimeUnit.MILLISECONDS));

	}


}
