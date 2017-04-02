package string;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Desc:
 * Created by wanggen on 2015-12-31 下午1:59.
 */
public class StringTest {

    @Test
    public void test(){

        String[]  arr;

        long start = System.currentTimeMillis();
        for(int i=1;i<=100;i++){

            //Stream<String> stringStream = Stream.of("a", "b", "", null).filter((t) -> !Strings.isNullOrEmpty(t));
            //Object[] objects = stringStream.toArray();
            //arr = new String[objects.length];
            //System.arraycopy(objects, 0, arr, 0 , (int) objects.length);

            ArrayList<String> arr2 = Lists.newArrayList();
            for (String type : new String[]{"", null}) {
                if (!com.google.common.base.Strings.isNullOrEmpty(type))
                    arr2.add(type);
            }
            String[] strings = arr2.toArray(new String[arr2.size()]);

        }
        System.out.println(System.currentTimeMillis()-start);

//        System.out.println(arr);


        ArrayList<String> arr2 = Lists.newArrayList();
        for (String type : new String[]{"", null}) {
            if (!com.google.common.base.Strings.isNullOrEmpty(type))
                arr2.add(type);
        }
        String[] strings = arr2.toArray(new String[arr2.size()]);

        System.out.println(strings);


    }


    @Test
    public void test2(){

        String a = "replyToUserId2442320352appName二手宝贝XT_content我有红米2了targetKey526570626017XT_title么么哒3s全网通&hellip;&hellip;appId1100029replyToCommentId1407678765commentIndex5commentContentType2typeId101";

        System.out.println(a);


    }





}
