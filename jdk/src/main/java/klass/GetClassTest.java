package klass;

import org.junit.Test;

/**
 * Desc:
 * Created by wanggen on 2015-12-09 下午8:08.
 */
public class GetClassTest {


    @Test
    public void test(){
        // 100w 30 ms
        GetClassTest test = new GetClassTest();

        long start = System.currentTimeMillis();

        for(int i=1;i<=1000000;i++){
            Object.class.isAssignableFrom(test.getClass());
        }

        System.out.println(System.currentTimeMillis() - start);
    }

    public static <T> T get(Object val, T d){
        return (T) val;
    }

    @Test
    public void test2(){

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();


        String s = get(100, "");


    }


}
