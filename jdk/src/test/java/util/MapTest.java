package util;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by fuxiao(付笑) on 2018/1/10.
 */
public class MapTest {

    @Test
    public void testMapGet() {


        int       times   = 1000000;
        Stopwatch started = Stopwatch.createStarted();

        HashMap<Object, Object> map = Maps.newHashMap();
        for (int i = 0; i < times; i++) {
            map.put(new Random().nextLong() + "", i);
        }
        System.out.println(times + " 次Map#put 耗时: " + started.elapsed(TimeUnit.MILLISECONDS) + " ms");


        started = Stopwatch.createStarted();
        for (int i = 0; i < times; i++) {
            map.get("1000000");
        }
        System.out.println(times + " 次Map#get 耗时: " + started.elapsed(TimeUnit.MILLISECONDS) + " ms");

        // 1000000 次Map#get 耗时: 16 ms
        // 100000  次Map#get 耗时: 4 ms
        // 10000   次Map#get 耗时: 1 ms

    }
}
