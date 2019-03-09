package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by fuxiao(付笑) on 2018/6/2.
 */
public class ConditionTest {

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock();
        Condition     cond = lock.newCondition();

        lock.lock();

        cond.await();

        cond.signal();

    }

}
