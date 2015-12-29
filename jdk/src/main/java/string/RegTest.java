package string;

import org.junit.Test;

import java.net.URI;
import java.util.regex.Pattern;

/**
 * Desc:
 * Created by wanggen on 2015-12-24 下午5:32.
 */
public class RegTest {


    @Test
    public void test() {
        // 1w   ==> 9ms
        // 10w  ==> 56ms
        // 100w ==> 350ms
        // 1000w==> 1250ms

        Pattern pattern = Pattern.compile("^[\\u4e00-\\u9fa5A-Za-z0-9-_]*$");

        long start = System.currentTimeMillis();
        for (int i = 1; i <= 10000; i++) {
            pattern.matcher("我是10001010000033333333_____");
        }
        System.out.println(System.currentTimeMillis() - start);

    }

    @Test
    public void test2() {

        // 1w       ==>     10ms
        // 100w     ==>     94ms

        Pattern pattern = Pattern.compile("\\d+");

        long start = System.currentTimeMillis();
        for (int i = 1; i <= 1000000; i++) {
            pattern.matcher("我是10001010000033333333_____");
        }
        System.out.println(System.currentTimeMillis() - start);

    }


    @Test
    public void test3(){

        URI uri = URI.create("module://hello/a/b/c");

        String path = uri.getPath();

        System.out.println(uri.getRawPath());

        System.out.println(uri.getFragment());

        System.out.println(uri.getScheme());

    }



}
