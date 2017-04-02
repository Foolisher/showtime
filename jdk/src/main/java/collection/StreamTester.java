package collection;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

/**
 * Desc:
 * Created by wanggen on 2015-12-16 下午12:47.
 */
public class StreamTester {


    @Test
    public void test(){

        // N: 8000
        // With no parallel took time:11100
        // With parallel took    time: 2689

        // N:2000
        // With no parallel took time:3182
        // With parallel took    time: 670


        ArrayList<Object> list = Lists.newArrayListWithCapacity(10000);
        for(int i=1;i<=2000;i++)
            list.add(i);

        long start = System.currentTimeMillis();
        list.forEach((a) -> {
            try {
//                System.out.println(Thread.currentThread().getId());
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("With no parallel took time:"+(System.currentTimeMillis()-start));


        start = System.currentTimeMillis();
        list.parallelStream().forEach((a) -> {
            try {
//                System.out.println(Thread.currentThread().getId());
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("With parallel took time:"+(System.currentTimeMillis()-start));

    }


    @Test
    public void test2(){

        ArrayList<String> strings = Lists.newArrayList("1", "3", "5", "100");

        Object collect = strings.stream()
                .collect(Collectors.joining(","));

        Map<Long, List<String>> collect1 = strings.stream().collect(Collectors.groupingBy((a) -> Long.valueOf(a) % 2));
        System.out.println(collect1);

        Optional<String> reduce = strings.stream().reduce((a, b) -> a +","+ b);
        System.out.println(reduce);

        System.out.println(Stream.of().reduce((a, b)->a+","+b));

        System.out.println(collect);



        strings.stream().collect(new Collector<String, Object, Object>() {
            @Override
            public Supplier<Object> supplier() {
                return null;
            }

            @Override
            public BiConsumer<Object, String> accumulator() {
                return null;
            }

            @Override
            public BinaryOperator<Object> combiner() {
                return null;
            }

            @Override
            public Function<Object, Object> finisher() {
                return null;
            }

            @Override
            public Set<Characteristics> characteristics() {
                return null;
            }
        });




    }



    @Test
    public void test3(){
        // len:100000
        // 看来 Stream 太慢了啊

        int len = 100000;

        String[] arr = new String[len];
        for(int i=0;i<len;i++)
            arr[i] = i+"";

        Lists.transform(Lists.newArrayList(), a->a);

        long start = System.currentTimeMillis();
        Lists.transform(Lists.newArrayList(arr), new com.google.common.base.Function<String,Long>() {
            @Override
            public Long apply(String input) {
                return Long.valueOf(input);
            }
        });
        System.out.println("1:"+(System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        Stream.of(arr).mapToLong(Long::valueOf).toArray();
        System.out.println("2:"+(System.currentTimeMillis()-start));

    }





}
