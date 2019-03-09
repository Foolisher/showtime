package concurrent;

/**
 * Created by fuxiao(付笑) on 2018/6/1.
 */
public class ObjectNotify {

    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        final Thread[] t1 = {null};
        new Thread() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        t1[0] = Thread.currentThread();
                        System.out.println("t1 get lock");
                        lock.wait();
                        Thread.sleep(1000);
                        System.out.println("done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();


        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                    synchronized (lock) {
                        System.out.println("t2 get lock");
                        lock.notify();
                        System.out.println("notify ok");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.start();


        Thread thread = Thread.currentThread();
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                thread.interrupt();
            }
        }.start();

        Thread.sleep(20);
        t1[0].interrupt();

        try {
            Thread.sleep(100000);
        } catch (Exception e) {
            System.out.println(Thread.currentThread() + " 被中断跳出");
            e.printStackTrace();
        }
        System.out.println("运行结束！");

    }

}
