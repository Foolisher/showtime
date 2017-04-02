package google;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import junit.framework.TestCase;

import java.util.concurrent.Executors;

/**
 * Created by wanggen/付笑 on 2016-06-15.
 */
public class ConcurrentTest extends TestCase {


	public void test1() {
		ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));


		ListenableFuture<Long> f = service.submit(System::currentTimeMillis);
		Futures.addCallback(f, new FutureCallback<Object>() {
			public void onSuccess( Object result) {
				System.out.println(result);
			}

			public void onFailure(Throwable t) {

			}
		});

	}

}
